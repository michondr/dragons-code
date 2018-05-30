package game;

import item.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<Item> itemsByName = plan.getUsedItems()
                .stream()
                .filter(x -> x.getName() == name)
                .collect(Collectors.toCollection(HashSet::new));

        for (Item itemByName : itemsByName){
            if (itemByName == null) {
                return;
            }
            if (itemByName.getClass() != Creature.class && itemByName.getClass() != Dragon.class) {
                return;
            }

            Creature creature = (Creature) itemByName;
            creature.addLoot(Set.of(loots));
        }
    }

    public static void createDoor(LocationPlan from, LocationPlan to, Location location, String hint) {
        Door doorTo = new Door(to);
        doorTo.setWelcoming(GameTexts.getLocationText(to) + "\nhint: " + hint);
        doorTo.setLocation(location);
        from.addItem(doorTo);
    }

    public static void createDoor(LocationPlan from, LocationPlan to, Location location) {
        Door doorTo = new Door(to);
        doorTo.setWelcoming(GameTexts.getLocationText(to));
        doorTo.setLocation(location);
        from.addItem(doorTo);
    }
}
