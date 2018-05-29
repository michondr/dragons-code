package game;

import command.ICommand;
import item.Creature;
import item.Item;
import item.Loot;
import item.Place;

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
    private LocationPlan baseLocation;
    private Set<ICommand> commands;

    public void setCommands(Set<ICommand> commands) {
        this.commands = commands;
    }

    public void init() {

        player = new Creature("hero michondr");
        player.setPlayer(true);
        player.setLocation(new Location(0,0));
        Loot oneGold = new Loot("gold");
        oneGold.setDescription("previously owned by king Arthur");
        player.addLoot(oneGold);

        baseLocation = new LocationPlan(30, 10);

        Creature zombie = new Creature("zombie");
        zombie.setLocation(new Location(0, 1));
        baseLocation.addItem(zombie);

        Creature zombie2 = new Creature("zombie");
        baseLocation.addItem(zombie2);

        Loot bagOfMoney = new Loot("moneyyy");
        bagOfMoney.setWeight(10);
        baseLocation.addItem(bagOfMoney);

        LocationPlan churchPlan = new LocationPlan(10, 4);
        Loot table = new Loot("table");
        table.setPortable(false);
        table.setDescription("Aither, the antient one, was killed here by King the David");
        churchPlan.addItem(table);

        Loot dragonscale = new Loot("dragonscale");
        dragonscale.setWeight(8);
        dragonscale.setDescription("Kind the David used this sword to kill Aither");
        churchPlan.addItem(dragonscale);

        Place church = new Place("church", churchPlan);
        baseLocation.addItem(church);




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

    public Set<ICommand> getCommands(){
        return commands;
    }

    public Creature getPlayer() {
        return player;
    }

    public LocationPlan getCurrentPlan() {
        return currentLocation;
    }

    public LocationPlan getBaseLocation(){
        return baseLocation;
    }

    public void setCurrentPlan(LocationPlan plan){
        currentLocation = plan;
        player.setLocation(new Location(0, 0));
        currentLocation.printPlan(this);
    }
}
