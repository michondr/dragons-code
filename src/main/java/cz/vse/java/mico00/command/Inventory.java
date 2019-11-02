package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Inventory implements ICommand {

    @Override
    public char getKey() {
        return 'i';
    }

    @Override
    public String getDescription() {
        return "view inventory";
    }

    @Override
    public void init(Game game) {
        GameTexts.printInventory(game.getPlayer());
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
