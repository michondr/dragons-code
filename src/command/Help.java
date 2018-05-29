package command;

import game.Game;
import game.GameTexts;
import game.LocationPrinter;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Help implements ICommand {

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
        LocationPrinter.printHelp(game);
    }
}
