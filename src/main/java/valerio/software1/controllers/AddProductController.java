package valerio.software1.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import valerio.software1.model.Inventory;
import valerio.software1.model.Part;
import valerio.software1.model.Product;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Cristina Valerio
 */
public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableView<Part> addProdAddingTableV; // top table

    @FXML
    private TableColumn<Part, Integer> addProdAddPartId;

    @FXML
    private TableColumn<Part, String> addProdAddPartName;

    @FXML
    private TableColumn<Part, Integer> addProdAddInvLevel;

    @FXML
    private TableColumn<Part, Double> addProdAddPrice;

    @FXML
    private TextField addProdIdText;

    @FXML
    private TextField addProdNameText;

    @FXML
    private TextField addProdInvText;

    @FXML
    private TextField addProdPriceText;

    @FXML
    private TextField addProdMaxText;

    @FXML
    private TextField addProdMinText;

    @FXML
    private TableView<Part> addProdRemovingTableV; // bottom table

    @FXML
    private TableColumn<Part, Integer> addProdRemPartId;

    @FXML
    private TableColumn<Part, String> addProdRemPartName;

    @FXML
    private TableColumn<Part, Integer> addProdRemInvLevel;

    @FXML
    private TableColumn<Part, Double> addProdRemPrice;

    @FXML
    private TextField addProdSearch;

    public ObservableList<Part> partsForProduct = FXCollections.observableArrayList();

    /**
     * @return parts associated with the product
     */
    public ObservableList<Part> getAddedParts() {
        return partsForProduct;
    }

    @FXML
    void OnActionRemoveAssociatedPart(ActionEvent event) {

        Part selectedPart = addProdRemovingTableV.getSelectionModel().getSelectedItem();

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a product");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This part will be removed! Do you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                //Inventory.deletePart(selectedPart);
                partsForProduct.remove(selectedPart);
            }
        }

    }

    @FXML
    void onActionAddPart(ActionEvent event) {

        Part partToAdd = addProdAddingTableV.getSelectionModel().getSelectedItem();

        if (partToAdd == null)
            return;

        partsForProduct.add(partToAdd);

        System.out.println("Add button clicked");
    }

    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Input data will not be saved! Do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK){
            addProdRemovingTableV.getItems().clear();
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    void onActionSaveAddProduct(ActionEvent event) throws IOException {
        try {
            String name = addProdNameText.getText();
            String stockS = addProdInvText.getText();
            String priceS = addProdPriceText.getText();
            String maxS = addProdMaxText.getText();
            String minS = addProdMinText.getText();

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

            // int id = Integer.parseInt(addProdIdText.getText());
            int stock = Integer.parseInt(stockS);
            double price = Double.parseDouble(priceS);
            int max = Integer.parseInt(maxS);
            int min = Integer.parseInt(minS);

            if (min > stock || max < stock) {
                System.out.println("Inv must be between Max and Min");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Inv must be between Max and Min");
                alert.showAndWait();
                return;
            }

            if (!priceS.contains(".")) {
                System.out.println("Price must be a double");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Price must be a double");
                alert.showAndWait();
                return;
            }

            int id = Inventory.generateUniqueProductId();  // doesn't increase ID if placed after validation checks

            Product saveProduct = new Product(id, name, price, stock, min, max);
            Inventory.addProduct(saveProduct);
            for(Part addPart : partsForProduct) {
                saveProduct.addAssociatedPart(addPart);
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
    void partSearch(ActionEvent event) {
        String search = addProdSearch.getText();

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
                        addProdSearch.setText("");
                        return;
                    }
                }
            }
            catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "This part does not exist");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    addProdSearch.setText("");
                    return;
                }
            }

        }

        addProdAddingTableV.setItems(parts);
        addProdSearch.setText("");
    }

    /**
     * initializes the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProdIdText.setDisable(true);

        addProdAddingTableV.setItems(Inventory.getAllParts());

        addProdAddPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdAddPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdAddInvLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdAddPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        addProdRemovingTableV.setItems(getAddedParts());

        addProdRemPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProdRemPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProdRemInvLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProdRemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
