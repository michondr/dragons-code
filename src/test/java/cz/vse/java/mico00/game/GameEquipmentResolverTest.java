package cz.vse.java.mico00.game;

import cz.vse.java.mico00.item.Loot;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameEquipmentResolverTest {

    @Test
    public void hitChange() {
        int ringOfMediumDestruction = GameEquipmentResolver.resolveHitChange(new Loot("ring of medium destruction"));
        Assert.assertEquals(18, ringOfMediumDestruction);

        int greatGoblinAxe = GameEquipmentResolver.resolveHitChange(new Loot("great goblin axe"));
        Assert.assertEquals(25, greatGoblinAxe);

        int jzargosFlameCloakCroll = GameEquipmentResolver.resolveHitChange(new Loot("J'zargo's Flame Cloak Scroll"));
        Assert.assertEquals(50, jzargosFlameCloakCroll);

        int scrollOfLightningRune = GameEquipmentResolver.resolveHitChange(new Loot("Scroll of Lightning Rune"));
        Assert.assertEquals(15, scrollOfLightningRune);
    }

    @Test
    public void hpChange() {
        int thievesArmor = GameEquipmentResolver.resolveHPChange(new Loot("Thieves Guild Armor"));
        Assert.assertEquals(30, thievesArmor);

        int amuletOfMeditation = GameEquipmentResolver.resolveHPChange(new Loot("amulet of meditation"));
        Assert.assertEquals(1, amuletOfMeditation);

        int armorOfDeadNord = GameEquipmentResolver.resolveHPChange(new Loot("armor of Dead Nord"));
        Assert.assertEquals(12, armorOfDeadNord);

        int dragonScaleArmour = GameEquipmentResolver.resolveHPChange(new Loot("dragon scale armour"));
        Assert.assertEquals(100, dragonScaleArmour);
    }
}
