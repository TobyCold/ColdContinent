package love.iloveworld.continent.event;


import love.iloveworld.continent.MainMod;

import love.iloveworld.continent.command.GetPlayerProperties;
import love.iloveworld.continent.command.GetPosition;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = MainMod.MODID)
public class ForgeEventListener {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        GetPlayerProperties.register(event.getDispatcher());
        GetPosition.register(event.getDispatcher());
    }

}
