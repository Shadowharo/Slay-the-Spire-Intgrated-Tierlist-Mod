package FP_Tierlist.model;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CardEval {
    private static final Logger logger = LogManager.getLogger(CardEval.class);


    private List<cardBase> currentEvaluations = new ArrayList<>();


    public CardEval() {
        logger.info("CardEvaluationService initialized (cleaned version)");
    }

    public void updateCardEvaluations() {
        try {
            logger.info("updateCardEvaluations() called");
            if (!isCardRewardScreenActive()) {
                logger.info("Card reward screen not active, clearing evaluations");
                clearEvaluations();
                return;
            }
            logger.info("Card reward screen active - updating card evaluations...");
            evaluateCardRewards();
        } catch (Exception exception) {
            logger.error("Error updating card evaluations: {}", exception.getMessage(), exception);
        }
    }


    private void evaluateCardRewards() {
        if (AbstractDungeon.cardRewardScreen == null || AbstractDungeon.cardRewardScreen.rewardGroup == null)
            return;
        this.currentEvaluations.clear();
        ArrayList<AbstractCard> arrayList = AbstractDungeon.cardRewardScreen.rewardGroup;
        logger.info("Evaluating {} reward cards", Integer.valueOf(arrayList.size()));
        for (byte b = 0; b < arrayList.size(); b++) {
            AbstractCard abstractCard = arrayList.get(b);
            if (abstractCard != null) {
                cardBase cardEvaluation = evaluateCardIntegrated(abstractCard, b);
                this.currentEvaluations.add(cardEvaluation);
            }
        }
    }

    private cardBase evaluateCardIntegrated(AbstractCard paramAbstractCard, int paramInt) {
        cardBase cardEvaluation = new cardBase();
        cardEvaluation.position = paramInt;
        cardEvaluation.cardName = paramAbstractCard.name;
        cardEvaluation.cardType = (paramAbstractCard.type != null) ? paramAbstractCard.type.name() : "UNKNOWN";
        cardEvaluation.cost = paramAbstractCard.cost;
        cardEvaluation.rarity = (paramAbstractCard.rarity != null) ? paramAbstractCard.rarity.name() : "UNKNOWN";
        try {
            float f = getEnhancedBaseScore(paramAbstractCard);
            cardEvaluation.score = f;
            cardEvaluation.rank = determineRankFromScore(f);
            cardEvaluation.rankColor = getRankColor(cardEvaluation.rank);
        } catch (Exception exception) {
            logger.error("Error in integrated card evaluation for {}: {}", paramAbstractCard.name, exception.getMessage(), exception);
            cardEvaluation = createErrorEvaluation(paramInt, paramAbstractCard);
        }
        return cardEvaluation;
    }

    private float getEnhancedBaseScore(AbstractCard paramAbstractCard) {
        CardTier.CardBaseData cardBaseData = CardTier.getCardData(paramAbstractCard.cardID);
        if (cardBaseData != null)
            return cardBaseData.baseScore;
        CardTier cardTier = CardTier.getTierForCard(paramAbstractCard);
        if (cardTier != null)
            return cardTier.getBaseScore();
        return calculateFallbackScore(paramAbstractCard);
    }

    private float calculateFallbackScore(AbstractCard paramAbstractCard) {
        float f = 50.0F;
        return f;
    }

    private String determineRankFromScore(float paramFloat) {
        if (paramFloat >= 80.0F)
            return "S";
        if (paramFloat >= 60.0F)
            return "A";
        if (paramFloat >= 50.0F)
            return "B";
        if (paramFloat >= 40.0F)
            return "C";
        if (paramFloat >= 30.0F)
            return "D";
        return "F";
    }

    private Color getRankColor(String paramString) {
        switch (paramString) {
            case "S":
                return Color.PURPLE;
            case "A":
                return Color.GREEN;
            case "B":
                return Color.BLUE;
            case "C":
                return Color.YELLOW;
            case "D":
                return Color.ORANGE;
            case "F":
                return Color.RED;
        }
        return Color.WHITE;
    }

    private cardBase createErrorEvaluation(int paramInt, AbstractCard paramAbstractCard) {
        cardBase cardEvaluation = new cardBase();
        cardEvaluation.position = paramInt;
        cardEvaluation.cardName = (paramAbstractCard != null) ? paramAbstractCard.name : "Unknown";
        cardEvaluation.rank = "?";
        cardEvaluation.rankColor = Color.RED;
        return cardEvaluation;
    }

    public void clearEvaluations() {
        this.currentEvaluations.clear();
    }

    private boolean isCardRewardScreenActive() {
        boolean bool1 = (CardCrawlGame.mode == CardCrawlGame.GameMode.GAMEPLAY) ? true : false;
        boolean bool2 = (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.CARD_REWARD) ? true : false;
        boolean bool3 = (AbstractDungeon.cardRewardScreen != null) ? true : false;
        boolean bool4 = (AbstractDungeon.cardRewardScreen != null && AbstractDungeon.cardRewardScreen.rewardGroup != null && !AbstractDungeon.cardRewardScreen.rewardGroup.isEmpty()) ? true : false;
        return (bool1 && bool2 && bool3 && bool4);
    }

    public List<cardBase> getCurrentEvaluations() {
        return new ArrayList<>(this.currentEvaluations);
    }
}
