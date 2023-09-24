package love.iloveworld.continent.notword.packet.server;

import love.iloveworld.continent.capability.PlayerPropertiesProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.Map;
import java.util.function.Supplier;

public class PropertiesPacket {
    private final float immunity;
    private final float moisture;
    private final float spirit;


    public PropertiesPacket(float immunity, float moisture, float spirit) {
        this.immunity = immunity;
        this.moisture = moisture;
        this.spirit = spirit;
    }

    public PropertiesPacket(FriendlyByteBuf buf) {
        immunity = buf.readFloat();
        moisture = buf.readFloat();
        spirit = buf.readFloat();

    }

    public void encode(FriendlyByteBuf buf){
      buf.writeFloat(immunity);
      buf.writeFloat(moisture);
      buf.writeFloat(spirit);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        PlayerPropertiesProvider.immunity = immunity;
        PlayerPropertiesProvider.moisture = moisture;
        PlayerPropertiesProvider.spirit = spirit;
        context.setPacketHandled(true);
        return true;
    }


}
