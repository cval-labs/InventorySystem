package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    @FXML
    void onActionExit(ActionEvent event) {
        System.out.println("Exit button clicked");
    }

    // Parts Methods
    @FXML
    void onActionAddPart(ActionEvent event) {
        System.out.println("Add Part button clicked");
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        System.out.println("Delete Part button clicked");
    }

    @FXML
    void onActionModifyPart(ActionEvent event) {
        System.out.println("Modify Part button clicked");
    }

    // Product Methods
    @FXML
    void onActionAddProduct(ActionEvent event) {
        System.out.println("Add Product button clicked");
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        System.out.println("Delete Product button clicked");
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) {
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