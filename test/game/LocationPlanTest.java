package game;

import item.Creature;
import item.Door;
import item.Dragon;
import item.Loot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class LocationPlanTest {

    private LocationPlan plan = new LocationPlan("test plan", 1, 1);

    @Before
    public void setUp() {
        plan.addItem(new Loot("loot0"));
        plan.addItem(new Loot("loot1"));
        plan.addItem(new Loot("loot2"));

        plan.addItem(new Creature("creature0"));
        plan.addItem(new Creature("creature1"));

        plan.addItem(new Dragon("dragon1"));

        plan.addItem(new Door(plan));
    }

    @Test
    public void lootCount() {
        Assert.assertEquals(3, plan.getLoot().size());
    }

    @Test
    public void creatureCount() {
        Assert.assertEquals(2, plan.getCreatures().size());
    }

    @Test
    public void dragonCount() {
        Assert.assertEquals(1, plan.getDragons().size());
    }

    @Test
    public void doorCount() {
        Assert.assertEquals(1, plan.getDoors().size());
    }


}
