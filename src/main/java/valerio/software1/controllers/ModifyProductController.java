package valerio.software1.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import valerio.software1.model.Inventory;
import valerio.software1.model.Part;
import valerio.software1.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * This is the controller for modify-product.fxml.
 */
public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> modProdAddInvLevel;

    @FXML
    private TableColumn<Part, Integer> modProdAddPartId;

    @FXML
    private TableColumn<Part, String> modProdAddPartName;

    @FXML
    private TableColumn<Part, Double> modProdAddPrice;

    // top table
    @FXML
    private TableView<Part> modProdAddingTV;

    @FXML
    private TextField modProdIdText;

    @FXML
    private TextField modProdInvText;

    @FXML
    private TextField modProdMaxText;

    @FXML
    private TextField modProdMinText;

    @FXML
    private TextField modProdNameText;

    @FXML
    private TextField modProdPriceText;

    @FXML
    private TableColumn<Part, Integer> modProdRemPartId;

    @FXML
    private TableColumn<Part, String> modProdRemPartName;

    @FXML
    private TableColumn<Part, Double> modProdRemPrice;

    // bottom table
    @FXML
    private TableView<Part> modProdRemovingTV;

    @FXML
    private TableColumn<Part, Integer> modProdRenInvLevel;

    @FXML
    private TextField modProdSearch;

    /**
     * This observable list is for parts associated with a product.
     */
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    @FXML
    void onActionAddModProduct(ActionEvent event) {
        // Move parts from top table to bottom table
        try {
            System.out.println("add button clicked");
            Part partToAdd = modProdAddingTV.getSelectionModel().getSelectedItem();

            if (partToAdd == null)
                return;

            associatedParts.add(partToAdd);

        } catch(NullPointerException e){
            // ignore
        }
    }

    @FXML
    void onActionRemovePartModProduct(ActionEvent event) {

        Part associatedPart = modProdRemovingTV.getSelectionModel().getSelectedItem();

        if (associatedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a product");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This part will be removed! Do you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                associatedParts.remove(associatedPart);
            }
        }
    }

    @FXML
    void onActionSaveModifyProduct(ActionEvent event) throws IOException {
        try {
            String name = modProdNameText.getText();
            String stockS = modProdInvText.getText();
            String priceS = modProdPriceText.getText();
            String maxS = modProdMaxText.getText();
            String minS = modProdMinText.getText();

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

            int id = Integer.parseInt(modProdIdText.getText());
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

            if (!priceS.contains(".")) {
                // System.out.println("Price must be a double");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Price must be a double");
                alert.showAndWait();
                return;
            }

            //Inventory.updatesProduct(id, new Product(id, name, price, stock, min, max));
            Product modifiedProduct = new Product(id, name, price, stock, min, max);
            for(Part addPart : associatedParts) {
                modifiedProduct.addAssociatedPart(addPart);
            }

            int index = -1;
            for(Product modProduct : Inventory.getAllProducts()) {
                index++;
                if (modProduct.getId() == id) {
                    Inventory.updateProduct(index, modifiedProduct);
                    break; // exits for-loop entirely
                }
            }

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
            stage.setScene(new Scene(scene));
            stage.show();
        } catch (NumberFormatException e) {
//            System.out.println("Please enter valid values");
//            System.out.println("Exception: " + e);
//            System.out.println("Exception: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialogue");
            alert.setContentText("Please enter a valid value for each text field!");
            alert.showAndWait();
        }

    }

    @FXML
    void onActionCancelModifyProduct(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Any modified data will not be saved! Do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    /**
     * This method moves the data of a selected product on the Main Screen tableview to the Modify Product screen.
     * @param product the product moved to Modify Product
     */
    public void moveProduct(Product product) {
        try {
            modProdIdText.setText(String.valueOf(product.getId()));
            modProdNameText.setText(product.getName());
            modProdInvText.setText(String.valueOf(product.getStock()));
            modProdPriceText.setText(String.valueOf(product.getPrice()));
            modProdMaxText.setText(String.valueOf(product.getMax()));
            modProdMinText.setText(String.valueOf(product.getMin()));
            //modProdRemovingTV.setItems(product.getAllAssociatedParts());
            associatedParts.addAll(product.getAllAssociatedParts());
        } catch (NullPointerException e) {
            //ignore
        }
    }

    @FXML
    void partSearch(ActionEvent event) {
        String search = modProdSearch.getText();

        ObservableList<Part> parts = Inventory.lookupPart(search);

        if (parts.size() == 0) {
            try {
                int partId = Integer.parseInt(search);
                Part partToSearch = Inventory.lookupPart(partId);

                if (partToSearch != null) {
                    parts.add(partToSearch);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "This part does not exist");
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        modProdSearch.setText("");
                        return;
                    }
                }
            }
            catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "This part does not exist");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    modProdSearch.setText("");
                    return;
                }
            }

        }

        modProdAddingTV.setItems(parts);
        modProdSearch.setText("");

    }

    /**
     * This initializes the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            modProdIdText.setDisable(true);

            modProdAddingTV.setItems(Inventory.getAllParts());

            modProdAddPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
            modProdAddPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
            modProdAddInvLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
            modProdAddPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


            modProdRemovingTV.setItems(associatedParts);

            modProdRemPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
            modProdRemPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
            modProdRenInvLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
            modProdRemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
