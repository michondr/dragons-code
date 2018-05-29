package game;

import java.util.Random;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameTexts {
    public static void printWelcome(){
        System.out.println("Hello and welcome to dragons&code!");
    }

    public static void printGoodbye(){
        System.out.println("Thank you for playing this game!");
    }

    public static void printMoveError(){
        System.out.println("You cant go any further in this direction");
    }

    public static void printCollectErrorNoItem(){
        System.out.println("No loot item here");
    }

    public static void printCollectErrorNotPortable(){
        System.out.println("This item is too heavy to lift");
    }

    public static String getWanderText(){
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
                "The journey is long, I'm missing some blood!",
                "Holly molly coca-cola koala",
        };
        return wordlist[new Random().nextInt(wordlist.length)];
    }

    public static void printHelpText(){
        System.out.println("this is a help text. no clue what to write here. just wander around, get loot and kill some dragons!");
    }

}
