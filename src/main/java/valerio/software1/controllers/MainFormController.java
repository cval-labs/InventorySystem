package valerio.software1.controllers;

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
import java.util.Optional;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> mainPartIdCol;

    @FXML
    private TableColumn<Part, Integer> mainPartInvLevelCol;

    @FXML
    private TableColumn<Part, String> mainPartNameCol;

    @FXML
    private TableColumn<Part, Double> mainPartPriceCol;

    @FXML
    private TextField mainPartSearch;

    @FXML
    private TableView<Part> mainPartTV;

    @FXML
    private TableColumn<Product, Integer> mainProdIdCol;

    @FXML
    private TableColumn<Product, Integer> mainProdInvLevelCol;

    @FXML
    private TableColumn<Product, String> mainProdNameCol;

    @FXML
    private TableColumn<Product, Double> mainProdPriceCol;

    @FXML
    private TextField mainProductSearch;

    @FXML
    private TableView<Product> mainProductTV;

    @FXML
    void onActionExit(ActionEvent event) {
        System.exit(0);
    }

    // PARTS METHODS
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/add-part.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        Part selectedPart = mainPartTV.getSelectionModel().getSelectedItem();

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a part");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will be deleted! Do you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get() == ButtonType.OK) {
                Inventory.deletePart(selectedPart);
            }
        }

    }

    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        Part selectedPart = mainPartTV.getSelectionModel().getSelectedItem();

        if(selectedPart == null) {
            // System.out.println("Null - select a part");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a part");
            alert.showAndWait();
        } else {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/valerio/software1/modify-part.fxml"));
            loader.load();

            ModifyPartController modifyPartController = loader.getController();
            modifyPartController.movePart(selectedPart);

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show(); // .showAndWait() causes error "Cannot call this method on primary stage"
        }
    }

    // PRODUCT METHODS
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/add-product.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        // retrieves selected product
        Product selectedProduct = mainProductTV.getSelectionModel().getSelectedItem();

        /*if (selectedProduct != null) {
            Inventory.deleteProduct(selectedProduct);
        } else {
            System.out.println("Product not selected");
        }*/

        /*if (selectedProduct != null) {
            // boolean variable holds true or false value from deleteProduct
            // above if-else doesn't make use of false value
            boolean deleted = Inventory.deleteProduct(selectedProduct);

            if(deleted){
                System.out.println("Deleted!");
            } else {
                System.out.println("Not deleted!");
            }
        } else {
            System.out.println("Product not selected");
        }*/

        if (selectedProduct == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a product");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will be deleted! Do you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get() == ButtonType.OK) {
                boolean deleted = Inventory.deleteProduct(selectedProduct);
                if(deleted){
                    System.out.println("Successfully Deleted!");
                }
            }
        }

    }

    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        Product selectedProduct = mainProductTV.getSelectionModel().getSelectedItem();

        if(selectedProduct == null){
            // System.out.println("Null - select a product");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a product");
            alert.showAndWait();

        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/valerio/software1/modify-product.fxml"));
            loader.load();

            ModifyProductController modifyProductController = loader.getController();
            modifyProductController.moveProduct(selectedProduct);

            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void partsSearch(ActionEvent event) {
        String search = mainPartSearch.getText();

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

        mainPartTV.setItems(parts);
        mainPartSearch.setText("");
    }

    @FXML
    void productSearch(ActionEvent event) {
        String prodSearch = mainProductSearch.getText();

        ObservableList<Product> products = Inventory.lookupProduct(prodSearch);

        if (products.size() == 0){
            try {
                int productId = Integer.parseInt(prodSearch);
                Product prodToSearch = Inventory.lookupProduct(productId);

                if (prodToSearch != null) {
                    products.add(prodToSearch);
                }
            }
            catch(NumberFormatException e) {
                // ignore
            }
        }

        mainProductTV.setItems(products);
        mainProductSearch.setText("");

    }

    /**
     * initializes the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // Inventory.setupData();

        mainPartTV.setItems(Inventory.getAllParts());

        mainPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mainPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mainPartInvLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mainPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        mainProductTV.setItems(Inventory.getAllProducts());

        mainProdIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mainProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mainProdInvLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mainProdPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}