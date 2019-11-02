package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Help implements ICommand {

    public static void print(Game game) {
        GameTexts.printHelp(game);
        GameTexts.printHP(game.getPlayer());
        GameTexts.printHit(game.getPlayer());

    }

    @Override
    public char getKey() {
        return 'h';
    }

    @Override
    public String getDescription() {
        return "help";
    }

    @Override
    public void init(Game game) {
        print(game);
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
