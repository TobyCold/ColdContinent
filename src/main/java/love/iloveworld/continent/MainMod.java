package love.iloveworld.continent;

import com.mojang.logging.LogUtils;
import love.iloveworld.continent.block.Foundation;
import love.iloveworld.continent.item.Jammer;
import love.iloveworld.continent.item.Protection;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;


@Mod(MainMod.MODID)
public class MainMod {

    public static final String MODID = "coldcontinent";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block> myBlock = BLOCKS.register("myblock", () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.CROP)));
    public static final RegistryObject<Item> myBlockItem = ITEMS.register("myblock", () -> new BlockItem(myBlock.get(), new Item.Properties()));

    public static final RegistryObject<Block> foundation = BLOCKS.register("foundation", () -> new Block(BlockBehaviour.Properties.of().strength(10.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Item> foundationItem = ITEMS.register("foundation", () -> new BlockItem(foundation.get(), new Item.Properties()));

    public static final RegistryObject<Item> protection = ITEMS.register("protection", () -> new Protection(new Item.Properties()));
    public static final RegistryObject<Item> jammer = ITEMS.register("jammer", () -> new Jammer(new Item.Properties()));


    /**
     * 注册创造物品栏
     */
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    /**
     * 创造物品栏
     */
    public static final RegistryObject<CreativeModeTab> tab = TAB.register("world", () -> CreativeModeTab.builder().title(Component.translatable("mco.create.world")).icon(() -> new ItemStack(foundation.get())).displayItems((parm, output) -> {

        //创造物品栏world
        output.accept(myBlock.get());
        output.accept(foundation.get());
        output.accept(protection.get());
        output.accept(jammer.get());
    }).build());

    /**
     * 方块和物品及其他注册
     */
    public MainMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TAB.register(modEventBus);
    }
}
