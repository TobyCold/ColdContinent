package love.iloveworld.continent.overlay;

import love.iloveworld.continent.capability.PlayerPropertiesProvider;
import love.iloveworld.continent.config.PlayerPropertiesConfig;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class PlayerPropertiesOverlay {
    public static final IGuiOverlay I_GUI_OVERLAY = new IGuiOverlay() {
        @Override
        public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
            Font font = gui.getFont();
            guiGraphics.drawString(font, "水分："+ PlayerPropertiesProvider.moisture,330,220,0xffffff);
            guiGraphics.drawString(font, "精神："+PlayerPropertiesProvider.spirit,330,230,0xffffff);
            guiGraphics.drawString(font, "免疫："+PlayerPropertiesProvider.immunity,330,240,0xffffff);

        }

    };

}
