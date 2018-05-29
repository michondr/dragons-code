package item;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Creature extends Item implements IPrintable {

    private Set<Loot> lootSet;
    private boolean friendly;
    private boolean player;

    public Creature(String name){
        super(name);
        lootSet = new HashSet<>();
        this.friendly = false;
        this.player = false;
    }

    public Set<Loot> getLootSet() {
        return lootSet;
    }

    public void addLoot(Loot loot) {
        this.lootSet.add(loot);
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(boolean friendly) {
        this.friendly = friendly;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    @Override
    public char getSymbol() {
        if(isPlayer()){
            return '@';
        }

        return '!';
    }
}
