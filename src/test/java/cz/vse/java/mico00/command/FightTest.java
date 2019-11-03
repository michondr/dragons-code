package cz.vse.java.mico00.command;

import cz.vse.java.mico00.item.Creature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class FightTest {

    private Creature player;

    @Before
    public void setUp() {
        player = new Creature("player");
        player.setPlayer(true);
        player.setHit(100);
        player.setHp(100);
        player.setHpInitial(100);
    }

    @Test
    public void fightWin() {
        Creature creature = new Creature("test creature", "", false, false, 50, 1);

        Fight fightCommand = new Fight();
        fightCommand.handleCreatureHp(player, creature);

        Assert.assertTrue(creature.getHp() < 0);
        Assert.assertTrue(player.getHp() > 0);
    }

    @Test
    public void fightLoose() {
        Creature creature = new Creature("test creature", "", false, false, 1000, 400);

        Fight fightCommand = new Fight();
        fightCommand.handleCreatureHp(player, creature);

        Assert.assertTrue(creature.getHp() > 0);
        Assert.assertTrue(player.getHp() < 0);
    }
}
