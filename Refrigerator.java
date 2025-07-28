
public class Refrigerator extends Product {
    
	private String doorDesign;
    private String color;
    private int capacity;

    //constructor
    public Refrigerator(int itemNum, String name, int quantityAvailable, double price, String doorDesign, String color, int capacity) {
        super(itemNum, name, quantityAvailable, price);
        this.doorDesign = doorDesign;
        this.color = color;
        this.capacity = capacity;
    }

    //accessor
    public String getDoorDesign() {
        return doorDesign;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getCapacity() {
        return capacity;
    }

    //mutator
    public void setDoorDesign(String doorDesign) {
        this.doorDesign = doorDesign;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //Calculate total inventory of Refrigerator
    public double valueStock() {
        return super.totalInventoryValue();
    }

    @Override
    public String toString() {
        return "Item number\t\t\t: " + getItemNum() + "\n" +
                "Product name\t\t\t: " + getName() + "\n" +
                "Door design\t\t\t: " + doorDesign + "\n" +
                "Color\t\t\t\t: " + color + "\n" +
                "Capacity (in Litres)\t\t: " + capacity + "\n" +
                "Quantity available\t\t: " + getQuantityAvailable() + "\n" +
                "Price (RM)\t\t\t: " + getPrice() + "\n" +
                "Inventory value (RM)\t: " + valueStock() + "\n" +
                "Product status\t\t\t: " + (isStatus() ? "Active" : "Discontinued") + "\n";
    }

}
