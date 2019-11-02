package cz.vse.java.mico00.item;

import cz.vse.java.mico00.game.Location;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Item implements IPrintable {

    private String name;
    private String description;
    private Location location;

    public Item(String name) {
        description = "";
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
        String suffix = "";

        if (!description.equals("")) {
            suffix = " - " + description;
        }

        suffix += " ("+getHint()+") ";

        return "(" + super.getClass().getSimpleName() + ") " + name + suffix + "\n";
    }

    @Override
    public char getSymbol() {
        return ' ';
    }

    @Override
    public String getHint() {
        return "";
    }
}
