package command.move;

import command.ICommand;
import game.Game;
import game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Up implements ICommand {

    @Override
    public char getKey() {
        return 'w';
    }

    @Override
    public String getDescription() {
        return "go up";
    }

    @Override
    public void init(Game game) {

        if (canMove(game)) {
            game.getPlayer().editLocation(0, -1);
            game.getCurrentPlan().printPlan(game);
        } else {
            GameTexts.printMoveError();
        }
    }

    @Override
    public boolean isMove() {
        return true;
    }

    private boolean canMove(Game game) {
        int playerY = game.getPlayer().getLocation().getY();

        if (playerY == 0) {
            return false;
        }

        return true;
    }
}
