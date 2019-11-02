package cz.vse.java.mico00.item;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class CreatureTest {

    @Test
    public void playerSymbol(){
        Creature player = new Creature("test player");
        player.setPlayer(true);

        Assert.assertEquals('@', player.getSymbol());
    }

    @Test
    public void creatureSymbols(){
        Creature player = new Creature("test player");
        Assert.assertEquals('!', player.getSymbol());

        Dragon dragon = new Dragon("test dragon");
        Assert.assertEquals('W', dragon.getSymbol());
    }

    @Test
    public void creatureHit(){
        Creature creature = new Creature("test player");
        creature.setHit(100);

        boolean isCorrectHit0 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit0);

        boolean isCorrectHit1 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit1);

        boolean isCorrectHit2 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit2);

        boolean isCorrectHit3 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit3);

        boolean isCorrectHit4 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit4);

        boolean isCorrectHit5 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit5);

        boolean isCorrectHit6 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit6);

        boolean isCorrectHit7 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit7);

        boolean isCorrectHit8 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit8);

        boolean isCorrectHit9 = creature.getHitRandomized() <= 110 && creature.getHitRandomized() >= 80;
        Assert.assertTrue(isCorrectHit9);
    }
}