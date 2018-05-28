package command;

import game.Game;
import game.GameTexts;

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
}
