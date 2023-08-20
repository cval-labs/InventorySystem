package valerio.software1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {
    @FXML
    private TableColumn<?, ?> modProdAddInvLevel;

    @FXML
    private TableColumn<?, ?> modProdAddPartId;

    @FXML
    private TableColumn<?, ?> modProdAddPartName;

    @FXML
    private TableColumn<?, ?> modProdAddPrice;

    @FXML
    private TableView<?> modProdAddingTV;

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
    private TableColumn<?, ?> modProdRemPartId;

    @FXML
    private TableColumn<?, ?> modProdRemPartName;

    @FXML
    private TableColumn<?, ?> modProdRemPrice;

    @FXML
    private TableView<?> modProdRemovingTV;

    @FXML
    private TableColumn<?, ?> modProdRenInvLevel;

    @FXML
    private TextField modProdSearch;

    Stage stage;
    Parent scene;

    @FXML
    void onActionAddModProduct(ActionEvent event) {

    }

    @FXML
    void onActionCancelModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionRemovePartModProduct(ActionEvent event) {

    }

    @FXML
    void onActionSaveModifyProduct(ActionEvent event) {

    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
