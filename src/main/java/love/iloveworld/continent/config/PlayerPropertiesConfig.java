package love.iloveworld.continent.config;

import love.iloveworld.continent.MainMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;



@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerPropertiesConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue MOISTURE = BUILDER.defineInRange("moisture", 100, 0,100);
    private static final ForgeConfigSpec.IntValue SPIRIT = BUILDER.defineInRange("spirit", 100, 0,100);
    private static final ForgeConfigSpec.IntValue IMMUNITY = BUILDER.defineInRange("immunity", 100, 0,100);
    public static final ForgeConfigSpec spec = BUILDER.build();

    public static int moisture, spirit,immunity;
    public static void getLoad(){
        moisture = MOISTURE.get();
        spirit = SPIRIT.get();
        immunity = IMMUNITY.get();
        MainMod.LOGGER.info("[TEXT]数据加载中");
    }


    @SubscribeEvent
    public static void setConfig(FMLCommonSetupEvent event){
        getLoad();
    }
    @SubscribeEvent
    public static void loadConfig(ModConfigEvent event){
        getLoad();
    }




}
