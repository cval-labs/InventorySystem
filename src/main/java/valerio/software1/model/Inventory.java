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
     * @param partId the part id to look up
     * @return
     */
    public static Part lookupPart(int partId) {
        // TODO: fix Part lookupPart
        return null;
    }

    /**
     * @param productId the product id to look up
     * @return
     */
    public static Product lookupProduct(int productId) {
        // TODO: fix Product lookupProduct
        return null;
    }

    /**
     * @param partName the part name to look up
     * @return
     */
    public static ObservableList<Part> lookupPart(String partName) {
        // TODO: lookupPart - text must match name exactly
        ObservableList<Part> namedPart = FXCollections.observableArrayList();

        for(Part part : allParts) {
            if(part.getName().contains(partName)){
                namedPart.add(part);
            }
        }

        return namedPart;
    }

    /**
     * @param productName the product name to look up
     * @return
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        // TODO: lookupProduct - text must match name exactly
        ObservableList<Product> namedProduct = FXCollections.observableArrayList();

        for(Product product : allProducts) {
            if(product.getName().contains(productName)){
                namedProduct.add(product);
            }
        }
        return namedProduct;
    }

    /**
     * @param index
     * @param selectedPart
     */
    public static void updatePart(int index, Part selectedPart) {
        //TODO: updatePart
    }

    /**
     * @param index
     * @param selectedProduct
     */
    public static void updateProduct(int index, Product selectedProduct) {
        //TODO: updateProduct
    }

    /**
     * @param selectedPart the part to be deleted
     * @return true if deleted, else false
     */
    public static boolean deletePart(Part selectedPart) {
        // TODO: deletePart
        return false;
    }

    /**
     * @param selectedProduct the product to be deleted
     * @return true if deleted, else false
     */
    public static boolean deleteProduct(Product selectedProduct) {
        // TODO: deleteProduct
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
