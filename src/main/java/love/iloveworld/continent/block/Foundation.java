package love.iloveworld.continent.block;


import love.iloveworld.continent.MainMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class Foundation extends Item {

    public  final Location Protection_One = new Location(7,7,3);
    public  final Location Protection_Two = new Location(13,13,7);
    public  final Location Protection_Three = new Location(25,25,13);
    public Foundation(Properties p_41383_) {
        super(p_41383_);
    }
    private class Location{
        private int X;
        private int Y;
        private int Z;
        private Location(){}

        public Location(int x, int y, int z) {
            X = x;
            Y = y;
            Z = z;
        }
    }
    @Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    private class Event{
        @SubscribeEvent
        public static void  breakBlock(BlockEvent.BreakEvent event){

        }
    }
}
