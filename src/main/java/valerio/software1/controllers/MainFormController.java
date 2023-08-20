package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private TableColumn<?, ?> mainPartIdCol;

    @FXML
    private TableColumn<?, ?> mainPartInvLevelCol;

    @FXML
    private TableColumn<?, ?> mainPartNameCol;

    @FXML
    private TableColumn<?, ?> mainPartPriceCol;

    @FXML
    private TextField mainPartSearch;

    @FXML
    private TableView<?> mainPartTV;

    @FXML
    private TableColumn<?, ?> mainProdIdCol;

    @FXML
    private TableColumn<?, ?> mainProdInvLevelCol;

    @FXML
    private TableColumn<?, ?> mainProdNameCol;

    @FXML
    private TableColumn<?, ?> mainProdPriceCol;

    @FXML
    private TextField mainProductSearch;

    @FXML
    private TableView<?> mainProductTV;

    Stage stage;
    Parent scene;


    @FXML
    void onActionExit(ActionEvent event) {
        // TODO: add here
        System.out.println("Exit button clicked");
    }

    // Parts Methods
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/add-part.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

        System.out.println("Add Part button clicked");
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        // TODO: add here
        System.out.println("Delete Part button clicked");
    }

    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/modify-part.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        System.out.println("Modify Part button clicked");
    }

    // Product Methods
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/add-product.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        System.out.println("Add Product button clicked");
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        // TODO: add here
        System.out.println("Delete Product button clicked");
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/modify-product.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        System.out.println("Modify Product button clicked");
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}