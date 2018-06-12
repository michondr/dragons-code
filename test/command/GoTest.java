package command;

import game.Game;
import game.Location;
import game.LocationPlan;
import item.Creature;
import item.Door;
import item.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GoTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
        LocationPlan currentPlan = new LocationPlan("current plan", 1, 1);
        LocationPlan locationPlan = new LocationPlan("test plan", 1, 1);

        Creature player = new Creature("player");
        player.setPlayer(true);
        player.setLocation(new Location(0, 0));

        Item doorToTest = new Door(locationPlan);
        doorToTest.setLocation(new Location(0, 0));


        Item doorToCurrent = new Door(currentPlan);
        doorToCurrent.setLocation(new Location(0, 0));

        game.setPlayer(player);
        game.setCurrentPlan(currentPlan);

        currentPlan.addItem(player);
        currentPlan.addItem(doorToTest);
        locationPlan.addItem(doorToCurrent);
    }

    @Test
    public void go() {
        Go goCommand = new Go();
        goCommand.init(this.game);

        Assert.assertEquals("test plan", game.getCurrentPlan().getName());
    }
}
