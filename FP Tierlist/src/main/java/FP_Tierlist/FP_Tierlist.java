package FP_Tierlist;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.PostUpdateSubscriber;
import basemod.interfaces.RenderSubscriber;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import FP_Tierlist.model.CardEval;
import FP_Tierlist.model.GameStateManager;
import FP_Tierlist.model.UIManager;


@SpireInitializer
public class FP_Tierlist implements PostInitializeSubscriber, PostUpdateSubscriber, RenderSubscriber {
    private static final Logger logger = LogManager.getLogger(FP_Tierlist.class);

    private final GameStateManager gameStateManager;

    private final UIManager uiManager;

    private final CardEval cardEvaluationService;

    public FP_Tierlist() {
        logger.info("TierlistMod Constructor called");
        this.gameStateManager = new GameStateManager();
        this.cardEvaluationService = new CardEval();
        this.uiManager = new UIManager(this.cardEvaluationService);
        BaseMod.subscribe((ISubscriber)this);
    }

    public static void initialize() {
        try {
            logger.info("Starting Mod initialization");
            new FP_Tierlist();
            logger.info("TierlistMod initialization complete");
        } catch (Throwable throwable) {
            logger.error("TierlistMod initialization failed", throwable);
        }
    }

    public void receivePostInitialize() {
        logger.info("Tierlist PostInitialize called");
        logger.info("MOD is now fully loaded and working!");
    }

    public void receivePostUpdate() {
            if (!isValidGameState())
                return;
        if (this.gameStateManager.isInCardReward() && this.gameStateManager.isDeckStateUpdateNeeded()) {
            logger.info("In card reward screen - updating card evaluations");
            this.cardEvaluationService.updateCardEvaluations();
            this.gameStateManager.setDeckStateNeedsUpdate(false);
        }
            this.gameStateManager.update();
            this.uiManager.update(this.gameStateManager);
    }

    public void receiveRender(SpriteBatch paramSpriteBatch) {
        try {
            boolean bool = isValidGameState();
            if (!bool)
                return;
            this.uiManager.render(paramSpriteBatch, this.gameStateManager);
        } catch (Exception exception) {
            logger.error("Error in receiveRender: {}", exception.getMessage(), exception);
        }
    }

    private boolean isValidGameState() {
        return (AbstractDungeon.player != null && CardCrawlGame.mode == CardCrawlGame.GameMode.GAMEPLAY);
    }
}
