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
import valerio.software1.model.Inventory;
import valerio.software1.model.Part;
import valerio.software1.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
        // TODO: remove associated part needs prompt
        Part selectedPart = addProdRemovingTableV.getSelectionModel().getSelectedItem();

        if(selectedPart != null) {
            boolean deletedPart = Inventory.deletePart(selectedPart);

            if(deletedPart){
                System.out.println("Deleted!");
            } else {
                System.out.println("Not deleted!");
            }
        } else {
            System.out.println("Part not selected");
        }
    }

    @FXML
    void onActionAddPart(ActionEvent event) {
        // TODO: onActionAddPart - moves part from top tv to bottom tv
        /*int id = Integer.parseInt(addProdIdText.getText());
        String name = addProdNameText.getText();
        int stock = Integer.parseInt(addProdInvText.getText());
        double price = Double.parseDouble(addProdPriceText.getText());
        int max = Integer.parseInt(addProdMaxText.getText());
        int min = Integer.parseInt(addProdMinText.getText());*/
    }

    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(getClass().getResource("/valerio/software1/main-form.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSaveAddProduct(ActionEvent event) throws IOException {
        int id = Integer.parseInt(addProdIdText.getText());
        String name = addProdNameText.getText();
        int stock = Integer.parseInt(addProdInvText.getText());
        double price = Double.parseDouble(addProdPriceText.getText());
        int max = Integer.parseInt(addProdMaxText.getText());
        int min = Integer.parseInt(addProdMinText.getText());

        Inventory.addProduct(new Product(id, name, price, stock, min, max));

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/valerio/software1/main-form.fxml")));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // addProdAddingTableV.setItems(Inventory.getAllParts());
        //addProdRemovingTableV.setItems(Inventory.getAllParts());
    }
}
