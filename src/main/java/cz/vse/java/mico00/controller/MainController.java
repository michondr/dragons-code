package cz.vse.java.mico00.controller;

import cz.vse.java.mico00.game.Game;
import cz.vse.java.mico00.game.KeyPressHandler;
import cz.vse.java.mico00.output.ControllerOutput;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class MainController extends GridPane {

    public TextArea warArea;
    public TextArea outputArea;

    private Game game;
    private KeyPressHandler keyPressHandler;

    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();

    public void init(Game game) {
        this.game = game;
        this.keyPressHandler = new KeyPressHandler(game);

        warArea.setFocusTraversable(true);
        warArea.setEditable(false);
        warArea.setStyle("-fx-font-family: 'Major Mono Display'; -fx-font-size: 25");

        outputArea.setEditable(false);
    }

    public void handleKeyTyped(KeyEvent keyEvent) {
        keyPressHandler.handleKeyTyped(keyEvent.getCharacter().charAt(0));
    }

    public ControllerOutput getOutput() {
        return new ControllerOutput(warArea, outputArea);
    }

    public void newGame(ActionEvent actionEvent) {
    }

    public void showHelp(ActionEvent actionEvent) throws IOException {
//        Stage stage = new Stage();
//
//        stage.setTitle("HTML");
//        stage.setWidth(500);
//        stage.setHeight(500);
//        Scene scene = new Scene(new Group());
//
//        VBox root = new VBox();
//
//        final WebView browser = new WebView();
//        final WebEngine webEngine = browser.getEngine();
//
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(browser);
//        webEngine.loadContent(getClass().getResource("/help.html").getContent().toString());
//
//        root.getChildren().addAll(scrollPane);
//        scene.setRoot(root);
//
//        stage.setScene(scene);
//        stage.show();
        try {
//            File file = new File("C:/test/a.html");
            URL url = getClass().getResource("/help.html").toURI().toURL();
//             file:/C:/test/a.html
            System.out.println("Local URL: " + url.toString());
            this.webEngine.load(url.toString());
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
         VBox root = new VBox();
        root.setSpacing(5);
        root.getChildren().addAll(browser);

        Scene scene = new Scene(root);

        stage.setTitle("JavaFX WebView (o7planning.org)");
        stage.setScene(scene);
        stage.setWidth(450);
        stage.setHeight(300);

        stage.show();
    }
}
