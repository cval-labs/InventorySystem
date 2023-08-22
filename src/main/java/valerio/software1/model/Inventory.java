package valerio.software1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * @param newPart the new part to add
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * @param newProduct the new product to add
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * @param partId
     * @return
     */
    public static Part lookupPart(int partId) {
        return null;
    }

    /**
     * @param productId
     * @return
     */
    public static Product lookupProduct(int productId) {
        return null;
    }

    /**
     * @param partName
     * @return
     */
    public static ObservableList<Part> lookupPart(String partName) {
        return null;
    }

    /**
     * @param productName
     * @return
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        return null;
    }

    /**
     * @param index
     * @param selectedPart
     */
    public static void updatePart(int index, Part selectedPart) {
        //TODO:
    }

    /**
     * @param index
     * @param selectedProduct
     */
    public static void updateProduct(int index, Product selectedProduct) {
        //TODO:
    }

    /**
     * @param selectedPart the part to be deleted
     * @return true if deleted, else false
     */
    public static boolean deletePart(Part selectedPart) {
        return false;
    }

    /**
     * @param selectedProduct the product to be deleted
     * @return true if deleted, else false
     */
    public static boolean deleteProduct(Product selectedProduct) {
        return false;
    }

    /**
     * @return all parts
     */
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }

    /**
     * @return all products
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
