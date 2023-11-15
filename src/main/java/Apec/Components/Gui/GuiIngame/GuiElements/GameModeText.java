package Apec.Components.Gui.GuiIngame.GuiElements;

import Apec.ApecMain;
import Apec.Components.Gui.GuiIngame.GUIComponent;
import Apec.Components.Gui.GuiIngame.GUIComponentID;
import Apec.DataInterpretation.DataExtractor;
import Apec.Settings.SettingID;
import Apec.Utils.ApecUtils;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.util.vector.Vector2f;


public class GameModeText extends GUIComponent {

    private int StringWidth = 0;

    public GameModeText() {
        super(GUIComponentID.GAME_MODE_TEXT);
    }

    @Override
    public void draw(DataExtractor.PlayerStats ps, DataExtractor.ScoreBoardData sd, DataExtractor.OtherData od, ScaledResolution sr, boolean editingMode) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, scale);
        if (ApecMain.Instance.settingsManager.getSettingState(SettingID.USE_GAME_MODE_OUT_OF_BB) || editingMode) {
            Vector2f Pos = ApecUtils.scalarMultiply(this.getCurrentAnchorPoint(), oneOverScale);

            String s = sd.GameMode;

            StringWidth = mc.fontRendererObj.getStringWidth(s);

            ApecUtils.drawThiccBorderString(s, (int) (Pos.x) + 1, (int) (Pos.y) + 1, 0xffffffff);
        }
        GlStateManager.popMatrix();
    }


    @Override
    public Vector2f getAnchorPointPosition() {
        return new Vector2f(g_sr.getScaledWidth() / 2f, g_sr.getScaledHeight() / 2f);
    }

    @Override
    public Vector2f getBoundingPoint() {
        return new Vector2f(StringWidth * scale, 11 * scale);
    }
}
