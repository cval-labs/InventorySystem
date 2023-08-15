module valerio.software1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens valerio.software1 to javafx.fxml;
    exports valerio.software1;
    exports valerio.software1.controllers;
    opens valerio.software1.controllers to javafx.fxml;
}