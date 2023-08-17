package valerio.software1.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {
    @FXML
    private TextField modifyPartIdText;

    @FXML
    private RadioButton modifyPartInHouseButton;

    @FXML
    private TextField modifyPartInvText;

    @FXML
    private TextField modifyPartMachineIdText;

    @FXML
    private TextField modifyPartMaxText;

    @FXML
    private TextField modifyPartMinText;

    @FXML
    private TextField modifyPartNameText;

    @FXML
    private RadioButton modifyPartOutsourcedButton;

    @FXML
    private TextField modifyPartPriceText;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
