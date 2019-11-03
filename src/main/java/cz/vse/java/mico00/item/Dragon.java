package cz.vse.java.mico00.item;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Dragon extends Creature implements IPrintable {

    public Dragon(String name) {
        super(name);
    }

    public Dragon(String name, String desription, int hp, int hit, Loot ... loots) {
        super(name, desription, false, true, hp, hit, loots);
    }

    @Override
    public char getSymbol() {
        return 'W';
    }
}
