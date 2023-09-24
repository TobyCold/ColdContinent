package love.iloveworld.continent.notword;

import love.iloveworld.continent.MainMod;
import love.iloveworld.continent.notword.packet.server.PropertiesPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Channel {
    private static final String PROTOCOL_VERSION = "1";
    private static int id = 0;
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MainMod.MODID, "playerproperties"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register(){
        INSTANCE.messageBuilder(PropertiesPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PropertiesPacket::new)
                .encoder(PropertiesPacket::encode)
                .consumerMainThread(PropertiesPacket::handle)
                .add();
    }

    public static <MSG> void sendToProperties(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(()->player), message);
    }
}
