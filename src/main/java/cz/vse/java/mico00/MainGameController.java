package cz.vse.java.mico00;

import cz.vse.java.mico00.controller.MainController;
import cz.vse.java.mico00.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainGameController extends Application {

    public void startGame(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/hlavni.fxml"));

        GridPane root = loader.load();

        primaryStage.setTitle("Dragons Code");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Major+Mono+Display");

        primaryStage.setScene(scene);

        MainController controller = loader.getController();

        Game dragons_code = new Game(controller.getOutput());
        dragons_code.init();

        controller.init(dragons_code);

        primaryStage.show();
    }
}
