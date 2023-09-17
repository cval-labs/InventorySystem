package valerio.software1.model;
/**
 * Supplied class Part.java
 */

/**
 * An abstract class and the superclass of InHouse and Outsourced.
 */
public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * The constructor for the part.
     * @param id the part's id
     * @param name the part's name
     * @param price the part's price
     * @param stock the part's stock
     * @param min the part's min
     * @param max the part's max
     */
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * The getter for the part's id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * The setter for the part's id.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter for the part's name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for the part's name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter for the part's price.
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * The setter for the part's price.
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * The getter for the part's stock.
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * The setter for the part's stock.
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * The getter for the part's min
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * The setter for the part's min
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * The getter for the part's max
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * The setter for the part's max
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }
    
}