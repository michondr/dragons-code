package cz.vse.java.mico00;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.KeyPressHandler;
import cz.vse.java.mico00.output.ConsoleOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainGameCommand extends JFrame {
    private Game dragons_code;
    private KeyPressHandler keyPressHandler;

    public void startGame(String[] args) {

        this.dragons_code = new Game(new ConsoleOutput());
        this.dragons_code.init();

        this.keyPressHandler = new KeyPressHandler(dragons_code);

        try {
            // Get the object of DataInputStream
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                for (char c: line.toCharArray()){
                    handleKeyPresses(c);
                }
            }

            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void handleKeyPresses(char c) {
        ICommand command = this.dragons_code.getCommand(c);

        if (command == null) {
            System.err.println("Not valid command key, try again. press 'h' to list help");
        } else {
            if (command.isMove()) {
                keyPressHandler.handleMovingCreatures();
                keyPressHandler.handleMovingDragons();
            }

            command.init(dragons_code);
            keyPressHandler.handleCurrentLocationInfo();

            if (command.isMove()) {
                dragons_code.getTexts().printWanderText();
            }
        }

        dragons_code.getOutput().outputPlan(dragons_code);
    }
}