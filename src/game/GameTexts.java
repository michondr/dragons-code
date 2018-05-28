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

    public static String getWanderText(){
        String[] wordlist = {
                "",
                "",
                "",
                "",
                "The journey is long, I'm missing some blood!",
                "Holly molly coca-cola koala",
        };
        return wordlist[new Random().nextInt(wordlist.length)];
    }
}
