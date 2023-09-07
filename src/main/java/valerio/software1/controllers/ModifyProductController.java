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

    Product parts;

    ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    /*ObservableList<Part> partsForProduct = FXCollections.observableArrayList();

    ObservableList<Part> getAddedParts() {
        return partsForProduct;
    }*/

/*    public void addsAssociatedPart(Part part) {
        partsForProduct.add(part);
    }*/

/*    public static void deleteAssociatedPart(Part associatedPart) {

        for(Part part : partsForProduct){
            if(part.getId() == associatedPart.getId()){
                getAddedParts().remove(associatedPart);
                return;
            }
        }
    }*/

    @FXML
    void onActionAddModProduct(ActionEvent event) {
        // Move parts from top table to bottom table

    try {
        System.out.println("add button clicked");
        Part partToAdd = (Part) modProdAddingTV.getSelectionModel().getSelectedItem();

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
               // partsForProduct.remove(associatedPart);
                associatedParts.remove(associatedPart);
            }
        }

    }

    @FXML
    void onActionSaveModifyProduct(ActionEvent event) throws IOException {

        int id = Integer.parseInt(modProdIdText.getText());
        String name = modProdNameText.getText();
        int stock = Integer.parseInt(modProdInvText.getText());
        double price = Double.parseDouble(modProdPriceText.getText());
        int max = Integer.parseInt(modProdMaxText.getText());
        int min = Integer.parseInt(modProdMinText.getText());


        //Inventory.updatesProduct(id, new Product(id, name, price, stock, min, max));
        Product modifiedProduct = new Product(id, name, price, stock, min, max);
        for(Part addPart : associatedParts) {
            modifiedProduct.addAssociatedPart(addPart);
        }

        int index = 0;
        for(Product modProduct : Inventory.getAllProducts()) {
            if (modProduct.getId() == id) {
                    Inventory.updateProduct(index, modifiedProduct);
                    break;
            }
            index++;
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
        stage.setScene(new Scene(scene));
        stage.show();
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

    public void moveProduct(Product product) {
        try {
            modProdIdText.setText(String.valueOf(product.getId()));
            modProdNameText.setText(product.getName());
            modProdInvText.setText(String.valueOf(product.getStock()));
            modProdPriceText.setText(String.valueOf(product.getPrice()));
            modProdMaxText.setText(String.valueOf(product.getMax()));
            modProdMinText.setText(String.valueOf(product.getMin()));
            // partsForProduct.addAll(getAddedParts());
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
                }
            }
            catch (NumberFormatException e) {
                // ignore
            }

        }

        modProdAddingTV.setItems(parts);
        modProdSearch.setText("");

    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
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
        } catch (NullPointerException e) {
            // ignore
        }
    }
}
