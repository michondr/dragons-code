package cz.vse.java.mico00;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            MainGameController game = new MainGameController();
            game.startGame(args);
        } else if (args[0].equals("text")) {
            MainGameCommand game = new MainGameCommand();
            game.startGame(args);
        } else {
            System.out.println("Textová verze se spustí argumentem -text");
        }
    }
}
