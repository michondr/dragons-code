package cz.vse.java.mico00.output;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.game.Location;
import cz.vse.java.mico00.game.LocationPlan;
import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Dragon;
import cz.vse.java.mico00.item.Item;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ControllerOutput implements IOutput {

    private TextArea warArea;
    private TextArea outputArea;

    public ControllerOutput(TextArea warArea, TextArea outputArea) {
        this.warArea = warArea;
        this.outputArea = outputArea;
    }

    @Override
    public void output(String str) {
        outputArea.appendText(str);
    }

    @Override
    public void outputRewrite(String str) {
        outputArea.setText(str);
    }

    @Override
    public void outputPlan(Game game) {
        warArea.setText(getPlanText(game));
    }

    public String getPlanText(Game game) {
        LocationPlan plan = game.getCurrentPlan();
        Location endpoint = plan.getPlanSizeEndpoint();
        Creature player = game.getPlayer();

        StringBuilder planText = new StringBuilder();
        planText.append(plan.getName());
        planText.append("\n");

        planText.append(printEndRow(endpoint.getX()));

        for (int y = 0; y < endpoint.getY(); y++) {
            planText.append("|");

            for (int x = 0; x < endpoint.getX(); x++) {
                Location curLoc = new Location(x, y);

                if (player.getLocation().equals(curLoc)) {
                    planText.append(player.getSymbol());

                    continue;
                }

                Item curItem = plan.getItemByLocation(curLoc);

                if (curItem == null) {
                    planText.append(" ");
                } else {
                    planText.append(curItem.getSymbol());
                }

            }
            planText.append("|");
            planText.append("\n");
        }

        planText.append(printEndRow(endpoint.getX()));

        return planText.toString();
    }

    private String printEndRow(int size) {
        return "-".repeat(Math.max(0, size + 2)) + "\n";
    }
}
