package FP_Tierlist.model;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameStateManager {
    private static final Logger logger = LogManager.getLogger(GameStateManager.class);

    private boolean wasInCardReward = false;
    private int lastFloor = -1;

    private int lastAct = -1;

    private boolean deckStateNeedsUpdate = true;


    public void update() {
        if (AbstractDungeon.player == null)
            return;
        detectFloorChange();
        detectScreenTransitions();
    }

    private void detectFloorChange() {
        int i = AbstractDungeon.floorNum;
        int j = AbstractDungeon.actNum;
        if (i != this.lastFloor && i > 0) {
            logger.info("Floor changed from {} to {} (Act: {})", Integer.valueOf(this.lastFloor), Integer.valueOf(i), Integer.valueOf(j));
            this.lastFloor = i;
            this.deckStateNeedsUpdate = true;
        }
        if (j != this.lastAct && j > 0) {
            logger.info("Act changed from {} to {}", Integer.valueOf(this.lastAct), Integer.valueOf(j));
            this.lastAct = j;
            onActChange(j);
        }
    }

    private void detectScreenTransitions() {
        boolean bool = isInCardReward();
        if (bool && !this.wasInCardReward) {
            logger.info("Entered card reward screen");
            onEnterCardReward();
        } else if (!bool && this.wasInCardReward) {
            logger.info("Exited card reward screen");
            onExitCardReward();
        }
        this.wasInCardReward = bool;
    }

    private void onActChange(int paramInt) {
        this.deckStateNeedsUpdate = true;
        logger.info("Entered Act {} - Resetting analysis flags", Integer.valueOf(paramInt));
    }

    private void onEnterCardReward() {
        this.deckStateNeedsUpdate = true;
    }

    private void onExitCardReward() {
        this.deckStateNeedsUpdate = true;
    }

    public boolean isInCardReward() {
        boolean bool1 = (CardCrawlGame.mode == CardCrawlGame.GameMode.GAMEPLAY) ? true : false;
        boolean bool2 = (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.CARD_REWARD) ? true : false;
        return (bool1 && bool2);
    }

    public boolean isDeckStateUpdateNeeded() {
        return this.deckStateNeedsUpdate;
    }

    public void setDeckStateNeedsUpdate(boolean deckStateNeedsUpdate) {
        this.deckStateNeedsUpdate = deckStateNeedsUpdate;
    }

}

