package love.iloveworld.continent;

import com.mojang.logging.LogUtils;
import love.iloveworld.continent.block.FoundationBlock;
import love.iloveworld.continent.capability.PlayerPropertiesProvider;
import love.iloveworld.continent.config.PlayerPropertiesConfig;
import love.iloveworld.continent.item.*;
import love.iloveworld.continent.register.BlockRegister;
import love.iloveworld.continent.register.ItemRegister;
import love.iloveworld.continent.register.ModeTabRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;


@Mod(MainMod.MODID)
public class MainMod {

    public static final String MODID = "coldcontinent";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static boolean DEBUG = true;




    /**
     * 将注册表注册到总线
     */

    public MainMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegister.BLOCKS.register(modEventBus);
        ItemRegister.ITEMS.register(modEventBus);
        ModeTabRegister.TAB.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PlayerPropertiesConfig.spec);

        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, this::attachCapability);
    }

    /**
     * 将能力附加到玩家也就是entity
     *
     * @param event
     */

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {
            if (!player.getCapability(PlayerPropertiesProvider.PLAYER_PROPERTIES_CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(MODID, "formmp"), new PlayerPropertiesProvider());
            }
        }
    }
}
