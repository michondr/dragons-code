package command.move;

import command.ICommand;
import game.Game;
import game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Right implements ICommand {

    @Override
    public char getKey() {
        return 'd';
    }

    @Override
    public String getDescription() {
        return "go right";
    }

    @Override
    public void init(Game game) {

        if (canMove(game)) {
            game.getPlayer().editLocation(1, 0);
            game.getCurrentPlan().printPlan(game);
        } else {
            GameTexts.printMoveError();
        }
    }

    private boolean canMove(Game game) {
        int playerX = game.getPlayer().getLocation().getX();
        int gameX = game.getCurrentPlan().getPlanSizeEndpoint().getX();

        if (playerX == gameX-1) {
            return false;
        }

        return true;
    }
}
