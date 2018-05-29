package game;

import item.Creature;

import java.util.Random;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameTexts {
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
        return wordlist[new Random().nextInt(wordlist.length)];
    }

    public static void printHelpText() {
        System.out.println("this is a help text. no clue what to write here. just wander around, get loot and kill some dragons!");
    }

    public static void printHP(Creature creature) {
        String text = "";

        if (creature.isPlayer()) {
            text = "Your hp ";
        } else {
            text = "Enemy hp ";
        }

        if (creature.getHp() < creature.getHpInitial() / 10) {
            System.out.print((char) 27 + "[31m" + text + creature.getHp());
        } else {
            System.out.print((char) 27 + "[32m" + text + creature.getHp());
        }
        System.out.println((char) 27 + "[39m");
    }

    public static void printDead(Creature creature) {
        if (creature.isPlayer()) {
            System.out.println("You died :(");
        } else {
            System.out.println("You crushed " + creature.getName());
        }
    }

}
