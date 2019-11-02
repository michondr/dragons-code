package cz.vse.java.mico00;

import cz.vse.java.mico00.command.ICommand;
import cz.vse.java.mico00.controller.MainController;
import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.GameTexts;
import cz.vse.java.mico00.output.ConsoleOutput;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ondřej Michálek me@michondr.cz || mico00@vse.cz
 */
public class Main extends Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            launch(args);
        } else if (args[0].equals("-text")) {

            Game dragons_code = new Game(new ConsoleOutput());
            dragons_code.init();
        } else {
            System.out.println("Textová verze se spustí argumentem -text");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/hlavni.fxml"));

        GridPane root = loader.load();

        primaryStage.setTitle("Dragons Code");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Inconsolata:700");

        primaryStage.setScene(scene);

        MainController controller = loader.getController();

        Game dragons_code = new Game(controller.getOutput());
        dragons_code.init();

        controller.init(dragons_code);

        primaryStage.show();
    }
}
