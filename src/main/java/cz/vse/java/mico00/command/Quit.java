package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Quit implements ICommand {

    @Override
    public char getKey() {
        return 'q';
    }

    @Override
    public String getDescription() {
        return "quit game";
    }

    @Override
    public void init(Game game) {
        GameTexts.printGoodbye();
        System.exit(0);
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
