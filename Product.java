public abstract class Product {
    private int itemNum;
    private String name;
    private int quantityAvailable;
    private double price;
    private boolean status;

    //constructor
    public Product() {
        status = true;
    }

    public Product(int itemNum, String name, int quantityAvailable, double price) {
        this.itemNum = itemNum;
        this.name = name;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.status = true; //Product is active by default
    }

    //accessor
    public int getItemNum() {
        return itemNum;
    }
    
    public String getName() {
        return name;
    }
    
    public int getQuantityAvailable() {
        return quantityAvailable;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public boolean isActive() {
        return status;
    }

    
    //mutator
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    //Calculate total inventory of the Product
    public double totalInventoryValue() {
        return price * quantityAvailable;
    }

    //Add stock to the Product
    public void addStock(int amount) {
        if (this.status) {
            quantityAvailable += amount;
        }
    }
    
    //Deduct stock
    public void deductStock(int amount) {
        quantityAvailable -= amount;
    }

    public String toString() {
        return "Item number\t: " + itemNum + "\n" +
                "Product name\t: " + name + "\n" +
                "Quantity available\t: " + quantityAvailable + "\n" +
                "Price (RM)\t: " + price + "\n" +
                "Inventory value (RM)\t\t: " + totalInventoryValue() + "\n" +
                "Product status\t: " + (status ? "Active" : "Discontinued")+ "\n";
    }
    
}
