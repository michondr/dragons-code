package command;

import game.Game;
import game.GameTexts;
import game.Location;
import game.LocationPrinter;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Help implements ICommand {

    public static void print(Game game) {
        LocationPrinter.printHelp(game);
        GameTexts.printHP(game.getPlayer());
        GameTexts.printHit(game.getPlayer());

    }

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
        print(game);
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
