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
        System.out.println(RESET + "Hello and welcome to dragons&code!");
    }

    public static void printGoodbye() {
        System.out.println(RESET + "Thank you for playing this game!");
    }

    public static void printMoveError() {
        System.out.println(RESET + "You cant go any further in this direction");
    }

    public static void printCollectErrorNoItem() {
        System.out.println(RESET + "No loot item here");
    }

    public static void printCollectErrorNotPortable() {
        System.out.println(RESET + "This item is too heavy to lift");
    }

    public static void printWanderText() {
        String[] wordlist = {
                "What do you need, handsome?",
                "Can't wait to count out your coin.",
                "I should bash your face in after all you've done",
                "My father said I should go to college but he didnt say which one.",
                "Got to start carrying a dagger in my boot. I'm tired of getting disarmed.",
                "I'd be a lot happier and a lot warmer with a belly full of mead.",
                "I'm not a man, I'm a weapon in human form.",
                "Some may call this junk, me, I call them treasures",
                "Lot of history in these walls. We're trying to make some more. It's a lucky time to be alive.",
                "Skyrim's harshness has a way of carving a man down to his true self.",
                "I would gladly retire from the world. Were such a day to dawn.",
                "FUS RO DAH!",
                "You stink of death my friend. I salute you.",
                "Guhh...",
                "You know what is wrong with Skyrim these days? Everyone is obsessed with death.",
                "This is not play-acting, here. We are the true spirit of Skyrim. Honor is in our blood, death in our hearts.",
                "Skyrim belongs to the Nords!",
                "Vitory or sovgarde!!!",
                "Murder, banditry, assault, theft...and lolygagging",
                "Skyrim is now host to giant, flying lizards and two-legged cat-men, and you're surprised by me? Yes. I just talked. And am continuing to do so.",
                "I had an uncle, you see. He made certain... unwanted advances. So I killed him. And liked it. Then I killed again. And liked it even more",
                "Need to oil mother soon... Get all the hard to reach places...",
                "My ancestors are smiling at me imperial, can you say the same?",
                "What in oblivion is that!?",
                "Keep walkin', softgut. I'm more woman than you can handle",
                "Would you like a bow that shoots rainbows too? Or perhaps a quiver that dispenses beer?",
                "Talos the Mighty! Talos the unerring! Talos the unassailable!",
                "Legends don't burn down villages",
                "I am a master wizard of the house Televanni, OTHER people make tea for me.",
                "You are taking us somewhere warm, I trust?",
                "You know what they say: When life gives you lemons...go murder a clown.",
                "PSSST I know who you are... Hail Sithis!",
                "Never should have come here...",
                "Talos be with you.",
                "That is one BIG... HAMMER",
                "You'll make a fine rug cat!",
                "You remind me of my cousin's cat. Killed that one, too!",
                "Glad to be traveling with someone who seems competent. My last employer died trying to tackle an entire fort of bandits alone",
                "They think us all lawless beasts but, I'm proof of their ignorance.",
                "They got a nickname for anyone who trifles with us guards in Windhelm: Suicide.",
                "ZU'U UNSLAAD, ZU'U NIS OBLAAN!",
                "Legends don't burn down villages",
                "Sweat mother, sweat mother, send your child unto me. For the sins of the unworthy must be baptized in blood and fear.",
                "Might head down to the meadery later. Let me guess, someone stole your sweetroll.",
                "Give Ulfric my regards.",
                "I am not a boy but neither am I a man",
                "What are you in prison for?\" \"Assault, theft, murder, and lollygagging.",
                "So this is Raven Rock, Eh? Not all that much to look at"
        };

        String textToPrint;

        if (ThreadLocalRandom.current().nextInt(10) == 0) {
            textToPrint = "\""+ wordlist[ThreadLocalRandom.current().nextInt(wordlist.length)] + "\"";
        } else {
            textToPrint = "";
        }

        System.out.print(CYAN + textToPrint);
        System.out.println(RESET);
    }

    public static void printHelpText() {
        System.out.println(
                RESET + "This screen is your help screen. You can invoke it any time by pressing \"h\"." +
                        "\nPoint of this game is to have some fun and kill some monsters and dragons in the meantime. " +
                        "\nYou, Dovahkiin, can win this game by killing Alduin, the World Eater " +
                        "\nLevel up and kill the beast!");
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
            System.out.println("You died :( \n want to play one more?");
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

    public static void printEpilogue(Creature player) {
        System.out.println("You've finished the game!");
    }
}
