package love.iloveworld.continent.overlay;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class PositionOverlay {

    public static final IGuiOverlay OVERLAY = new IGuiOverlay() {

        @Override
        public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
            guiGraphics.drawString(gui.getFont(), "X:" , 20, 200, 0xffffff);
        }
    };
}
