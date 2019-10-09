package cz.vse.java.mico00.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainController extends GridPane {

    @FXML
    private TextField input;

    @FXML
    private TextField output;

    public void resolveInput(ActionEvent actionEvent) {
        System.out.println(input.getText());
    }
}
