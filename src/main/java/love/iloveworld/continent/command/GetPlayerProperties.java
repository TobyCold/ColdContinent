package love.iloveworld.continent.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import love.iloveworld.continent.capability.PlayerProperties;
import love.iloveworld.continent.capability.PlayerPropertiesProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.util.NonNullConsumer;
import org.jetbrains.annotations.NotNull;


public class GetPlayerProperties {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("properties").executes(new Command<CommandSourceStack>() {
            @Override
            public int run(CommandContext<CommandSourceStack> context) {
                context.getSource().getPlayer().getCapability(PlayerPropertiesProvider.PLAYER_PROPERTIES_CAPABILITY).ifPresent(new NonNullConsumer<PlayerProperties>() {
                    @Override
                    public void accept(@NotNull PlayerProperties playerProperties) {
                        context.getSource().getPlayer().sendSystemMessage(Component.literal("水分：" + playerProperties.getMoisture() + "," +
                                "精神：" + playerProperties.getSpirit() + "," + "免疫" + playerProperties.getImmunity()
                        ));
                    }

                });
                return 0;
            }

        }));
    }
}
