package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.item.Item;
import cz.vse.java.mico00.item.Loot;

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
                game.getTexts().printCollectErrorNotPortable();
                return;
            }

            game.getPlayer().addLoot(item);
            game.getCurrentPlan().getLoot().remove(item);

            game.getTexts().printLootCollected(item, game.getPlayer());
        } else {
            game.getTexts().printCollectErrorNoItem();
        }
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
