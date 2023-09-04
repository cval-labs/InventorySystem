package valerio.software1.controllers;

import javafx.collections.ObservableList;
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
import valerio.software1.model.Inventory;
import valerio.software1.model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> modProdAddInvLevel;

    @FXML
    private TableColumn<Part, Integer> modProdAddPartId;

    @FXML
    private TableColumn<Part, String> modProdAddPartName;

    @FXML
    private TableColumn<Part, Double> modProdAddPrice;

    // top table
    @FXML
    private TableView<Part> modProdAddingTV;

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
    private TableColumn<Part, Integer> modProdRemPartId;

    @FXML
    private TableColumn<Part, String> modProdRemPartName;

    @FXML
    private TableColumn<Part, Double> modProdRemPrice;

    // bottom table
    @FXML
    private TableView<Part> modProdRemovingTV;

    @FXML
    private TableColumn<Part, Integer> modProdRenInvLevel;

    @FXML
    private TextField modProdSearch;

    @FXML
    void onActionAddModProduct(ActionEvent event) {
        // TODO: onActionAddModProduct - moves part from top tv to bottom tv
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
        // TODO: remove associated part needs prompt
        Part selectedPart = modProdRemovingTV.getSelectionModel().getSelectedItem();

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
    void onActionSaveModifyProduct(ActionEvent event) {
        // TODO: onActionSaveModifyProduct
    }

    @FXML
    void partSearch(ActionEvent event) {
        String search = modProdSearch.getText();

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

        modProdAddingTV.setItems(parts);
        modProdSearch.setText("");

    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
