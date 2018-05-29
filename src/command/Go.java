package command;

import game.Game;
import game.GameTexts;
import item.Item;
import item.Place;

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
        return "go to location";
    }

    @Override
    public void init(Game game) {
        Item itemOnLocation = game.getCurrentPlan().getItemOnLocation(game.getPlayer().getLocation());

        if(itemOnLocation == null){
            return;
        }

        if(itemOnLocation.getClass() == Place.class){
            Place item = (Place) itemOnLocation;

            game.setCurrentPlan(item.getLocationPlan());
        } else {
            GameTexts.printCollectErrorNoItem();
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
