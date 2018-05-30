package game;

import item.Loot;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class GameEquipmentResolver {

    public static int resolveHitChange(Loot item) {
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
            case "forging gloves":
                level += 12;
                break;
            case "great goblin axe":
                level += 25;
                break;
            case "draugr sword":
                level += 12;
                break;
            case "draugr bow":
                level += 3;
                break;
            case "Scroll of Firebolt":
                level += 10;
                break;
            case "Scroll of Fire Storm":
                level += 10;
                break;
            case "J'zargo's Flame Cloak Scroll":
                level += 50;
                break;
            case "Scroll of Lightning Rune":
                level += 15;
                break;
        }

        return level;
    }

    public static int resolveHPChange(Loot item) {
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
            case "dragon scale armour":
                level += 100;
                break;
            case "forging gloves":
                level += 2;
                break;
            case "light potion of life":
                level += 3;
                break;
            case "Scroll of Grand Healing":
                level += 30;
                break;
            case "Scroll of Cure Wounds":
                level += 10;
                break;
            case "Scroll of Guardian Circle":
                level += 50;
                break;
            case "Scroll of Circle of Protection":
                level += 5;
                break;
            case "Scroll of Turn Greater Undead":
                level += 13;
                break;
            case "Scroll of Fast Healing":
                level += 30;
                break;
            case "Book of healing":
                level += 10;
                break;
            case "Book of protection":
                level += 10;
                break;
            case "Advances in healing spells":
                level += 15;
                break;
            case "J'zargo's Flame Cloak Scroll":
                level -= 50;
                break;

        }

        return level;
    }
}
