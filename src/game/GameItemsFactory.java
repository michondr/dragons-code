package game;

import item.Creature;
import item.Item;
import item.Loot;

import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameItemsFactory {

    public static void createItems(LocationPlan plan, Item... items) {
        for (Item item : items) {
            plan.addItem(item);
        }
    }

    public static void addLootToCreature(LocationPlan plan, String name, Loot... loots) {
        Item itemByName = plan.getItemByName(name);

        if(itemByName == null){
            System.out.println("FALSE: "+name);
            return;
        }
        if (itemByName.getClass() != Creature.class) {
            return;
        }

        Creature creature = (Creature) itemByName;
        creature.addLoot(Set.of(loots));
    }
}
