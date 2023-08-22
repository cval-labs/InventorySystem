package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import valerio.software1.model.Part;
import valerio.software1.model.Product;

import java.io.IOException;
import java.net.URL;
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

    // Parts Methods
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/add-part.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        // TODO: onActionDeletePart
        System.out.println("Delete Part button clicked");
    }

    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/modify-part.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    // Product Methods
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/add-product.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        // TODO: onActionDeleteProduct
        System.out.println("Delete Product button clicked");
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/modify-product.fxml"));
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