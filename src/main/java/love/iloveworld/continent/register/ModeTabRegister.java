package love.iloveworld.continent.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static love.iloveworld.continent.MainMod.MODID;
import static love.iloveworld.continent.register.BlockRegister.*;
import static love.iloveworld.continent.register.ItemRegister.*;



public class ModeTabRegister {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final RegistryObject<CreativeModeTab> tab = TAB.register("world", () -> CreativeModeTab.builder().title(Component.translatable("mco.create.world")).icon(() -> new ItemStack(foundationItem.get())).displayItems((parm, output) -> {

        //创造物品栏world
        output.accept(myBlock.get());
        output.accept(foundationItem.get());
        output.accept(protection.get());
        output.accept(jammer.get());
        output.accept(acid.get());
        output.accept(adrenaline.get());
        output.accept(advanced_chip.get());
        output.accept(antenna.get());
        output.accept(antibiotic.get());
        output.accept(bandage.get());
        output.accept(bandage_with_herb.get());
        output.accept(cable.get());
        output.accept(cardiotonic.get());
        output.accept(chip.get());
        output.accept(circuit_board.get());
        output.accept(copper_wire.get());
        output.accept(cut_off_foot.get());
        output.accept(diamond_crate.get());
        output.accept(extract.get());
        output.accept(flare.get());
        output.accept(golden_crate.get());
        output.accept(herb.get());
        output.accept(iron_crate.get());
        output.accept(module_damage_resistance.get());
        output.accept(module_fast_digging.get());
        output.accept(module_base.get());
        output.accept(module_happy.get());
        output.accept(module_heal.get());
        output.accept(module_increase_damage.get());
        output.accept(module_protect_block.get());
        output.accept(module_speed.get());
        output.accept(neoplasm.get());
        output.accept(obsidian_crate.get());
        output.accept(splint.get());
        output.accept(syringe.get());
        output.accept(wooden_crate.get());
        output.accept(worn_cloth.get());

    }).build());
}
