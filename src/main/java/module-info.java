module cz.vse.java.mico00 {
    requires javafx.controls;
    requires reflections;

    exports cz.vse.java.mico00;
    opens cz.vse.java.mico00 to javafx.graphics, javafx.fxml;
}