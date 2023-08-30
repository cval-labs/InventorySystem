package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import valerio.software1.model.InHouse;
import valerio.software1.model.Inventory;
import valerio.software1.model.Outsourced;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Label machineIdToCompName;

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

    @FXML
    void onInHouse(ActionEvent actionEvent) {
        machineIdToCompName.setText("Machine ID");
    }

    @FXML
    void onOutsourced(ActionEvent actionEvent) {
        machineIdToCompName.setText("Company Name");
    }

    @FXML
    void onActionCancelModifyPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSaveModifyPart(ActionEvent event) {

        int id = Integer.parseInt(modifyPartIdText.getText());
        String name = modifyPartNameText.getText();
        int stock = Integer.parseInt(modifyPartInvText.getText());
        double price = Double.parseDouble(modifyPartPriceText.getText());
        int max = Integer.parseInt(modifyPartMaxText.getText());
        int min = Integer.parseInt(modifyPartMinText.getText());

        if(modifyPartInHouseButton.isSelected()){
            int machineId = Integer.parseInt(modifyPartMachineIdText.getText());
           // TODO: Index?? Inventory.updatePart(, new InHouse(id, name, price, stock, min, max, machineId));
        } else if (modifyPartOutsourcedButton.isSelected()){
            String companyName = modifyPartMachineIdText.getText();
           // TODO: Index?? Inventory.updatePart(, new Outsourced(id, name, price, stock, min, max, companyName));
        }
    }

    /**
     * initializes the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
