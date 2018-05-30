package item;

import game.GameEquipmentResolver;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Dragon extends Creature implements IPrintable {

    public Dragon(String name) {
        super(name);
    }

    public Dragon(String name, String desription, int hp, int hit) {
        super(name, desription, false, true, hp, hit);
    }

    public Dragon(String name, String desription, int hp, int hit, Loot ... loots) {
        super(name, desription, false, true, hp, hit, loots);
    }

    @Override
    public char getSymbol() {
        return 'W';
    }
}
