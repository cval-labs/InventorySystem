package valerio.software1.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import valerio.software1.model.InHouse;
import valerio.software1.model.Inventory;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    Stage stage;
    Parent scene;

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

    @FXML
    void onActionCancelAddedPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void onInHouse(ActionEvent actionEvent) {
    }

    public void onOutsourced(ActionEvent actionEvent) {
    }

    @FXML
    void onActionSaveAddedPart(ActionEvent event) throws IOException {
        // TODO: add companyName for Outsourced radio button
        int id = Integer.parseInt(addPartIdText.getText());
        String name = addPartNameText.getText();
        int stock = Integer.parseInt(addPartInvText.getText());
        double price = Double.parseDouble(addPartPriceText.getText());
        int max = Integer.parseInt(addPartMaxText.getText());
        int min = Integer.parseInt(addPartMinText.getText());
        int machineId = Integer.parseInt(addPartMachineIdText.getText());
        /* TODO: 2 if-statements? one for In-House, other for Outsourced?
        boolean isInHouse;
        if (addPartInHouseButton.isSelected())
            isInHouse = true;
        else
            isInHouse = false;*/
        Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: initialize
    }

}
