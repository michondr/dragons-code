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
        LocationPlan helgen = new LocationPlan("Helgen",16, 8);

        GameItemsFactory.createItems(helgen,
                new Creature("Malpenar Lusius", "Leader of this unit, half of his men died during an attack of a dragon", false, true, 150, 10),
                new Creature("Arenara Acicius"),
                new Creature("Oritonde Cedus"),
                new Creature("Clagius Entius"),
                new Creature("Namana Egnatius"),
                new Loot("broken arrow", "hit impenetrable dragon scale", 0, 1),
                new Loot("imperial sword", "+2 hit", 3, 1)
        );

        // Falkreath
        LocationPlan falkreath = new LocationPlan("Falkreath",25, 7);

        GameItemsFactory.createItems(falkreath,
                new Dragon("Odahviing", "As for myself, you've proven your mastery twice over. Thuri, Dovahkiin. I gladly acknowledge the power of your Thu'um", 20, 30),
                new Creature("Jarl Siddgeir", "jarl of Falkreath", true, false, 100, 1),
                new Creature("Dro'Baad", "bandit", false, true, 101, 13),
                new Creature("Ri'Dat", "bandit", false, true, 95, 1),
                new Creature("Wadargo", "bandit", false, true, 102, 8),
                new Loot("gold", "", 0, 20)
        );

        GameItemsFactory.addLootToCreature(falkreath, "Odahviing",
                new Loot("dragon soul", "from Odahviing", 100, 1),
                new Loot("gold", "", 0, 100)
        );

        GameItemsFactory.addLootToCreature(falkreath, "Ri'Dat",
                new Loot("khajit needle", "+12 hit",  4, 1),
                new Loot("furry armor", "+10 armor",  5, 1)
                );

        Place doorToFalkreath = new Place(falkreath);
        doorToFalkreath.setLocation(new Location(1, 1));
        helgen.addItem(doorToFalkreath);

        Place doorToHelgen = new Place(helgen);
        falkreath.addItem(doorToHelgen);
        doorToHelgen.setLocation(new Location(1, 1));


        /*

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
        churchPlan.addItem(new Place("base", baseLocation));
        baseLocation.addItem(church);

*/
        // finishing touches
        currentLocation = helgen;
        baseLocation = falkreath;
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
        player.setLocation(new Location(0, 0));
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
