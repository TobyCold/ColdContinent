package love.iloveworld.continent.register;

import love.iloveworld.continent.block.FoundationBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static love.iloveworld.continent.MainMod.MODID;


public class BlockRegister {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> myBlock = BLOCKS.register("myblock", () ->
            new Block(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.CROP)));

    public static final RegistryObject<Block> foundation = BLOCKS.register("foundation", FoundationBlock::new);

}
