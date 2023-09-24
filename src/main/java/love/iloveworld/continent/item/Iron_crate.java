package love.iloveworld.continent.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import static love.iloveworld.continent.MainMod.DEBUG;
import static love.iloveworld.continent.MainMod.iron_crate;

public class Iron_crate extends Item {
    public Iron_crate(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext use) {
        Level level = use.getLevel();
        ItemStack itemInHand = use.getItemInHand();


        if (iron_crate.get() == itemInHand.getItem()) {

            Player player = use.getPlayer();
            if (DEBUG) {
                player.sendSystemMessage(Component.literal("[调试]click成功"));
            }
            player.addItem(new ItemStack(Items.COOKED_COD));
            itemInHand.shrink(1);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(use);

    }

}
