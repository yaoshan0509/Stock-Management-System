
public class TV extends Product {
    private String screenType;
    private String resolution;
    private int displaySize;

    //constructor
    public TV(int itemNum, String name, int quantityAvailable, double price, String screenType, String resolution, int displaySize) {
        super(itemNum, name, quantityAvailable, price);
        this.screenType = screenType;
        this.resolution = resolution;
        this.displaySize = displaySize;
    }

    //accessor
    public String getScreenType() {
        return screenType;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    public int getDisplaySize() {
        return displaySize;
    }

    //mutator
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    
    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

  //Calculate total inventory of TV
    public double valueStock() {
        return super.totalInventoryValue();
    }

    @Override
    public String toString() {
        return "Item number\t\t\t: " + getItemNum() + "\n" +
                "Product name\t\t\t: " + getName() + "\n" +
                "Screen type\t\t\t: " + screenType + "\n" +
                "Resolution\t\t\t: " + resolution + "\n" +
                "Display size\t\t\t: " + displaySize + "\n" +
                "Quantity available\t\t: " + getQuantityAvailable() + "\n" +
                "Price (RM)\t\t\t: " + getPrice() + "\n" +
                "Inventory value (RM)\t: " + valueStock() + "\n" +
                "Product status\t\t\t: " + (isStatus() ? "Active" : "Discontinued") + "\n";
    }
}
