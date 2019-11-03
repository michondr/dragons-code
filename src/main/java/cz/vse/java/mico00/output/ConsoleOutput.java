package cz.vse.java.mico00.output;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.game.Location;
import cz.vse.java.mico00.game.LocationPlan;
import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Dragon;
import cz.vse.java.mico00.item.Item;

public class ConsoleOutput implements IOutput {

    @Override
    public void output(String str) {
        System.out.println(str);
    }

    @Override
    public void outputRewrite(String str) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        output(str);
    }

    @Override
    public void outputPlan(Game game) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        printPlan(game);

        outputRewrite("");
    }


    public void printPlan(Game game) {
        LocationPlan plan = game.getCurrentPlan();
        Location endpoint = plan.getPlanSizeEndpoint();
        Creature player = game.getPlayer();

        game.getTexts().printTextInBlue(plan.getName());
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
                    Creature creature = (Creature) curItem;

                    if (creature.getHp() / player.getHit() > player.getHp() / creature.getHit()) {
                        System.out.print(GameTexts.RED + creature.getSymbol());
                        System.out.print(GameTexts.RESET);
                    } else {
                        System.out.print(creature.getSymbol());
                    }

                } else {
                    System.out.print(curItem.getSymbol());
                }

            }
            System.out.print("|");
            System.out.println();
        }

        printEndRow(endpoint.getX());
    }

    private void printEndRow(int size) {
        for (int x = 0; x < size + 2; x++) {
            System.out.print("-");
        }
        System.out.println(GameTexts.RESET);
    }

}
