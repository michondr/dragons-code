package cz.vse.java.mico00.command.move;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

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

        } else {
            game.getTexts().printMoveError();
        }
    }

    @Override
    public boolean isMove() {
        return true;
    }

    private boolean canMove(Game game) {
        int playerX = game.getPlayer().getLocation().getX();
        int gameX = game.getCurrentPlan().getPlanSizeEndpoint().getX();

        return playerX != gameX - 1;
    }
}
