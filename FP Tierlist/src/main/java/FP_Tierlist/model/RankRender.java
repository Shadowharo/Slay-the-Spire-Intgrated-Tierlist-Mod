package FP_Tierlist.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.Hitbox;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RankRender {
    private static final Logger logger = LogManager.getLogger(RankRender.class);

    private final CardEval CardEval;

    private final Hitbox[] rankHitboxes;

    private int hoveredCardIndex = -1;

    private static final float PANEL_WIDTH = 450.0F * Settings.scale;

    private static final float PANEL_HEIGHT = 600.0F * Settings.scale;

    private static final float PANEL_X = 50.0F * Settings.scale;

    private static final float PANEL_Y = (Settings.HEIGHT - PANEL_HEIGHT) / 2.0F;

    public RankRender(CardEval paramCardEval) {
        this.CardEval = paramCardEval;
        this.rankHitboxes = new Hitbox[5];
        for (byte b = 0; b < this.rankHitboxes.length; b++)
            this.rankHitboxes[b] = new Hitbox(80.0F * Settings.scale, 60.0F * Settings.scale);
        logger.debug("RankRender initialized");
    }

    public void update() {
        updateHitboxes();
    }

    public void render(SpriteBatch paramSpriteBatch) {
        renderCardRanks(paramSpriteBatch);
    }

    private void renderCardRanks(SpriteBatch paramSpriteBatch) {
        List<cardBase> list = this.CardEval.getCurrentEvaluations();
        if (AbstractDungeon.cardRewardScreen == null || AbstractDungeon.cardRewardScreen.rewardGroup == null)
            return;
        for (byte b = 0; b < list.size() && b < AbstractDungeon.cardRewardScreen.rewardGroup.size(); b++) {
            cardBase cardEvaluation = list.get(b);
            AbstractCard abstractCard = AbstractDungeon.cardRewardScreen.rewardGroup.get(b);
            if (abstractCard != null && cardEvaluation != null)
                renderCardRank(paramSpriteBatch, abstractCard, cardEvaluation, b);
        }
    }

    private void renderCardRank(SpriteBatch paramSpriteBatch, AbstractCard paramAbstractCard, cardBase paramCardEvaluation, int paramInt) {
        try {
            float f1 = paramAbstractCard.current_x;
            float f2 = paramAbstractCard.current_y - paramAbstractCard.hb.height / 2.0F - 20.0F * Settings.scale;
            Color color1 = paramCardEvaluation.rankColor;
            if (this.hoveredCardIndex == paramInt)
                color1 = new Color(Math.min(1.0F, color1.r * 1.5F), Math.min(1.0F, color1.g * 1.5F), Math.min(1.0F, color1.b * 1.5F), 1.0F);
            String str = paramCardEvaluation.rank;
            Color color2 = color1;
            FontHelper.renderFontCentered(paramSpriteBatch, FontHelper.cardTitleFont, str, f1, f2, color2);
        } catch (Exception exception) {
            logger.error("Error rendering card rank for index {}: {}", Integer.valueOf(paramInt), exception.getMessage(), exception);
        }
    }

    private void updateHitboxes() {
        List list = this.CardEval.getCurrentEvaluations();
        if (AbstractDungeon.cardRewardScreen == null || AbstractDungeon.cardRewardScreen.rewardGroup == null)
            return;
        for (byte b = 0; b < list.size() && b < this.rankHitboxes.length; b++) {
            AbstractCard abstractCard = AbstractDungeon.cardRewardScreen.rewardGroup.get(b);
            if (abstractCard != null) {
                float f1 = abstractCard.current_x;
                float f2 = abstractCard.current_y - abstractCard.hb.height / 2.0F - 20.0F * Settings.scale;
                this.rankHitboxes[b].move(f1, f2);
                this.rankHitboxes[b].update();
            }
        }
    }
    public void clear() {
        this.hoveredCardIndex = -1;
        logger.debug("Card evaluation panel cleared");
    }

}
