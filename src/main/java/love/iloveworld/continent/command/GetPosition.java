package love.iloveworld.continent.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.server.ServerLifecycleHooks;

public class GetPosition {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("xyz").executes((context) -> {
            ServerPlayer player = context.getSource().getPlayer();

            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            long x = Math.round(player.getX());
            long y = Math.round(player.getY());
            long z = Math.round(player.getZ());

            player.sendSystemMessage(Component.literal(player.getName() + "展示了自己的坐标：" + (int) x + (int) y + (int) z));
            return 0;
        }));
    }
}
