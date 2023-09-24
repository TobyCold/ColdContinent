package love.iloveworld.continent.event;


import love.iloveworld.continent.MainMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerBehavior {
    @SubscribeEvent
    public static void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player entity = event.getEntity();
        entity.sendSystemMessage(Component.literal("Hello World"));

    }

}
