package FP_Tierlist.model;

import com.badlogic.gdx.graphics.Color;

public class cardBase {
    public int position = -1;

    public String cardName = "";

    public String cardType = "";

    public int cost = 0;

    public String rarity = "";

    public String rank = "C";

    public Color rankColor = Color.WHITE;

    public float score = 0.0F;

    public String getDisplayText() {
        return String.format("%s [%s] - %s", new Object[] { this.cardName, this.rarity});
    }


    public String toString() {
        return String.format("CardEvaluation[%d: %s, Rank=%s, Score=%.1f]", new Object[] { Integer.valueOf(this.position), this.cardName, this.rank, Float.valueOf(this.score) });
    }
}
