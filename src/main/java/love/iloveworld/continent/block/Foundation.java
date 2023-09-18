package love.iloveworld.continent.block;


import love.iloveworld.continent.MainMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;


public class Foundation extends Block {


    private int BORDER_X;
    private int BORDER_Y;
    private int BORDER_Z;
    private Player KING;
    private Set<Player> participant;


    public Foundation() {
        super(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.CROP));
    }


    private class Location {
        private int X;
        private int Y;
        private int Z;

        private Location() {
        }

        public Location(int x, int y, int z) {
            X = x;
            Y = y;
            Z = z;
        }
    }

    @Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    private class Event {
        /**
         * 破坏方块
         * @param event
         */
        @SubscribeEvent
        public static void breakBlock(BlockEvent.BreakEvent event) {

        }

        /**
         * 右击方块
         * @param event
         */
        @SubscribeEvent
        public static void rightClick(PlayerInteractEvent.RightClickBlock event) {
            Player player = event.getEntity();
        }
    }
}
