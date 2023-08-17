package valerio.software1.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {
    /**
     * @param url
     * @param resourceBundle
     */

    @FXML
    private TextField addPartIdText;

    @FXML
    private RadioButton addPartInHouseButton;

    @FXML
    private TextField addPartInvText;

    @FXML
    private TextField addPartMachineIdText;

    @FXML
    private TextField addPartMaxText;

    @FXML
    private TextField addPartMinText;

    @FXML
    private TextField addPartNameText;

    @FXML
    private RadioButton addPartOutsourcedButton;

    @FXML
    private TextField addPartPriceText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
