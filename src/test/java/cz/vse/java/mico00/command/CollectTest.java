package cz.vse.java.mico00.command;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.Location;
import cz.vse.java.mico00.game.LocationPlan;
import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Item;
import cz.vse.java.mico00.item.Loot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class CollectTest {

    private Game game;
    private Creature player;

    @Before
    public void setUp() {
        game = new Game();
        LocationPlan locationPlan = new LocationPlan("test plan", 1, 1);

        player = new Creature("player");
        player.setPlayer(true);
        player.setLocation(new Location(0, 0));

        Item item = new Loot("test item");
        item.setLocation(new Location(0, 0));

        game.setPlayer(player);
        game.setCurrentPlan(locationPlan);

        locationPlan.addItem(player);
        locationPlan.addItem(item);
    }

    @Test
    public void collect() {
        Collect collect = new Collect();
        collect.init(this.game);

        Assert.assertEquals(1, player.getLootSet().size());
    }
}
