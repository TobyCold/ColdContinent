package love.iloveworld.continent.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.client.gui.screens.social.SocialInteractionsScreen;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;
import java.util.function.Supplier;

public class Players extends PlayerEntry {
    private int water;
    public Players(Minecraft p_243293_, SocialInteractionsScreen p_243214_, UUID p_243288_, String p_243311_, Supplier<ResourceLocation> p_243309_, boolean p_243297_) {
        super(p_243293_, p_243214_, p_243288_, p_243311_, p_243309_, p_243297_);
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }


}
