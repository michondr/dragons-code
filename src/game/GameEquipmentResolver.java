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
            case "khajit needle":
                level += 12;
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
        }

        return level;
    }
}
