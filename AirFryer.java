
public class AirFryer extends Product{
	
		private String color;
	    private double weight;
	    private double capacity;

	    //constructor
	    public AirFryer(int itemNum, String name, int quantityAvailable, double price, String color, double weight, double capacity) {
	        super(itemNum, name, quantityAvailable, price);
	        this.color = color;
	        this.weight = weight;
	        this.capacity = capacity;
	    }

	   
	    public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public double getWeight() {
			return weight;
		}

		
		public void setWeight(double weight) {
			this.weight = weight;
		}

		public double getCapacity() {
			return capacity;
		}

		public void setCapacity(double capacity) {
			this.capacity = capacity;
		}

		//Calculate total inventory of AirFryer
	    public double valueStock() {
	        return super.totalInventoryValue();
	    }

	    @Override
	    public String toString() {
	        return "Item number\t\t\t: " + getItemNum() + "\n" +
	                "Product name\t\t\t: " + getName() + "\n" +
	                "Color\t\t\t\t: " + color + "\n" +
	                "Weight(kg)\t\t\t: " + String.format("%.2f", weight) + "\n"+
	                "Capacity(Litres)\t\t: " + String.format("%.2f", capacity) + "\n" +
	                "Quantity available\t\t: " + getQuantityAvailable() + "\n" +
	                "Price(RM)\t\t\t\t: " + String.format("%.2f", getPrice()) + "\n" +
	                "Inventory value(RM)\t: " + String.format("%.2f", valueStock()) + "\n" +
	                "Product status\t\t\t: " + (isStatus() ? "Active" : "Discontinued") + "\n";
	    }

}
