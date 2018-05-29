package command;

import game.Game;
import game.LocationPrinter;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Base implements ICommand {

    @Override
    public char getKey() {
        return 'b';
    }

    @Override
    public String getDescription() {
        return "go to base";
    }

    @Override
    public void init(Game game) {
        game.setCurrentPlan(game.getBaseLocation());
    }
}
