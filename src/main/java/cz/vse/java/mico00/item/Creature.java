package cz.vse.java.mico00.item;

import cz.vse.java.mico00.game.GameEquipmentResolver;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 *
 * method overloading if cool and stuff, but I'm missing default arguments from php.
 * overloading creates soo much more code
 */
public class Creature extends Item implements IPrintable {

    private Set<Loot> lootSet;
    private boolean friendly;
    private boolean player;
    private boolean moving;
    private int hp;
    private int hpInitial;
    private int hit;

    public Creature(String name) {
        super(name);
        lootSet = new HashSet<>();
        this.friendly = false;
        this.player = false;
        this.moving = true;
        this.hp = 100;
        this.hpInitial = 1000;
        this.hit = 1;
    }

    public Creature(String name, String desription, boolean friendly, boolean moving, int hp, int hit) {
        super(name);
        setDescription(desription);
        this.friendly = friendly;
        this.moving = moving;
        this.hp = hp;
        this.hpInitial = hp;
        this.hit = hit;

        lootSet = new HashSet<>();
        this.player = false;
    }

    public Creature(String name, String desription, boolean friendly, boolean moving, int hp, int hit, Loot ... loot) {
        super(name);
        setDescription(desription);
        this.friendly = friendly;
        this.moving = moving;
        this.hp = hp;
        this.hpInitial = hp;
        this.hit = hit;

        lootSet = Set.of(loot);
        this.player = false;
    }

    public Set<Loot> getLootSet() {
        return lootSet;
    }

    public void addLoot(Loot loot) {
        Loot contains = null;

        for (Loot lt : lootSet) {
            if (lt.getDescription().equals(loot.getDescription()) && lt.getName().equals(loot.getName())) {
                contains = lt;
            }
        }

        if (contains != null) {
            contains.setQuantity(contains.getQuantity() + loot.getQuantity());
        } else {
            hit += GameEquipmentResolver.resolveHitChange(loot);
            hpInitial += GameEquipmentResolver.resolveHPChange(loot);
            hp += GameEquipmentResolver.resolveHPChange(loot);
            this.lootSet.add(loot);
        }
    }

    public void addLoot(Set<Loot> loots) {
        for (Loot l : loots) {
            addLoot(l);
        }
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
        if (isPlayer()) {
            return '@';
        }

        return '!';
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHitRandomized() {
        int lower = (int) Math.round(0.8 * getHit());
        int upper = (int) Math.round(1.1 * getHit());

        return ThreadLocalRandom.current().nextInt(lower, upper + 1);
    }

    public int getHpInitial() {
        return hpInitial;
    }

    public void setHpInitial(int hpInitial) {
        this.hpInitial = hpInitial;
    }

    @Override
    public String toString() {
        String parent = "(" + super.getClass().getSimpleName() + ") " + getName();

        if (!getDescription().equals("")) {
            parent += " \"" + getDescription() + "\"\n";
        }

        StringJoiner loot = new StringJoiner(", ");

        for (Loot l : getLootSet()) {
            loot.add(l.getName());
        }
        return parent + "loot: " + loot + "\n";
    }
}
