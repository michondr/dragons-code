package game;

import command.ICommand;
import command.move.Up;
import item.Creature;
import item.Item;
import item.Loot;
import item.Place;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Game extends JFrame {

    private Creature player;
    private LocationPlan currentLocation;
    private LocationPlan baseLocation;
    private Set<ICommand> commands;

    public void init() {

        // player
        player = new Creature("hero michondr");
        player.setPlayer(true);
        player.setHp(100);
        player.setHit(1);
        player.setLocation(new Location(0, 0));

        // base location
        baseLocation = new LocationPlan(30, 10);

        Creature zombie = new Creature("zombie");
        zombie.setLocation(new Location(0, 1));
        zombie.setMoving(true);
        zombie.setHp(2);
        zombie.setHpInitial(100);
        zombie.setHit(3);
        baseLocation.addItem(zombie);

        Creature zombie2 = new Creature("zombie");
        baseLocation.addItem(zombie2);

        Loot bagOfMoney = new Loot("moneyyy");
        bagOfMoney.setWeight(10);
        baseLocation.addItem(bagOfMoney);

        Loot gold1 = new Loot("gold");
        baseLocation.addItem(gold1);
        Loot gold2 = new Loot("gold");
        baseLocation.addItem(gold2);
        Loot gold3 = new Loot("gold");
        baseLocation.addItem(gold3);

        // church
        LocationPlan churchPlan = new LocationPlan(10, 4);
        Loot table = new Loot("table");
        table.setPortable(false);
        table.setDescription("Aither, the antient one, was killed here by King the David");
        churchPlan.addItem(table);

        Loot dragonscale = new Loot("Dragonscale");
        dragonscale.setWeight(8);
        dragonscale.setDescription("The dragon slayer");
        churchPlan.addItem(dragonscale);

        Place church = new Place("church", churchPlan);
        baseLocation.addItem(church);

        // finishing touches
        currentLocation = baseLocation;
        currentLocation.printPlan(this);
        handleKeyPresses();
    }

    private void handleKeyPresses() {
        Game currentGame = this;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                ICommand command = getCommand(e.getKeyChar());

                if (command == null) {
                    System.err.println("Not valid command key, try again");
                } else {
                    if(command.isMove()){
                        handleMovingCreatures();
                    }
                    command.init(currentGame);
                    handleCurrentLocationInfo();

                }
            }
        });
    }

    private void handleCurrentLocationInfo() {
        Item itemOnLocation = getCurrentPlan().getItemOnLocation(getPlayer().getLocation());

        if (itemOnLocation == null) {
            System.out.println(GameTexts.getWanderText());
        } else {
            System.out.println(itemOnLocation.toString());
        }
    }

    private void handleMovingCreatures() {
        for (Creature cr : currentLocation.getCreatures()) {
            if (!cr.isMoving()) {
                continue;
            }

            Random ra = new Random();
            int randX = 0;
            int randY = 0;

            switch (ra.nextInt(5)) {
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
            if (cr.getLocation().getX() == getCurrentPlan().getPlanSizeEndpoint().getX() - 1 && randX > 0) {
                randX = 0;
            }
            if (cr.getLocation().getY() == getCurrentPlan().getPlanSizeEndpoint().getY() - 1 && randY > 0) {
                randY = 0;
            }
            cr.editLocation(randX, randY);
        }
    }

    private ICommand getCommand(char key) {
        return commands.stream().filter(x -> x.getKey() == key).findFirst().orElse(null);
    }

    public Set<ICommand> getCommands() {
        return commands;
    }

    public void setCommands(Set<ICommand> commands) {
        this.commands = commands;
    }

    public Creature getPlayer() {
        return player;
    }

    public LocationPlan getCurrentPlan() {
        return currentLocation;
    }

    public void setCurrentPlan(LocationPlan plan) {
        currentLocation = plan;
        player.setLocation(new Location(0, 0));
        currentLocation.printPlan(this);
    }

    public LocationPlan getBaseLocation() {
        return baseLocation;
    }
}
