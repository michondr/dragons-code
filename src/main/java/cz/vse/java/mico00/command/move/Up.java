package cz.vse.java.mico00.command.move;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

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

        } else {
            game.getTexts().printMoveError();
        }
    }

    @Override
    public boolean isMove() {
        return true;
    }

    private boolean canMove(Game game) {
        int playerY = game.getPlayer().getLocation().getY();

        return playerY != 0;
    }
}
