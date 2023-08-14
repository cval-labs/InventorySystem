module valerio.software1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens valerio.software1 to javafx.fxml;
    exports valerio.software1;
}