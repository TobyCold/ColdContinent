package love.iloveworld.continent.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static love.iloveworld.continent.MainMod.myBlock;

public class Duihuanquan extends Item {
    public Duihuanquan(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResult useOn(UseOnContext useOnContext){
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if(block == myBlock.get()){
            Player player = useOnContext.getPlayer();
            player.addItem(new ItemStack(Items.COOKED_COD));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(useOnContext);
    }
}
