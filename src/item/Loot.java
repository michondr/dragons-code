package item;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Loot extends Item implements IPrintable {

    private int weight;
    private int quantity;
    private boolean portable = true;

    public Loot(String name) {
        super(name);
        weight = 1;
        quantity = 1;
    }

    public int getWeight() {
        return weight * quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public char getSymbol() {
        return '$';
    }
}
