package game;

import item.Loot;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameEquipmentResolver {

    public static int resolveHitChage(Loot item) {
        int level = 0;
        switch (item.getName()) {
            case "imperial sword":
                level += 2;
                break;
            case "imperial arrow":
                level += 1;
                break;
            case "khajit needle":
                level += 12;
                break;
            case "potion of strength":
                level += 6;
                break;
            case "potion of great strength":
                level += 23;
                break;
            case "Thieves Guild Armor":
                level += 10;
                break;
            case "ring of medium destruction":
                level += 18;
                break;
            case "amulet of meditation":
                level += 1;
                break;
            case "sword of oath":
                level += 3;
                break;
            case "Thieves Guild Bow":
                level += 21;
                break;
        }

        return level;
    }

    public static int resolveHPChage(Loot item) {
        int level = 0;
        switch (item.getName()) {
            case "furry armor":
                level += 10;
                break;
            case "light potion of weakness":
                level -= 4;
                break;
            case "Thieves Guild Armor":
                level += 30;
                break;
            case "Stromcloack Hood":
                level += 5;
                break;
            case "amulet of meditation":
                level += 1;
                break;
            case "sword of oath":
                level -= 3;
                break;
            case "armor of Dead Nord":
                level += 12;
                break;
        }

        return level;
    }
}
