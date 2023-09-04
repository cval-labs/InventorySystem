package valerio.software1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    static {
        setupData();
    }

    /**
     * Sets hardcoded data
     */
    public static void setupData(){
        Part part1 = new InHouse(1, "Wheel", 4.99, 30, 1, 35, 1);
        Part part2 = new Outsourced(2, "Handle", 3.99, 40, 10, 40, "ABC Company");
        Part part3 = new InHouse(3, "Seat", 5.99, 25, 5, 50, 2);
        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);

        Product product1 = new Product(1, "Premium Motor-Bike", 2999.99, 23, 1, 30);
        Product product2 = new Product(2, "PlayWheels Skateboard", 59.99, 19, 1, 30);
        Product product3 = new Product(3, "BuySmart Bike", 199.99, 20, 1, 30);
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);
    }

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
     * @return part, else null
     */
    public static Part lookupPart(int partId) {
        for(Part part : allParts){
            if(part.getId() == partId) {
                return part;
            }
        }

        // returns null if no matching IDs are found
        return null;
    }

    /**
     * @param productId the product id to look up
     * @return product, else null
     */
    public static Product lookupProduct(int productId) {
        for(Product product : allProducts) {
            if(product.getId() == productId){
                return product;
            }
        }

        // returns null if no matching IDs are found
        return null;
    }

    /**
     * @param partName the part name to look up
     * @return looked up part
     */
    public static ObservableList<Part> lookupPart(String partName) {
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
     * @return looked up product
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> namedProduct = FXCollections.observableArrayList();

        for(Product product : allProducts) {
            if(product.getName().contains(productName)){
                namedProduct.add(product);
            }
        }
        return namedProduct;
    }

    /**
     * TODO:
     * @param index
     * @param selectedPart
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    /**
     * TODO:
     * @param index
     * @param selectedProduct
     */
    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }

    /**
     * @param selectedPart the part to be deleted
     * @return true if deleted, else false
     */
    public static boolean deletePart(Part selectedPart) {

        for(Part part : allParts){
            if(part.getId() == selectedPart.getId()){
                return getAllParts().remove(selectedPart);
            }
        }
        return false;
    }

    /**
     * @param selectedProduct the product to be deleted
     * @return true if deleted, else false
     */
    public static boolean deleteProduct(Product selectedProduct) {

        for(Product product : allProducts) {
            if(product.getId() == selectedProduct.getId()){
                return getAllProducts().remove(selectedProduct);

            }
        }

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
