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
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> addProdAddInvLevel;

    @FXML
    private TableColumn<Part, Integer> addProdAddPartId;

    @FXML
    private TableColumn<Part, String> addProdAddPartName;

    @FXML
    private TableColumn<Part, Double> addProdAddPrice;

    // top table
    @FXML
    private TableView<Part> addProdAddingTableV;

    @FXML
    private TextField addProdIdText;

    @FXML
    private TextField addProdInvText;

    @FXML
    private TextField addProdMaxText;

    @FXML
    private TextField addProdMinText;

    @FXML
    private TextField addProdNameText;

    @FXML
    private TextField addProdPriceText;

    @FXML
    private TableColumn<Part, Integer> addProdRemPartId;

    @FXML
    private TableColumn<Part, Integer> addProdRemInvLevel;

    @FXML
    private TableColumn<Part, String> addProdRemPartName;

    @FXML
    private TableColumn<Part, Double> addProdRemPrice;

    // bottom table
    @FXML
    private TableView<Part> addProdRemovingTableV;

    @FXML
    private TextField addProdSearch;

    private static ObservableList<Part> partsForProduct = FXCollections.observableArrayList();

    public static ObservableList<Part> getAddedParts() {
        return partsForProduct;
    }

    @FXML
    void OnActionRemoveAssociatedPart(ActionEvent event) {

        Part selectedPart = addProdRemovingTableV.getSelectionModel().getSelectedItem();

        /*if(selectedPart != null) {
            boolean deletedPart = Inventory.deletePart(selectedPart);

            if(deletedPart){
                System.out.println("Deleted!");
            } else {
                System.out.println("Not deleted!");
            }
        } else {
            System.out.println("Part not selected");
        }*/

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a product");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This part will be removed! Do you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                Inventory.deletePart(selectedPart);
            }
        }

    }

    @FXML
    void onActionAddPart(ActionEvent event) {
        // TODO: FIX - added parts disappear
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
            int id = Integer.parseInt(addProdIdText.getText());
            String name = addProdNameText.getText();
            int stock = Integer.parseInt(addProdInvText.getText());
            double price = Double.parseDouble(addProdPriceText.getText());
            int max = Integer.parseInt(addProdMaxText.getText());
            int min = Integer.parseInt(addProdMinText.getText());

            Inventory.addProduct(new Product(id, name, price, stock, min, max));

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
                }
            }
            catch (NumberFormatException e) {
                // ignore
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
