package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Help implements ICommand {

    public static void print(Game game) {
        game.getTexts().printHelp(game);
        game.getTexts().printHP(game.getPlayer());
        game.getTexts().printHit(game.getPlayer());

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
