package cz.vse.java.mico00.game;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Dragon;
import cz.vse.java.mico00.item.Item;
import cz.vse.java.mico00.output.IOutput;

import java.util.concurrent.ThreadLocalRandom;

public class KeyPressHandler {

    private Game game;
    private IOutput output;

    public KeyPressHandler(Game game) {
        this.game = game;
        this.output = game.getOutput();
    }

    public void handleCurrentLocationInfo() {
        Item itemOnLocation = game.getCurrentPlan().getItemByLocation(game.getPlayer().getLocation());

        if (itemOnLocation != null) {
            output.output(itemOnLocation.toString());
        }
    }

    /**
     * move movable creature to randomly to random position or not
     * and look after walking yout of the frame
     */
    public void handleMovingCreatures() {
        for (Creature cr : game.getCurrentPlan().getCreatures()) {
            if (!cr.isMoving()) {
                continue;
            }

            int randX = 0;
            int randY = 0;

            switch (ThreadLocalRandom.current().nextInt(5)) {
                case 1:
                    randX = 1;
                    randY = 0;
                    break;
                case 2:
                    randX = -1;
                    randY = 0;
                    break;
                case 3:
                    randX = 0;
                    randY = 1;
                    break;
                case 4:
                    randX = 0;
                    randY = -1;
                    break;
            }

            if (cr.getLocation().getX() == 0 && randX < 0) {
                randX = 0;
            }
            if (cr.getLocation().getY() == 0 && randY < 0) {
                randY = 0;
            }
            if (cr.getLocation().getX() == game.getCurrentPlan().getPlanSizeEndpoint().getX() - 1 && randX > 0) {
                randX = 0;
            }
            if (cr.getLocation().getY() == game.getCurrentPlan().getPlanSizeEndpoint().getY() - 1 && randY > 0) {
                randY = 0;
            }
            cr.editLocation(randX, randY);
        }
    }

    /**
     * same as handleMovingCreatures, but more drastic
     */
    public void handleMovingDragons() {
        for (Dragon dr : game.getCurrentPlan().getDragons()) {
            if (!dr.isMoving()) {
                continue;
            }

            int randX = 0;
            int randY = 0;

            switch (ThreadLocalRandom.current().nextInt(12)) {
                case 1:
                    randX = 1;
                    randY = 1;
                    break;
                case 2:
                    randX = -1;
                    randY = -1;
                    break;
                case 3:
                    randX = -1;
                    randY = 1;
                    break;
                case 4:
                    randX = 1;
                    randY = -1;
                    break;
                case 5:
                    randX = 1;
                    randY = 0;
                    break;
                case 6:
                    randX = -1;
                    randY = 0;
                    break;
                case 7:
                    randX = 0;
                    randY = 1;
                    break;
                case 8:
                    randX = 0;
                    randY = -1;
                    break;
            }

            if (dr.getLocation().getX() == 0 && randX < 0) {
                randX = 0;
            }
            if (dr.getLocation().getY() == 0 && randY < 0) {
                randY = 0;
            }
            if (dr.getLocation().getX() == game.getCurrentPlan().getPlanSizeEndpoint().getX() - 1 && randX > 0) {
                randX = 0;
            }
            if (dr.getLocation().getY() == game.getCurrentPlan().getPlanSizeEndpoint().getY() - 1 && randY > 0) {
                randY = 0;
            }
            dr.editLocation(randX, randY);
        }
    }
}
