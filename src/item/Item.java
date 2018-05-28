package item;

import game.Location;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Item implements IPrintable {

    private String name;
    private String description;
    private Location location;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void editLocation(int xPlus, int yPlus) {
        this.location = new Location(location.getX() + xPlus, location.getY() + yPlus);
    }

    @Override
    public String toString() {
        return super.getClass() + " name: " + name + "(x: " + location.getX() + " y: " + location.getY() + ")\n";
    }

    @Override
    public char getSymbol() {
        return ' ';
    }
}
