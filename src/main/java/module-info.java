module cz.vse.java.mico00 {
    requires javafx.controls;
    requires reflections;
    requires javafx.fxml;
    requires javafx.web;

    exports cz.vse.java.mico00;
    exports cz.vse.java.mico00.controller;
    opens cz.vse.java.mico00 to javafx.graphics, javafx.fxml;
}