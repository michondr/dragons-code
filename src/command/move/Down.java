package command.move;

import command.ICommand;
import game.Game;
import game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Down implements ICommand {

    @Override
    public char getKey() {
        return 's';
    }

    @Override
    public String getDescription() {
        return "go down";
    }

    @Override
    public void init(Game game) {

        if (canMove(game)) {
            game.getPlayer().editLocation(0, 1);
            game.getCurrentPlan().printPlan(game);
        } else {
            GameTexts.printMoveError();
        }
    }

    private boolean canMove(Game game) {
        int playerY = game.getPlayer().getLocation().getY();
        int gameY = game.getCurrentPlan().getPlanSizeEndpoint().getY();

        if (playerY == gameY-1) {
            return false;
        }

        return true;
    }
}
