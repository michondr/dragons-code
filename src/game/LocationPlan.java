package game;

import item.Creature;
import item.Item;
import item.Place;
import item.Loot;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 * <p>
 * ---------------------
 * |                   |
 * |   @       $       |
 * |                   |
 * |                   |
 * |                   |
 * |      #            |
 * |            %      |
 * ---------------------
 * @ - player
 * $ - loot
 * # - location
 * % - enemies
 */
public class LocationPlan {

    private Location endpoint;
    private Set<Place> places;
    private Set<Loot> loot;
    private Set<Creature> creatures;
    private Set<Location> usedLocations;

    LocationPlan(int xDim, int yDim) {
        this.endpoint = new Location(xDim, yDim);
        this.places = new HashSet<>();
        this.loot = new HashSet<>();
        this.creatures = new HashSet<>();
    }

    public Location getPlanSizeEndpoint() {
        return endpoint;
    }

    public Set getPlaces() {
        return places;
    }

    public Set getLoot() {
        return loot;
    }

    public Set getCreatures() {
        return creatures;
    }

    public void addItem(Item item) {
        Location loc = item.getLocation();

        if (loc == null) {
            Random ra = new Random();
            Location newLoc = new Location(ra.nextInt(endpoint.getX()), ra.nextInt(endpoint.getY()));
            item.setLocation(newLoc);
        }

        if(item.getClass() == Creature.class){
            creatures.add((Creature) item);
            return;
        }

        if(item.getClass() == Loot.class){
            loot.add((Loot) item);
            return;
        }

        if(item.getClass() == Place.class){
            places.add((Place) item);
        }
    }

    public Set<Item> getUsedItems() {
        Set<Item> used = new HashSet<>();

        used.addAll(creatures);
        used.addAll(places);
        used.addAll(loot);

        return used;
    }

    public Set<Location> getUsedLocations() {
        return getUsedItems()
                .stream()
                .map(Item::getLocation)
                .collect(Collectors.toSet());
    }

    public Item getItemOnLocation(Location loc) {
        return getUsedItems()
                .stream()
                .filter(x -> x.getLocation().equals(loc))
                .findFirst()
                .orElse(null);
    }

    public void printPlan(Game game) {
        LocationPrinter.printPlan(this, game);
    }
}
