/**
 * Represents an item that can be stored and purchased in a vending machine.
 */
public class Item {

    protected int calories;
    protected double price;
    protected String name;


    /**
     * Constructor for the Item class.
     *
     * @param calories The number of calories in the item.
     * @param price    The price of the item.
     * @param name     The name of the item.
     */

    public Item(int calories, double price, String name ){
        this.calories =calories;
        this.price =price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

}