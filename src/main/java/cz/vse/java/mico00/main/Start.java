/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse.java.mico00.main;


import cz.vse.java.mico00.logika.*;
import cz.vse.java.mico00.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/*******************************************************************************
 * Třída {@code Start} je hlavní třídou projektu,
 * který ...
 *
 * @author jméno autora
 * @version 0.00.000
 */
public class Start extends Application {
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            launch(args);
        } else if (args[0].equals("-text")) {
            IHra hra = new Hra();
            TextoveRozhrani ui = new TextoveRozhrani(hra);
            ui.hraj();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getResource("/hlavni.fxml"));

        stage.setTitle("blabal");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
