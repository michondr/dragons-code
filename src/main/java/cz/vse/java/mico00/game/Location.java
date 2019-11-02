package cz.vse.java.mico00.game;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        Location loc = (Location) obj;
        return loc.getX() == this.x && loc.getY() == this.y;
    }

    @Override
    public String toString() {
        return "x: "+x+" y: "+y;
    }
}
