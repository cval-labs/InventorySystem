package valerio.software1.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
