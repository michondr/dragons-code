package game;

import command.ICommand;
import item.*;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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
        player = new Creature("Laat Dovahkiin");
        player.setPlayer(true);
        player.setHpInitial(100);
        player.setHp(100);
        player.setHit(20);
        player.setLocation(new Location(0, 0));

        // Helgen
        LocationPlan helgen = new LocationPlan("Helgen",16, 6);

        // Falkreath
        LocationPlan falkreath = new LocationPlan("Falkreath",35, 10);

        // Riften
        LocationPlan riften = new LocationPlan("Riften", 30, 6);

        // Windhelm
        LocationPlan windhelm = new LocationPlan("Windhelm", 30, 13);

        // Winterhold
        LocationPlan winterhold = new LocationPlan("Winterhold", 45, 20);

        // Dawnstar
        LocationPlan downstar = new LocationPlan("Dawnstar", 20, 18);

        // Morthal
        LocationPlan morthal = new LocationPlan("Morthal", 30, 16);

        // Solitude
        LocationPlan solitude = new LocationPlan("Solitude", 30, 10);

        // Markarth
        LocationPlan markarth = new LocationPlan("Markarth", 35, 28);

        // Whiterun
        LocationPlan whiterun = new LocationPlan("Whiterun", 65, 20);

        // placing doors
        GameItemsFactory.createDoor(helgen, falkreath, new Location(1, 5), "Kill Ri'Dat and boots your armour and hit");

        GameItemsFactory.createDoor(falkreath, helgen, new Location(22, 2), "terrible dragon attack happened here, you must find out!");
        GameItemsFactory.createDoor(falkreath, markarth, new Location(0, 4));
        GameItemsFactory.createDoor(falkreath, whiterun, new Location(10, 0));
        GameItemsFactory.createDoor(falkreath, riften, new Location(falkreath.getPlanSizeEndpoint().getX()-1, 7));

        GameItemsFactory.createDoor(riften, falkreath, new Location(0, 3));
        GameItemsFactory.createDoor(riften, whiterun, new Location(1, 0));
        GameItemsFactory.createDoor(riften, windhelm, new Location(18, 0));

        GameItemsFactory.createDoor(windhelm, riften, new Location(17, windhelm.getPlanSizeEndpoint().getY()-1));
        GameItemsFactory.createDoor(windhelm, whiterun, new Location(0, 7));
        GameItemsFactory.createDoor(windhelm, winterhold, new Location(4, 0));

        GameItemsFactory.createDoor(winterhold, windhelm, new Location(35, winterhold.getPlanSizeEndpoint().getY()-1));
        GameItemsFactory.createDoor(winterhold, downstar, new Location(0, 10));

        GameItemsFactory.createDoor(downstar, whiterun, new Location(5, downstar.getPlanSizeEndpoint().getY()-1));
        GameItemsFactory.createDoor(downstar, morthal, new Location(0, 9));
        GameItemsFactory.createDoor(downstar, winterhold, new Location(downstar.getPlanSizeEndpoint().getX()-1, downstar.getPlanSizeEndpoint().getY()-4));

        GameItemsFactory.createDoor(morthal, whiterun, new Location(14, morthal.getPlanSizeEndpoint().getY()-1));
        GameItemsFactory.createDoor(morthal, markarth, new Location(0, 10));
        GameItemsFactory.createDoor(morthal, solitude, new Location(6, 0));
        GameItemsFactory.createDoor(morthal, downstar, new Location(morthal.getPlanSizeEndpoint().getX()-1, 6));

        GameItemsFactory.createDoor(solitude, morthal, new Location(25, solitude.getPlanSizeEndpoint().getY()-1));
        GameItemsFactory.createDoor(solitude, markarth, new Location(2, solitude.getPlanSizeEndpoint().getY()-1));

        GameItemsFactory.createDoor(markarth, solitude, new Location(3, 0));
        GameItemsFactory.createDoor(markarth, morthal, new Location(markarth.getPlanSizeEndpoint().getX()-1, 6));
        GameItemsFactory.createDoor(markarth, whiterun, new Location(markarth.getPlanSizeEndpoint().getX()-1, 10));
        GameItemsFactory.createDoor(markarth, falkreath, new Location(markarth.getPlanSizeEndpoint().getX()-1, markarth.getPlanSizeEndpoint().getY()-1));

        GameItemsFactory.createDoor(whiterun, falkreath, new Location(30, whiterun.getPlanSizeEndpoint().getY()-1));
        GameItemsFactory.createDoor(whiterun, markarth, new Location(0, 10));
        GameItemsFactory.createDoor(whiterun, morthal, new Location(20,0));
        GameItemsFactory.createDoor(whiterun, downstar, new Location(55,0));
        GameItemsFactory.createDoor(whiterun, windhelm, new Location(whiterun.getPlanSizeEndpoint().getX()-1, 6));
        GameItemsFactory.createDoor(whiterun, riften, new Location(whiterun.getPlanSizeEndpoint().getX()-1, whiterun.getPlanSizeEndpoint().getY()-5));


        // finishing touches
        currentLocation = falkreath;
        baseLocation = helgen;
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
                    if (command.isMove()) {
                        handleMovingCreatures();
                    }
                    command.init(currentGame);
                    handleCurrentLocationInfo();

                }
            }
        });
    }

    private void handleCurrentLocationInfo() {
        Item itemOnLocation = getCurrentPlan().getItemByLocation(getPlayer().getLocation());

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
        currentLocation.printPlan(this);

        getPlayer().setHp(getPlayer().getHpInitial());
        for (Creature creature : currentLocation.getCreatures()) {
            creature.setHp(creature.getHpInitial());
        }
    }

    public LocationPlan getBaseLocation() {
        return baseLocation;
    }
}
