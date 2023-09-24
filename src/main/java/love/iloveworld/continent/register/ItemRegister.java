package love.iloveworld.continent.register;

import love.iloveworld.continent.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static love.iloveworld.continent.MainMod.MODID;
import static love.iloveworld.continent.register.BlockRegister.foundation;
import static love.iloveworld.continent.register.BlockRegister.myBlock;

public class ItemRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);


    public static final RegistryObject<Item> myBlockItem = ITEMS.register("myblock", () -> new BlockItem(myBlock.get(), new Item.Properties()));
    public static final RegistryObject<Item> foundationItem = ITEMS.register("foundation", () -> new BlockItem(foundation.get(), new Item.Properties()));
    public static final RegistryObject<Item> protection = ITEMS.register("protection", () -> new Protection(new Item.Properties()));
    public static final RegistryObject<Item> jammer = ITEMS.register("jammer", () -> new Jammer(new Item.Properties()));
    public static final RegistryObject<Item> acid = ITEMS.register("acid", () -> new Acid(new Item.Properties()));
    public static final RegistryObject<Item> adrenaline = ITEMS.register("adrenaline", () -> new Adrenaline(new Item.Properties()));
    public static final RegistryObject<Item> advanced_chip = ITEMS.register("advanced_chip", () -> new Advanced_chip(new Item.Properties()));
    public static final RegistryObject<Item> antenna = ITEMS.register("antenna", () -> new Antenna(new Item.Properties()));
    public static final RegistryObject<Item> antibiotic = ITEMS.register("antibiotic", () -> new Antibiotic(new Item.Properties()));
    public static final RegistryObject<Item> bandage = ITEMS.register("bandage", () -> new Bandage(new Item.Properties()));
    public static final RegistryObject<Item> bandage_with_herb = ITEMS.register("bandage_with_herb", () -> new Bandage_with_herb(new Item.Properties()));
    public static final RegistryObject<Item> cable = ITEMS.register("cable", () -> new Cable(new Item.Properties()));
    public static final RegistryObject<Item> cardiotonic = ITEMS.register("cardiotonic", () -> new Cardiotonic(new Item.Properties()));
    public static final RegistryObject<Item> chip = ITEMS.register("chip", () -> new Chip(new Item.Properties()));
    public static final RegistryObject<Item> circuit_board = ITEMS.register("circuit_board", () -> new Circuit_board(new Item.Properties()));
    public static final RegistryObject<Item> copper_wire = ITEMS.register("copper_wire", () -> new Copper_wire(new Item.Properties()));
    public static final RegistryObject<Item> cut_off_foot = ITEMS.register("cut_off_foot", () -> new Cut_off_foot(new Item.Properties()));
    public static final RegistryObject<Item> diamond_crate = ITEMS.register("diamond_crate", () -> new Diamond_crate(new Item.Properties()));
    public static final RegistryObject<Item> extract = ITEMS.register("extract", () -> new Extract(new Item.Properties()));
    public static final RegistryObject<Item> flare = ITEMS.register("flare", () -> new Flare(new Item.Properties()));
    public static final RegistryObject<Item> golden_crate = ITEMS.register("golden_crate", () -> new Golden_crate(new Item.Properties()));
    public static final RegistryObject<Item> herb = ITEMS.register("herb", () -> new Herb(new Item.Properties()));
    public static final RegistryObject<Item> iron_crate = ITEMS.register("iron_crate", () -> new Iron_crate(new Item.Properties()));
    public static final RegistryObject<Item> module_damage_resistance = ITEMS.register("module_damage_resistance", () -> new Module_damage_resistance(new Item.Properties()));
    public static final RegistryObject<Item> module_fast_digging = ITEMS.register("module_fast_digging", () -> new Module_fast_digging(new Item.Properties()));
    public static final RegistryObject<Item> module_base = ITEMS.register("module_base", () -> new Module_base(new Item.Properties()));
    public static final RegistryObject<Item> module_happy = ITEMS.register("module_happy", () -> new Module_happy(new Item.Properties()));
    public static final RegistryObject<Item> module_heal = ITEMS.register("module_heal", () -> new Module_heal(new Item.Properties()));
    public static final RegistryObject<Item> module_increase_damage = ITEMS.register("module_increase_damage", () -> new Module_increase_damage(new Item.Properties()));
    public static final RegistryObject<Item> module_protect_block = ITEMS.register("module_protect_block", () -> new Module_protect_block(new Item.Properties()));
    public static final RegistryObject<Item> module_speed = ITEMS.register("module_speed", () -> new Module_speed(new Item.Properties()));
    public static final RegistryObject<Item> neoplasm = ITEMS.register("neoplasm", () -> new Neoplasm(new Item.Properties()));
    public static final RegistryObject<Item> obsidian_crate = ITEMS.register("obsidian_crate", () -> new Obsidian_crate(new Item.Properties()));
    public static final RegistryObject<Item> splint = ITEMS.register("splint", () -> new Splint(new Item.Properties()));
    public static final RegistryObject<Item> syringe = ITEMS.register("syringe", () -> new Syringe(new Item.Properties()));
    public static final RegistryObject<Item> wooden_crate = ITEMS.register("wooden_crate", () -> new Wooden_crate(new Item.Properties()));
    public static final RegistryObject<Item> worn_cloth = ITEMS.register("worn_cloth", () -> new Worn_cloth(new Item.Properties()));

}
