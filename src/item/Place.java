package item;

import game.LocationPlan;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Place extends Item implements IPrintable {

    private LocationPlan locationPlan;

    public Place(LocationPlan locationPlan) {
        super(locationPlan.getName());
        this.locationPlan = locationPlan;
    }

    public LocationPlan getLocationPlan() {
        return locationPlan;
    }

    @Override
    public char getSymbol() {
        return '#';
    }
}
