package game;

import item.Creature;
import item.Item;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
class LocationPrinter {

    static void printPlan(LocationPlan plan, Game game) {
        Location endpoint = plan.getPlanSizeEndpoint();
        Creature player = game.getPlayer();
        printEndRow(endpoint.getX());

        for (int y = 0; y < endpoint.getY(); y++) {
            System.out.print("|");
            for (int x = 0; x < endpoint.getX(); x++) {
                Location curLoc = new Location(x, y);

                if(player.getLocation().equals(curLoc)){
                    System.out.print(player.getSymbol());
                    continue;
                }

                Item curItem = plan.getItemOnLocation(curLoc);

                if (curItem == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(curItem.getSymbol());
                }

            }
            System.out.print("|");
            System.out.println();
        }

        printEndRow(endpoint.getX());
    }

    private static void printEndRow(int size) {
        for (int x = 0; x < size + 2; x++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
