package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import valerio.software1.model.InHouse;
import valerio.software1.model.Inventory;
import valerio.software1.model.Outsourced;
import valerio.software1.model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * This is the controller for modify-product.fxml.
 */
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
    void onInHouse() {
        machineIdToCompName.setText("Machine ID");
    }

    @FXML
    void onOutsourced() {
        machineIdToCompName.setText("Company Name");
    }

    @FXML
    void onActionCancelModifyPart(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Any modified data will not be saved! Do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void onActionSaveModifyPart(ActionEvent event) throws IOException {
        try {
            // TODO: validation checks
            String name = modifyPartNameText.getText();
            String stockS = modifyPartInvText.getText();
            String priceS = modifyPartPriceText.getText();
            String maxS = modifyPartMaxText.getText();
            String minS = modifyPartMinText.getText();
            String machineIdS = modifyPartMachineIdText.getText();

            if (name.isEmpty()) {
                // System.out.println("Must enter a name");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a name");
                alert.showAndWait();
                return;
            }
            if (stockS.isEmpty()) {
                // System.out.println("Please enter an Inv value");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter an Inv value");
                alert.showAndWait();
                return;
            }
            if (priceS.isEmpty()) {
                // System.out.println("Please enter a price");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a price");
                alert.showAndWait();
                return;
            }
            if (maxS.isEmpty()) {
                // System.out.println("Please enter a Max value");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a Max value");
                alert.showAndWait();
                return;
            }
            if (minS.isEmpty()) {
                // System.out.println("Please enter a Min value");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a Min value");
                alert.showAndWait();
                return;
            }

            if (!priceS.contains(".")) {
                // System.out.println("Price must be a double");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Price must be a double");
                alert.showAndWait();
                return;
            }

            int id = Integer.parseInt(modifyPartIdText.getText());
            int stock = Integer.parseInt(stockS);
            double price = Double.parseDouble(priceS);
            int max = Integer.parseInt(maxS);
            int min = Integer.parseInt(minS);

            if (min > stock || max < stock) {
                // System.out.println("Inv must be between Max and Min");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Inv must be between Max and Min");
                alert.showAndWait();
                return;
            }

            if(modifyPartInHouseButton.isSelected()){
                if(machineIdS.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter a Machine ID");
                    alert.showAndWait();
                    return;
                }
                int machineId = Integer.parseInt(machineIdS);
                Inventory.updatesPart(id, new InHouse(id, name, price, stock, min, max, machineId));
                // Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
            } else if (modifyPartOutsourcedButton.isSelected()){
                String companyName = modifyPartMachineIdText.getText();
                if(companyName.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter a Company Name");
                    alert.showAndWait();
                    return;
                }
                // Inventory.updatePart(, new Outsourced(id, name, price, stock, min, max, companyName));
                Inventory.updatesPart(id, new Outsourced(id, name, price, stock, min, max, companyName));
            }

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
            stage.setScene(new Scene(scene));
            stage.show();

        } catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialogue");
            alert.setContentText("Please enter a valid value for each text field!");
            alert.showAndWait();
        }

    }


    /**
     * @param part the part to be moved to Modify Part
     */
    public void movePart(Part part) {
        modifyPartIdText.setText(String.valueOf(part.getId()));
        modifyPartNameText.setText(part.getName());
        modifyPartInvText.setText(String.valueOf(part.getStock()));
        modifyPartPriceText.setText(String.valueOf(part.getPrice()));
        modifyPartMaxText.setText(String.valueOf(part.getMax()));
        modifyPartMinText.setText(String.valueOf(part.getMin()));

        /*if(modifyPartInHouseButton.isSelected()){
            modifyPartMachineIdText.setText(part);
        }*/
        if(part instanceof InHouse) {
            modifyPartMachineIdText.setText(String.valueOf(((InHouse) part).getMachineId()));

        } else if (part instanceof Outsourced) {
            modifyPartOutsourcedButton.setSelected(true);
            machineIdToCompName.setText("Company Name");
            modifyPartMachineIdText.setText(((Outsourced) part).getCompanyName());
        }
    }

    /**
     * initializes the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifyPartIdText.setDisable(true);
    }
}
