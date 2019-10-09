module cz.vse.java.mico00 {
    requires javafx.controls;
    requires javafx.fxml;
    exports cz.vse.java.mico00;
    opens cz.vse.java.mico00.main to javafx.graphics, javafx.fxml;
}