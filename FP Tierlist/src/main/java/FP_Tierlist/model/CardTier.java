package FP_Tierlist.model;

import com.megacrit.cardcrawl.cards.AbstractCard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardTier {
    public static class CardBaseData {
        public final int baseScore;
        public final CardTier.TierLevel tier;


        public CardBaseData(int param1Int1, CardTier.TierLevel param1TierLevel) {
            this.baseScore = param1Int1;
            this.tier = param1TierLevel;
        }

        public CardBaseData(int param1Int1, CardTier.TierLevel param1TierLevel, String param1String, List<String> param1List, int param1Int2) {
            this(param1Int1, param1TierLevel);
        }
    }

    public enum TierLevel {
        S("S", 80),
        A("A", 60),
        B("B", 50),
        C("C", 40),
        D("D", 30),
        F("F", 0);

        public final String display;

        public final int minScore;

        TierLevel(String param1String1, int param1Int1) {
            this.display = param1String1;
            this.minScore = param1Int1;
        }
    }

    private static final Map<String, CardBaseData> ENHANCED_CARD_DATABASE = new HashMap<>();

    private final Tier tier;

    static {
        initializeIroncladCards();
        initializeSilentCards();
        initializeDefectCards();
        initializeWatcherCards();
        initializeColorlessCards();
    }
//Quite a few cards have different in game name than name in the code so for them to work properly i put their code name in the brackets
    private static void initializeIroncladCards() {
        ENHANCED_CARD_DATABASE.put("Barricade", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Battle Trance", new CardBaseData(85, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Bloodletting", new CardBaseData(98, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Burning Pact", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Corruption", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Dark Embrace", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Exhume", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Feed", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Feel No Pain", new CardBaseData(88, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Fiend Fire", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Impervious", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Offering", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Pommel Strike", new CardBaseData(86, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Reaper", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Second Wind", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Anger", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Armaments", new CardBaseData(62, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Blood for Blood", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Disarm", new CardBaseData(78, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Dual Wield", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Flame Barrier", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Headbutt", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Immolate", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Inflame", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Power Through", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Seeing Red", new CardBaseData(73, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Shockwave", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Shrug It Off", new CardBaseData(74, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Uppercut", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Brutality", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Cleave", new CardBaseData(55, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Demon Form", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Double Tap", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Hemokinesis", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Iron Wave", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Metallicize", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Reckless Charge", new CardBaseData(50, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Spot Weakness", new CardBaseData(56, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Thunderclap", new CardBaseData(52, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("True Grit", new CardBaseData(54, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Twin Strike", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Whirlwind", new CardBaseData(55, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Bludgeon", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Carnage", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Ghostly Armor", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Dropkick", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Evolve", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Flex", new CardBaseData(48, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Intimidate", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Juggernaut", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Limit Break", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Pummel", new CardBaseData(45, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Rage", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Sentinel", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Sever Soul", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Sword Boomerang", new CardBaseData(48, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Warcry", new CardBaseData(43, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Entrench", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Body Slam", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Bash", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Clothesline", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Combust", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Fire Breathing", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Havoc", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Heavy Blade", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Infernal Blade", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Perfected Strike", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Rampage", new CardBaseData(30, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Rupture", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Wild Strike", new CardBaseData(32, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Berserk", new CardBaseData(25, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Clash", new CardBaseData(8, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Defend", new CardBaseData(8, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Searing Blow", new CardBaseData(8, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Strike", new CardBaseData(8, TierLevel.F));

    }

    private static void initializeSilentCards() {

        ENHANCED_CARD_DATABASE.put("Acrobatics", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Adrenaline", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("After Image", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Venomology", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Blade Dance", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Burst", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Corpse Explosion", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Noxious Fumes", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("PiercingWail", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Prepared", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Well Laid Plans", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Wraith Form v2", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Backflip", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Calculated Gamble", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Crippling Poison", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Dagger Spray", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Die Die Die", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Escape Plan", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Flechettes", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Glass Knife", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Leg Sweep", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Malaise", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Neutralize", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Phantasmal Killer", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Dagger Throw", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Skewer", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Terror", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Backstab", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Bane", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Blur", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Cloak And Dagger", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Dash", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Deadly Poison", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Deflect", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Eviscerate", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Finisher", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Footwork", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Predator", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Underhanded Strike", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Sucker Punch", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Tools of the Trade", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Accuracy", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Catalyst", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Bouncing Flask", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Bullet Time", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Choke", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Concentrate", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Doppelganger", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Expertise", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Flying Knee", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Masterful Stab", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Night Terror", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Poisoned Stab", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Reflex", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Tactician", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Slice", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Unload", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Survivor", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("A Thousand Cuts", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("All Out Attack", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Caltrops", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Dodge and Roll", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Envenom", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Grand Finale", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Heel Hook", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Infinite Blades", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Outmaneuver", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Storm of Steel", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Defend", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Distraction", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Endless Agony", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Quick Slash", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Riddle With Holes", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Setup", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Strike", new CardBaseData(7, TierLevel.F));

    }

    private static void initializeDefectCards() {

        ENHANCED_CARD_DATABASE.put("Defragment", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Core Surge", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Echo Form", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Electrodynamics", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Seek", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Genetic Algorithm", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Biased Cognition", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Barrage", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Conserve Battery", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Coolheaded", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Ball Lightning", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Hologram", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Compile Driver", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Meteor Strike", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Turbo", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Capacitor", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Loop", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Reinforced Body", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Sunder", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Redo", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Glacier", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Doom and Gloom", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Darkness", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Undo", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Beam Cell", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Skim", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Chill", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Cold Snap", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Consume", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Rainbow", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Recycle", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Self Repair", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("BootSequence", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Sweeping Beam", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Lockon", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Rip and Tear", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Fission", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Hyperbeam", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Go for the Eyes", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Force Field", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Static Discharge", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("All For One", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Buffer", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Aggregate", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Reboot", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Storm", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Amplify", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Machine Learning", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Steam", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("FTL", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Heatsinks", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Rebound", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Dualcast", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Streamline", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Stack", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Multi-Cast", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Melter", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Leap", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Reprogram", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Auto Shields", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Gash", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Zap", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Creative AI", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Fusion", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Blizzard", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Chaos", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Tempest", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Double Energy", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Overclock", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Steam Power", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Thunder Strike", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("White Noise", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Defend", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Scrape", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Strike", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Hello World", new CardBaseData(7, TierLevel.F));

    }

    private static void initializeWatcherCards() {

        ENHANCED_CARD_DATABASE.put("CutThroughFate", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("EmptyFist", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("FlurryOfBlows", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Scrawl", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Adaptation", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("LessonLearned", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Meditate", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Omniscience", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("SandsOfTime", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("TalkToTheHand", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Vault", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("MentalFortress", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Crescendo", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Tantrum", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("ThirdEye", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("FearNoEvil", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("ClearTheMind", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("WaveOfTheHand", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("SimmeringFury", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("EmptyMind", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("DeceiveReality", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("InnerPeace", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Blasphemy", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("CrushJoints", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Establishment", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Fasting2", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Wish", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Eruption", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("JustLucky", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Wallop", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Conclude", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("SpiritShield", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("SashWhip", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Sanctity", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Halt", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Consecrate", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("EmptyBody", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("FollowUp", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("BowlingBash", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Brilliance", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("WheelKick", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Prostrate", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("CarveReality", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("ReachHeaven", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Indignation", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("DeusExMachina", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Ragnarok", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Worship", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Swivel", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Perseverance", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Devotion", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Evaluate", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Vigilance", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("WindmillStrike", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("ForeignInfluence", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("LikeWater", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("FlyingSleeves", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Pray", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Judgement", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Protect", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Collect", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Wireheading", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Study", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("WreathOfFlame", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Strike", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("BattleHymn", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("SignatureMove", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("DevaForm", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Nirvana", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Weave", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Defend", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("MasterReality", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("ConjureBlade", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Alpha", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("PathToVictory", new CardBaseData(7, TierLevel.F));
    }

    private static void initializeColorlessCards() {
// Afew colorless that don't show up in shop are not here because frost did not tier them
        ENHANCED_CARD_DATABASE.put("RitualDagger", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Dark Shackles", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Master of Strategy", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Secret Technique", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Panic Button", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Apotheosis", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Panacea", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("Violence", new CardBaseData(87, TierLevel.S));

        ENHANCED_CARD_DATABASE.put("HandOfGreed ", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Panache", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Enlightenment", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Impatience", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Metamorphosis", new CardBaseData(67, TierLevel.A));

        ENHANCED_CARD_DATABASE.put("Purity", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Madness", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Good Instincts", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Blind", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Trip", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Deep Breath", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Flash of Steel", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Finesse", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Chrysalis", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Thinking Ahead", new CardBaseData(57, TierLevel.B));

        ENHANCED_CARD_DATABASE.put("Discovery", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Mayhem", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("Secret Weapon", new CardBaseData(47, TierLevel.C));

        ENHANCED_CARD_DATABASE.put("The Bomb", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Swift Strike", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Dramatic Entrance", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Sadistic Nature", new CardBaseData(37, TierLevel.D));

        ENHANCED_CARD_DATABASE.put("Transmutation", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Jack Of All Trades", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Bandage Up", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Forethought", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Magnetism", new CardBaseData(7, TierLevel.F));

        ENHANCED_CARD_DATABASE.put("Mind Blast", new CardBaseData(7, TierLevel.F));

    }

    public enum Tier {
        S(80.0F),
        A(60.0F),
        B(50.0F),
        C(40.0F),
        D(30.0F),
        F(0.0F);

        private final float baseScore;

        Tier(float param1Float) {
            this.baseScore = param1Float;
        }

        public float getBaseScore() {
            return this.baseScore;
        }
    }

    public static CardTier getTierForCard(AbstractCard paramAbstractCard) {
        CardBaseData cardBaseData = getCardData(paramAbstractCard.cardID);
        return new CardTier(convertToLegacyTier(cardBaseData.tier));
    }

    private static Tier convertToLegacyTier(TierLevel paramTierLevel) {
        switch (paramTierLevel) {
            case S:
                return Tier.S;
            case A:
                return Tier.A;
            case B:
                return Tier.B;
            case C:
                return Tier.C;
            case D:
                return Tier.D;
            case F:
                return Tier.F;
        }
        return Tier.B;
    }

    public CardTier(Tier paramTier) {
        this.tier = paramTier;
    }

    public static CardBaseData getCardData(String paramString) {
        CardBaseData cardBaseData = ENHANCED_CARD_DATABASE.get(paramString);
        if (cardBaseData != null)
            return cardBaseData;
        return null;
    }

    public static List<String> getCardsByTier(TierLevel paramTierLevel) {
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, CardBaseData> entry : ENHANCED_CARD_DATABASE.entrySet()) {
            if (((CardBaseData)entry.getValue()).tier == paramTierLevel)
                arrayList.add((String)entry.getKey());
        }
        return arrayList;
    }

    public Tier getTier() {
        return this.tier;
    }
    public float getBaseScore() {
        return this.tier.getBaseScore();
    }

}
