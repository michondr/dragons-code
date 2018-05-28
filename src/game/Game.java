package game;

import command.ICommand;
import item.Creature;
import item.Item;
import item.Loot;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Game extends JFrame {

    private Creature player;
    private LocationPlan currentLocation;
    private Set<ICommand> commands;

    public void setCommands(Set<ICommand> commands) {
        this.commands = commands;
    }

    public void init() {

        player = new Creature("hero michondr");
        player.setPlayer(true);
        player.setLocation(new Location(0,0));
        LocationPlan baseLocation = new LocationPlan(30, 10);

        Creature zombie = new Creature("zombie");
        zombie.setLocation(new Location(0, 1));
        baseLocation.addItem(zombie);

        Creature zombie2 = new Creature("zombie");
        baseLocation.addItem(zombie2);

        Loot bagOfMoney = new Loot("moneyyy");
        baseLocation.addItem(bagOfMoney);

        baseLocation.printPlan(this);
        currentLocation = baseLocation;

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
                    command.init(currentGame);
                    handleCurrentLocationInfo();
                }
            }
        });
    }

    private void handleCurrentLocationInfo(){
        Item itemOnLocation = getCurrentPlan().getItemOnLocation(getPlayer().getLocation());

        if(itemOnLocation == null){
            System.out.println(GameTexts.getWanderText());
        } else {
            System.out.println(itemOnLocation.toString());
        }
    }

    private ICommand getCommand(char key) {
        return commands.stream().filter(x -> x.getKey() == key).findFirst().orElse(null);
    }

    public Creature getPlayer() {
        return player;
    }

    public LocationPlan getCurrentPlan() {
        return currentLocation;
    }
}
