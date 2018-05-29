package game;

import command.ICommand;
import item.Creature;
import item.Item;
import item.Loot;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class LocationPrinter {

    static void printPlan(LocationPlan plan, Game game) {
        Location endpoint = plan.getPlanSizeEndpoint();
        Creature player = game.getPlayer();
        printEndRow(endpoint.getX());

        for (int y = 0; y < endpoint.getY(); y++) {
            System.out.print("|");
            for (int x = 0; x < endpoint.getX(); x++) {
                Location curLoc = new Location(x, y);

                if (player.getLocation().equals(curLoc)) {
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

    private static void printSeparator() {
        System.out.println("_________________________________________");
    }

    public static void printInventory(Creature creature) {
        printSeparator();
        System.out.println("name\tquantity\tweight\tdescription");

        for (Loot item : creature.getLootSet()) {
            System.out.println(
                    item.getName() + "\t"
                            + item.getQuantity() + "\t"
                            + item.getWeight() + "\t"
                            + item.getDescription()
            );
        }
    }

    public static void printInventory(Loot loot) {
        printSeparator();
        System.out.println("name\tweight\tdescription");

        System.out.println(
                loot.getName() + "\t"
                + loot.getWeight() + "\t"
                + loot.getDescription()
        );
    }

    public static void printHelp(Game game) {
        printSeparator();
        GameTexts.printHelpText();
        System.out.println("key\tdescription");

        for (ICommand command : game.getCommands()) {
            System.out.println(
                    command.getKey() + "\t"
                            + command.getDescription()
            );
        }
    }

}
