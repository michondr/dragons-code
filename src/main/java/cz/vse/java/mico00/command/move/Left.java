package cz.vse.java.mico00.command.move;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Left implements ICommand {

    @Override
    public char getKey() {
        return 'a';
    }

    @Override
    public String getDescription() {
        return "go left";
    }

    @Override
    public void init(Game game) {

        if (canMove(game)) {
            game.getPlayer().editLocation(-1, 0);

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

        return playerX != 0;
    }
}
