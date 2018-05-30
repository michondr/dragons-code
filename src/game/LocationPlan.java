package game;

import item.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 * <p>
 * ---------------------
 * |                   |
 * |   @       $       |
 * |                   |
 * |                   |
 * |             W     |
 * |      #            |
 * |            %      |
 * ---------------------
 * @ - player
 * $ - loot
 * # - location
 * ! - enemy
 * W - dragon
 */
public class LocationPlan {

    private Location endpoint;
    private Set<Door> doors;
    private Set<Loot> loot;
    private Set<Creature> creatures;
    private Set<Dragon> dragons;
    private String name;

    LocationPlan(String name, int xDim, int yDim) {
        this.name = name;
        this.endpoint = new Location(xDim, yDim);
        this.doors = new HashSet<>();
        this.loot = new HashSet<>();
        this.creatures = new HashSet<>();
        this.dragons = new HashSet<>();
    }

    public Location getPlanSizeEndpoint() {
        return endpoint;
    }

    public Set<Door> getDoors() {
        return doors;
    }

    public Set<Loot> getLoot() {
        return loot;
    }

    public Set<Creature> getCreatures() {
        return creatures;
    }

    public Set<Dragon> getDragons() {
        return dragons;
    }

    public void addItem(Item item) {
        Location loc = item.getLocation();

        if (loc == null) {
            ThreadLocalRandom ra = ThreadLocalRandom.current();
            Location newLoc = new Location(ra.nextInt(endpoint.getX()), ra.nextInt(endpoint.getY()));
            item.setLocation(newLoc);
        }

        if (item.getClass() == Creature.class) {
            creatures.add((Creature) item);
            return;
        }

        if (item.getClass() == Dragon.class) {
            dragons.add((Dragon) item);
            return;
        }

        if (item.getClass() == Loot.class) {
            loot.add((Loot) item);
            return;
        }

        if (item.getClass() == Door.class) {
            doors.add((Door) item);
        }
    }

    public Set<Item> getUsedItems() {
        Set<Item> used = new HashSet<>();

        used.addAll(creatures);
        used.addAll(dragons);
        used.addAll(doors);
        used.addAll(loot);

        return used;
    }

    public Set<Location> getUsedLocations() {
        return getUsedItems()
                .stream()
                .map(Item::getLocation)
                .collect(Collectors.toSet());
    }

    public Item getItemByLocation(Location loc) {
        return getUsedItems()
                .stream()
                .filter(x -> x.getLocation().equals(loc))
                .findFirst()
                .orElse(null);
    }

    public Item getItemByName(String name) {
        return getUsedItems()
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void printPlan(Game game) {
        GameTexts.printPlan(this, game);
    }

    public String getName() {
        return name;
    }
}
