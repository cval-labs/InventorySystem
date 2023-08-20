package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML
    private TableColumn<?, ?> addProdAddInvLevel;

    @FXML
    private TableColumn<?, ?> addProdAddPartId;

    @FXML
    private TableColumn<?, ?> addProdAddPartName;

    @FXML
    private TableColumn<?, ?> addProdAddPrice;

    @FXML
    private TableView<?> addProdAddingTableV;

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
    private TableColumn<?, ?> addProdRemInvLevel;

    @FXML
    private TableColumn<?, ?> addProdRemPartName;

    @FXML
    private TableColumn<?, ?> addProdRemPrice;

    @FXML
    private TableView<?> addProdRemovingTableV;

    @FXML
    private TextField addProdSearch;

    Stage stage;
    Parent scene;

    @FXML
    void OnActionRemoveAssociatedPart(ActionEvent event) {

    }

    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSaveAddProduct(ActionEvent event) {

    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
