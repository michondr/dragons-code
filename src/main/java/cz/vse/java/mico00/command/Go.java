package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.item.Door;
import cz.vse.java.mico00.item.Item;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Go implements ICommand {

    @Override
    public char getKey() {
        return 'g';
    }

    @Override
    public String getDescription() {
        return "go to location though door";
    }

    @Override
    public void init(Game game) {
        Item itemOnLocation = game.getCurrentPlan().getItemByLocation(game.getPlayer().getLocation());

        if (itemOnLocation == null) {
            return;
        }

        if (itemOnLocation.getClass() == Door.class) {
            Door item = (Door) itemOnLocation;

            Door wayHome = item.getLocationPlan().getDoors()
                    .stream()
                    .filter(x -> x.getName().equals(game.getCurrentPlan().getName()))
                    .findFirst()
                    .orElse(null);

            if (wayHome == null) {
                System.err.println("missing door from " + item.getName() + " to " + game.getCurrentPlan().getName());
                System.exit(1);
            }

            game.getPlayer().setLocation(wayHome.getLocation());
            game.setCurrentPlan(item.getLocationPlan());

            game.getTexts().printTextInBlue(item.getWelcoming());
        } else {
            game.getTexts().printCollectErrorNoItem();
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
