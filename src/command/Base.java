package command;

import game.Game;
import game.Location;

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
        game.getPlayer().setLocation(new Location(1, 1));
        game.setCurrentPlan(game.getBaseLocation());
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
