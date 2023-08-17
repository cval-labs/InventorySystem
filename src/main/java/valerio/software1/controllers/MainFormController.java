package valerio.software1.controllers;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}