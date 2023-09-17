package valerio.software1.model;

/**
 * A subclass of Part.
 */
public class Outsourced extends Part {
    private String companyName;

    /**
     * The constructor for the outsourced part.
     * @param id the outsourced part's id
     * @param name the outsourced part's name
     * @param price the outsourced part's price
     * @param stock the outsourced part's stock
     * @param min the outsourced part's minimum stock
     * @param max the outsourced part's max stock
     * @param companyName the outsourced part's company name
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * The setter for the outsourced part
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * The getter for the outsourced part
     * @param companyName the company name to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
