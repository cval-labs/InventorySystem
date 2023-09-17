package valerio.software1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Represents a product that may or may not contain associated parts.
 */
public class Product {
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * The constructor for the product.
     * @param id the product's id
     * @param name the product's name
     * @param price the product's price
     * @param stock the product's stock
     * @param min the product's min
     * @param max the product's max
     */
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * The getter for the product's id.
     * @return the product's id
     */
    public int getId() {
        return id;
    }

    /**
     * The setter for the product's id.
     * @param id the product id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter for the product's name.
     * @return the product's name
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for the product's name.
     * @param name the product name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter for the product's price.
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * The setter for the product's price.
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * The getter for the product's stock.
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * The setter for the product's stock.
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * The getter for the product's min.
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * The setter for the product's min.
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * The getter for the product's max.
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * The setter for the product's max.
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Adds a part to a product.
     * @param part the part to add
     */
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    /**
     * Deletes a part associated with a product.
     * @param selectedAssociatedPart the part to be deleted
     * @return true if part is deleted, else false
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        for(Part part : associatedParts) {
            if(part.getId() == selectedAssociatedPart.getId()){
                return getAllAssociatedParts().remove(selectedAssociatedPart);

            }
        }

        return false;
    }

    /**
     * Returns all parts associated with a product.
     * @return associated parts
     */
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

}
