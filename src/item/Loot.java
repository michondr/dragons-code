package item;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Loot extends Item implements IPrintable {

    private int weight = 1;
    private boolean portable = true;

    public Loot(String name) {
        super(name);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isPortable() {
        return portable;
    }

    public void setPortable(boolean portable) {
        this.portable = portable;
    }

    @Override
    public char getSymbol() {
        return '$';
    }
}
