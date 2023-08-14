package valerio.software1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainFormController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}