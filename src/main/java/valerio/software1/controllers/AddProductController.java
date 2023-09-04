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
import valerio.software1.model.Part;

import java.io.IOException;
import java.net.URL;
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
    private TableColumn<Part, Integer> addProdRemInvLevel;

    @FXML
    private TableColumn<Part, String> addProdRemPartName;

    @FXML
    private TableColumn<Part, Double> addProdRemPrice;

    @FXML
    private TableView<Part> addProdRemovingTableV;

    @FXML
    private TextField addProdSearch;

    @FXML
    void OnActionRemoveAssociatedPart(ActionEvent event) {
        // TODO: OnActionRemoveAssociatedPart
    }

    @FXML
    void onActionAddPart(ActionEvent event) {
        // TODO: onActionAddPart
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
        // TODO: onActionSaveAddPart
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
