package game;

import command.ICommand;
import item.Creature;
import item.Dragon;
import item.Item;
import item.Loot;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class LocationPrinter {

    static void printPlan(LocationPlan plan, Game game) {
        Location endpoint = plan.getPlanSizeEndpoint();
        Creature player = game.getPlayer();

        GameTexts.printTextInBlue(plan.getName());
        printEndRow(endpoint.getX());

        for (int y = 0; y < endpoint.getY(); y++) {
            System.out.print("|");
            for (int x = 0; x < endpoint.getX(); x++) {
                Location curLoc = new Location(x, y);

                if (player.getLocation().equals(curLoc)) {
                    System.out.print(GameTexts.YELLOW + player.getSymbol());
                    System.out.print(GameTexts.RESET);
                    continue;
                }

                Item curItem = plan.getItemByLocation(curLoc);

                if (curItem == null) {
                    System.out.print(" ");
                } else if (curItem.getClass() == Creature.class || curItem.getClass() == Dragon.class) {
                    GameTexts.printCreatureColoredSymbol((Creature) curItem, game.getPlayer());
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
        System.out.println(GameTexts.RESET);
    }

    private static void printSeparator() {
        System.out.println(GameTexts.RESET + "_______________________________________________________________");
    }

    public static void printInventory(Creature creature) {
        printSeparator();

        final Object[][] table = new String[creature.getLootSet().size()+1][4];

        table[0] = new String[] { "quantity", "weight", "name", "description" };

        int currentIndex = 0;
        for (Loot item : creature.getLootSet()) {
            currentIndex++;

            table[currentIndex] = new String[] {
                    String.valueOf(item.getQuantity()),
                    String.valueOf(item.getWeight()),
                    item.getName(),
                    item.getDescription()
            };
        }

        for (final Object[] row : table) {
            System.out.format("%-10s%-10s%-40s%-15s\n", row);
        }
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
