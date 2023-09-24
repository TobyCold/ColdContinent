package love.iloveworld.continent.event;


import love.iloveworld.continent.MainMod;
import love.iloveworld.continent.capability.PlayerPropertiesProvider;
import love.iloveworld.continent.notword.Channel;
import love.iloveworld.continent.overlay.PlayerPropertiesOverlay;
import love.iloveworld.continent.overlay.PositionOverlay;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.security.PublicKey;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MainMod.MODID)
public class ModEventListener {

    /**
     * 注册能力
     *
     * @param event
     */
    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event) {
        event.register(PlayerPropertiesProvider.class);
    }

    @SubscribeEvent
    public static void registerOverlay(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.HOTBAR.id(), "player_properties", PlayerPropertiesOverlay.I_GUI_OVERLAY);
        event.registerAbove(VanillaGuiOverlay.HOTBAR.id(), "player_position", PositionOverlay.OVERLAY);
    }

    @SubscribeEvent
    public static void registerChannel(FMLCommonSetupEvent event) {
        Channel.register();
    }

}
