package cz.vse.java.mico00.item;

import cz.vse.java.mico00.game.LocationPlan;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Door extends Item implements IPrintable {

    private LocationPlan locationPlan;
    private String welcoming;

    public Door(LocationPlan locationPlan) {
        super(locationPlan.getName());
        this.locationPlan = locationPlan;
        this.welcoming = "";
    }

    public LocationPlan getLocationPlan() {
        return locationPlan;
    }

    @Override
    public char getSymbol() {
        return '#';
    }

    public String getWelcoming() {
        return welcoming;
    }

    public void setWelcoming(String welcoming) {
        this.welcoming = welcoming;
    }
}
