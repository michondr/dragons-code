package command;

import game.Game;
import game.GameTexts;
import game.LocationPrinter;
import item.Item;
import item.Loot;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Collect implements ICommand {

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String getDescription() {
        return "collect loot";
    }

    @Override
    public void init(Game game) {
        Item itemOnLocation = game.getCurrentPlan().getItemByLocation(game.getPlayer().getLocation());

        if(itemOnLocation == null){
            return;
        }

        if(itemOnLocation.getClass() == Loot.class){
            Loot item = (Loot) itemOnLocation;

            if(!item.isPortable()){
                GameTexts.printCollectErrorNotPortable();
                return;
            }

            game.getPlayer().addLoot(item);
            game.getCurrentPlan().getLoot().remove(item);

            LocationPrinter.printInventory(item);
        } else {
            GameTexts.printCollectErrorNoItem();
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
