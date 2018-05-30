package game;

import item.Creature;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameTexts {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void printWelcome() {
        System.out.println("Hello and welcome to dragons&code!");
    }

    public static void printGoodbye() {
        System.out.println("Thank you for playing this game!");
    }

    public static void printMoveError() {
        System.out.println("You cant go any further in this direction");
    }

    public static void printCollectErrorNoItem() {
        System.out.println("No loot item here");
    }

    public static void printCollectErrorNotPortable() {
        System.out.println("This item is too heavy to lift");
    }

    public static String getWanderText() {
        String[] wordlist = {
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "The journey is long, I'm missing some blood!",
                "Holly molly coca-cola koala",
                "You're a warrior, you deserve the best!",
        };
        return wordlist[ThreadLocalRandom.current().nextInt(wordlist.length)];
    }

    public static void printHelpText() {
        System.out.println("this is a help text. no clue what to write here. just wander around, get loot and kill some dragons!");
    }

    public static void printHP(Creature creature) {
        String text;

        if (creature.isPlayer()) {
            text = "Your hp: ";
        } else {
            text = "Enemy hp: ";
        }

        if (creature.getHp() <= creature.getHpInitial() / 10) {
            System.out.print(RED + text + creature.getHp());
        } else {
            System.out.print(GREEN + text + creature.getHp());
        }
        System.out.println(RESET);
    }

    public static void printHit(Creature creature) {
        if (creature.isPlayer()) {
            System.out.print(PURPLE + "Your hit: " + creature.getHit());
        } else {
            System.out.print(PURPLE + creature.getName() + "s hit" + creature.getHit());
        }
        System.out.println(RESET);
    }

    public static void printDead(Creature creature) {
        if (creature.isPlayer()) {
            System.out.println("You died :(");
        } else {
            System.out.println("You crushed " + creature.getName());
        }
    }

    public static void printCreatureColoredSymbol(Creature creature, Creature player) {
        if (creature.getHp() / player.getHit() > player.getHp() / creature.getHit()) {
            System.out.print(RED + creature.getSymbol());
        } else {
            System.out.print(creature.getSymbol());
        }

        System.out.print(RESET);
    }

    public static void printTextInBlue(String text) {
        System.out.print(BLUE + text);
        System.out.println(RESET);
    }

    public static String getLocationText(LocationPlan plan) {
        switch (plan.getName()) {
            case "Falkreath":
                return "Many battles have been fought here over the centuries. Graves were dug and monuments built, and the town grew around these. In time, Falkreath came to be known as the heroes' graveyard. Many noble Jarls and renowned warriors asked to be buried here. Falkreath's reputation has faded somewhat, but the graves remain, reminding us of the one inevitable truth of life";
            case "Riften":
                return "Riften was a major hub of activity for trade caravans and travellers to and from Morrowind. Fishing skiffs could be seen dotting the lake at all hours of the day and the bustling city was alive with activity at night";
            case "Windhelm":
                return "Once the capital of the First Empire, the palace of the Ysgramor dynasty still dominates the center of the Old City. Windhelm was sacked during the War of Succession, and again by the Akaviri army of Ada'Soon Dir-Kamal; the Palace of the Kings is one of the few First Empire buildings that remains";
            case "Winterhold":
                return "We welcomes you to Winterhold. Let travelers find warmth within our walls, let challengers find us worthy...";
            case "Dawnstar":
                return "We bid you welcome to the City-State which greets the sun as it begins its journey, Dawnstar...";
            case "Morthal":
                return "Morthal's small population and relatively remote location have kept it distant from most major conflicts in recent years";
            case "Solitude":
                return "Solitude, the seat of High King of Skyrim and the capital of Haafingar hold, has always welcomed the Empire with open arms. Much commerce flows along the rivers here, and you will find the folk of this hold to be among the most hospitable in Skyrim";
            case "Markarth":
                return "If you're cutting your coins across Skyrim, you'll want to point your blade towards Markarth, the capital city of the Reach. There's no end of trouble in the City of Stone, and that means plenty of ways for you to earn your supper.";
            case "Whiterun":
                return "Whiterun is the heart of Skyrim, its towering palace rivaling even the great castles of Cyrodiil. But should you tire of the Jarl's hospitality, another adventure awaits a few hours to the east of the city, along the road that rises above White River Gorge";
            default:
                return "";
        }
    }

}
