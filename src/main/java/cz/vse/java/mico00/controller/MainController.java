package cz.vse.java.mico00.controller;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.command.ICommandCollector;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.game.KeyPressHandler;
import cz.vse.java.mico00.item.Creature;
import cz.vse.java.mico00.item.Dragon;
import cz.vse.java.mico00.item.Item;
import cz.vse.java.mico00.output.ControllerOutput;
import javafx.geometry.Point2D;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class MainController extends GridPane {

    public TextArea warArea;
    public TextArea outputArea;

    private Game game;
    private KeyPressHandler keyPressHandler;

    public void init(Game game) {
        this.game = game;
        this.keyPressHandler = new KeyPressHandler(game);

        warArea.setFocusTraversable(true);
        warArea.setEditable(false);
        warArea.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 35");

        outputArea.setEditable(false);
    }

    public void handleKeyTyped(KeyEvent keyEvent) {
        keyPressHandler.handleKeyTyped(keyEvent.getCharacter().charAt(0));
    }

    public ControllerOutput getOutput() {
        return new ControllerOutput(warArea, outputArea);
    }
}
