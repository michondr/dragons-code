package cz.vse.java.mico00.game;

import cz.vse.java.mico00.Main;
import cz.vse.java.mico00.command.Help;
import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.command.ICommandCollector;
import cz.vse.java.mico00.item.*;
import cz.vse.java.mico00.output.IOutput;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Game {

    private GameTexts texts;
    private Creature player;
    private Set<ICommand> commands;
    private GameItemsCreator gameItemsCreator;
    private IOutput output;

    public Game(IOutput output) {
        commands = ICommandCollector.getCommands();

        this.gameItemsCreator = new GameItemsCreator();

        this.output = output;
        this.texts = new GameTexts(output);
    }

    public void init() {
        // player
        player = new Creature("Laat Dovahkiin");
        player.setPlayer(true);
        player.setHpInitial(100);
        player.setHp(100);
        player.setHit(1);
        player.setLocation(new Location(0, 0));

        // game
        gameItemsCreator.init();

        // finishing touches
        texts.printWelcome();
        Help.print(this);
        output.outputPlan(this);
    }

    public void end() {
        this.getTexts().printGoodbye();
        System.exit(0);
    }

    public ICommand getCommand(char key) {
        return commands.stream().filter(x -> x.getKey() == key).findFirst().orElse(null);
    }

    public Set<ICommand> getCommands() {
        return commands;
    }

    public Creature getPlayer() {
        return player;
    }

    public void setPlayer(Creature creature) {
        this.player = creature;
    }

    public LocationPlan getCurrentPlan() {
        return gameItemsCreator.getCurrentLocationPlan();
    }

    public void setCurrentPlan(LocationPlan plan) {
        gameItemsCreator.setCurrentLocationPlan(plan);
    }

    public LocationPlan getBaseLocation() {
        return gameItemsCreator.getBaseLocationPlan();
    }

    public IOutput getOutput() {
        return this.output;
    }

    public GameTexts getTexts() {
        return texts;
    }
}
