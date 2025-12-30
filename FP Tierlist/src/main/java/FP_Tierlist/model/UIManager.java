package FP_Tierlist.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UIManager {
    private static final Logger logger = LogManager.getLogger(UIManager.class);

    private final RankRender cardEvaluationPanel;

    private final CardEval cardEvaluationService;

    public UIManager(CardEval paramCardEvaluationService) {
        this.cardEvaluationService = paramCardEvaluationService;
        this.cardEvaluationPanel = new RankRender(paramCardEvaluationService);
        logger.info("UIManager initialized");
    }

    public void update(GameStateManager paramGameStateManager) {
        try {
            if (paramGameStateManager.isInCardReward())
                this.cardEvaluationPanel.update();
        } catch (Exception exception) {
            logger.error("Error updating UI: {}", exception.getMessage(), exception);
        }
    }

    public void render(SpriteBatch paramSpriteBatch, GameStateManager paramGameStateManager) {
        try {
            boolean bool = paramGameStateManager.isInCardReward();
            if (bool)
                this.cardEvaluationPanel.render(paramSpriteBatch);
        } catch (Exception exception) {
            logger.error("Error rendering UI: {}", exception.getMessage(), exception);
        }
    }

    public void clearUI() {
        this.cardEvaluationPanel.clear();
        logger.debug("UI cleared");
    }
}
