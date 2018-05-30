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
        if (creature.getHit() * 3 > player.getHp() || creature.getHp() > player.getHit() * 3) {
            System.out.print(RED + creature.getSymbol());
        } else {
            System.out.print(creature.getSymbol());
        }

        System.out.print(RESET);
    }

    public static void printTextInBlue(String text){
        System.out.print(BLUE + text);
        System.out.println(RESET);
    }

}
