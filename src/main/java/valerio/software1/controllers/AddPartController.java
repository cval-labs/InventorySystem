package valerio.software1.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import valerio.software1.model.InHouse;
import valerio.software1.model.Inventory;
import valerio.software1.model.Outsourced;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Cristina Valerio
 */
public class AddPartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton addPartInHouseButton;

    @FXML
    private RadioButton addPartOutsourcedButton;

    @FXML
    private TextField addPartIdText;

    @FXML
    private TextField addPartNameText;

    @FXML
    private TextField addPartInvText;

    @FXML
    private TextField addPartPriceText;

    @FXML
    private TextField addPartMaxText;

    @FXML
    private TextField addPartMinText;

    @FXML
    private TextField textIdAndCompName;

    @FXML
    private Label machineIdToCompName;

    @FXML
    void onActionCancelAddedPart(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Input data will not be saved! Do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
            stage.setScene(new Scene(scene));
            stage.show();
        }


    }

    @FXML
    void onInHouse(ActionEvent actionEvent) {
        machineIdToCompName.setText("Machine ID");
    }

    @FXML
    void onOutsourced(ActionEvent actionEvent) {
        machineIdToCompName.setText("Company Name");
    }

    @FXML
    void onActionSaveAddedPart(ActionEvent event) throws IOException {

        try
        {
            String name = addPartNameText.getText();
            String stockS = addPartInvText.getText();
            String priceS = addPartPriceText.getText();
            String maxS = addPartMaxText.getText();
            String minS = addPartMinText.getText();
            String machineIdS = textIdAndCompName.getText();

            // int id = Integer.parseInt(addPartIdText.getText());

            int stock = Integer.parseInt(stockS);
            double price = Double.parseDouble(priceS);
            int max = Integer.parseInt(maxS);
            int min = Integer.parseInt(minS);

            if (min > stock) {
                System.out.println("Inv must be greater than min");
                return;
            }

            if (max < stock) {
                System.out.println("Inv must be less than max");
                return;
            }

            int id = Inventory.generateUniquePartId(); // doesn't increase ID if placed after validation checks

            if (addPartInHouseButton.isSelected()) {
                int machineId = Integer.parseInt(machineIdS);
                Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
            }
            else if (addPartOutsourcedButton.isSelected()){
                String companyName = textIdAndCompName.getText();
                Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
            }

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
            stage.setScene(new Scene(scene));
            stage.show();

        } catch(NumberFormatException e){
            System.out.println("Please enter valid values");
            System.out.println("Exception: " + e);
            System.out.println("Exception: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialogue");
            alert.setContentText("Please enter a valid value for each text field!");
            alert.showAndWait();
        }


    }

    /**
     * initializes the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addPartIdText.setDisable(true);
    }

}
