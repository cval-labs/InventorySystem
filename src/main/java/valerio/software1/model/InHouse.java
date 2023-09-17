package valerio.software1.model;

/**
 * A subclass of Part.
 */
public class InHouse extends Part {
    private int machineId;

    /**
     * The constructor for the in-house part.
     * @param id the in-house part's id
     * @param name the in-house part's name
     * @param price the in-house part's price
     * @param stock the in-house part's stock
     * @param min the in-house part's minimum stock
     * @param max the in-house part's max stock
     * @param machineId the in-house part's machine id
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * The setter for the in-house part.
     * @param machineId the machine ID to set
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * The getter for the in-house part.
     * @return the machine ID
     */
    public int getMachineId() {
        return machineId;
    }
}
