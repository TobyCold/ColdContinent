package love.iloveworld.continent.event;

import love.iloveworld.continent.MainMod;
import love.iloveworld.continent.capability.PlayerProperties;
import love.iloveworld.continent.capability.PlayerPropertiesProvider;
import love.iloveworld.continent.notword.Channel;
import love.iloveworld.continent.notword.packet.server.PropertiesPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.NonNullConsumer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroup;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerPropertiesEvent {
    /**
     * 玩家属性添加
     *
     * @param event
     */

    @SubscribeEvent
    public static void addImmunity(BlockEvent.BreakEvent event) {

        Player player = event.getPlayer();
        if (!player.getCommandSenderWorld().isClientSide && Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            player.getCapability(PlayerPropertiesProvider.PLAYER_PROPERTIES_CAPABILITY).ifPresent(
                    (p) -> {
                        if (p.getImmunity() <= 99) {
                            p.add(1);
                            Channel.sendToProperties(new PropertiesPacket(p.getImmunity(), p.getMoisture(), p.getSpirit()), (ServerPlayer) player);
                            player.sendSystemMessage(Component.literal("水分：" + p.getMoisture() + "," +
                                    "精神：" + p.getSpirit() + "," + "免疫" + p.getImmunity()));
                        }
                    }
            );
        }
    }

    /**
     * 玩家属性消耗
     */

    @SubscribeEvent
    public static void consumeProperties(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (player.isSprinting() && Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
                player.getCapability(PlayerPropertiesProvider.PLAYER_PROPERTIES_CAPABILITY).ifPresent((p)->{
                    if(p.getImmunity() > 0){
                        p.shrink(0.01F);
                        Channel.sendToProperties(new PropertiesPacket(p.getImmunity(), p.getMoisture(), p.getSpirit()), (ServerPlayer) player);
                        player.sendSystemMessage(Component.literal("水分：" + p.getMoisture() + "," +
                                "精神：" + p.getSpirit() + "," + "免疫" + p.getImmunity()));
                    }
                });
            }

        }
    }


    /**
     * 死亡掉落生成墓碑
     */
    @SubscribeEvent
    public static void generateTombstone(LivingDropsEvent event) {
        if (event.getEntity() instanceof Player player) {
            Inventory inventory = player.getInventory();

            Level level = player.getCommandSenderWorld();
            if (!level.isClientSide) {
                BlockPos location = player.getOnPos();

                while (level.getBlockState(location).getBlock() != Blocks.AIR) {
                    location = location.offset(0, 1, 0);
                }
                level.setBlock(location, Blocks.CHEST.defaultBlockState(), 2);

                if (level.getBlockEntity(location) instanceof ChestBlockEntity chest) {
                    for (int i = 0; i < inventory.getContainerSize(); i++) {
                        chest.setItem(i, inventory.getItem(i));
                    }
                }
            }


        }
    }

    @SubscribeEvent
    public static void loadGame(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

          player.getCapability(PlayerPropertiesProvider.PLAYER_PROPERTIES_CAPABILITY).ifPresent(new NonNullConsumer<PlayerProperties>() {
              @Override
              public void accept(@NotNull PlayerProperties p) {
                  if(p.getImmunity() > 0){
                      p.shrink(0.01F);
                      Channel.sendToProperties(new PropertiesPacket(p.getImmunity(), p.getMoisture(), p.getSpirit()), (ServerPlayer) player);
                      player.sendSystemMessage(Component.literal("水分：" + p.getMoisture() + "," +
                              "精神：" + p.getSpirit() + "," + "免疫" + p.getImmunity()));
                  }
              }
          });


    }


}
