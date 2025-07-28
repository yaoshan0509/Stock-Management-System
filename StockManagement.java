import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//controls the flow of SMS, displays messages, gets inputs from users
public class StockManagement {
	
	//prompt user for how many products they wish to add
    public static int maxProducts(Scanner input) {
        int maxProducts = 0;
        do {
            System.out.print("\nEnter the maximum number of products: ");
            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid positive integer");
                input.next();
                continue;
            }
            maxProducts = input.nextInt();
            if (maxProducts <= 0) {
                System.out.println("Please enter a positive integer greater than 0");
            }
        } while (maxProducts <= 0);
        return maxProducts;
    }

    //display contents of the product array
    public static void viewProducts(ArrayList<Product> arr) {
        System.out.println("\n_____List of Products_____\n");
        for (int i = 0 ; i < arr.size(); i++) {
            Class<?> strClass = arr.get(i).getClass();
            System.out.println("Product " + (i + 1) + ": ");
            System.out.println("Type\t\t\t\t: " + strClass.getSimpleName());
            System.out.print(arr.get(i).toString());
            System.out.println();
        }
    }

    //display system menu
    public static int displayMenu(Scanner input) {
    	
    	int choice = 0;
    	
        System.out.println("\n\n_____MENU_____");
        System.out.println("1. View products");
        System.out.println("2. Add stock");
        System.out.println("3. Deduct stock");
        System.out.println("4. Discontinue product");
        System.out.println("0. Exit");

        do {
            System.out.print("Please enter a menu option: ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please try again.");
                input.next();
                continue;
            }
            choice = input.nextInt();
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid input! Please try again.");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    //add stock values
    public static void addStock(ArrayList<Product> arr, Scanner input) {
        System.out.println("\n_____ADD STOCK_____");
        int num = -1;
        int choice = updateProduct(arr, input);

        if (choice != 0 && arr.get(choice - 1).isStatus()) {
            do {
                System.out.print("How many products to add: ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input! Please try again.");
                    input.next();
                    continue;
                }
                num = input.nextInt();
                if (num < 0) {
                    System.out.println("Invalid input! Please try again.");
                }
            } while (num < 0);
            arr.get(choice - 1).addStock(num);
            System.out.println(num + " added successfully!");
        }
        else {
            System.out.println("Product Discontinued.");
        }
    }

    //deduct stock values
    public static void deductStock(ArrayList<Product> arr, Scanner input) {
        System.out.println("\n_____DEDUCT STOCK_____");
        int num = 0;
        int choice = updateProduct(arr, input);

        if (choice != 0 && arr.get(choice - 1).isStatus()) {
            do {
                System.out.print("How many products to deduct: ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input! Please try again.");
                    input.next();
                    continue;
                }
                num = input.nextInt();
                if (num < 0 || num > arr.get(choice).getQuantityAvailable()) {
                    System.out.println("Invalid input! Please try again.");
                }
            } while (num < 0 || num > arr.get(choice).getQuantityAvailable());
            arr.get(choice - 1).deductStock(num);
            System.out.println(num + " deducted successfully!");
        }
        else {
            System.out.println("Product Discontinued");
        }
    }

    //set status of products
    public static void discontinued(ArrayList<Product> arr, Scanner input) {
        System.out.println("\n_____SET STATUS_____");
        int choice = updateProduct(arr, input);
        int num = 0;

        if (choice != 0) {
            do {
                System.out.print("Active(1) or Discontinued(0): ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input! Please try again.");
                    input.next();
                    continue;
                }
                num = input.nextInt();
                if (num < 0 || num > 1) {
                    System.out.println("Invalid input! Please try again.");
                }
                else if (num == 0) {
                    arr.get(choice - 1).setStatus(false);
                }
                else {
                    arr.get(choice - 1).setStatus(true);
                }
            } while (num < 0 || num > 1);
            System.out.println("Status updated");
        }

    }

    //select product
    public static int selectProduct(Scanner input) {
        int choice = 0;
        System.out.println("\n_____Type of Product_____");
        System.out.println("1. Refrigerator");
        System.out.println("2. TV");
        System.out.println("3. AirFryer");

        do {
            System.out.print("\nChoose a product: ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please try again.");
                input.next();
                continue;
            }
            choice = input.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("ONLY NUMBER 1,2,3 ARE ALLOWED");
            }
        } while (choice < 1 || choice > 3);
        input.nextLine();
        return choice;
    }

    //add product
    public static void addProduct(ArrayList<Product> arr, Scanner input) {
        int choice = selectProduct(input);
        if (choice == 1) {
            addRefrigerator(arr, input);
        }
        else if (choice ==2){
            addTV(arr, input);
        }
        else if (choice ==3){
            addAirFryer(arr, input);
        }
    }

    //add refrigerator
    public static void addRefrigerator(ArrayList<Product> arr, Scanner input) {
    	 while (true) {
         	System.out.println("\n_____REFRIGERATOR_____");
             
             try {
             	 System.out.print("Product name\t\t: ");
                 String name = input.nextLine();
                 System.out.print("Door design\t\t: ");
                 String doorDesign = input.nextLine();
                 System.out.print("Color\t\t\t: ");
                 String color = input.nextLine();
                 System.out.print("Capacity (in Litres)\t: ");
                 int capacity = input.nextInt();
                 System.out.print("Quantity available\t: ");
                 int quantityAvailable = input.nextInt();
                 System.out.print("Price (RM)\t\t: ");
                 double price = input.nextDouble();
                 System.out.print("Item number\t\t: ");
                 int itemNum = input.nextInt();

                 arr.add(new Refrigerator(itemNum, name, quantityAvailable, price, doorDesign, color, capacity));
                 input.nextLine();
                 System.out.println("Added successfully");
                 break;
             }
             catch (InputMismatchException e) {
                 System.err.println("Input mismatch: " + e.getMessage());
                 System.out.println("Invalid input! Please enter a valid input.");
                 input.nextLine();
             }
         }
     }

    //add tv
    public static void addTV(ArrayList<Product> arr, Scanner input) {
    	while (true) {
        	System.out.println("\n_____TV_____");
            
            try {
            	System.out.print("Product name\t\t: ");
                String name = input.nextLine();
                System.out.print("Screen type\t\t: ");
                String screenType = input.nextLine();
                System.out.print("Resolution\t\t: ");
                String resolution = input.nextLine();
                System.out.print("Display size\t\t: ");
                int displaySize = input.nextInt();
                System.out.print("Quantity available\t: ");
                int quantityAvailable = input.nextInt();
                System.out.print("Price (RM)\t\t: ");
                double price = input.nextDouble();
                System.out.print("Item number\t\t: ");
                int itemNum = input.nextInt();

                arr.add(new Refrigerator(itemNum, name, quantityAvailable, price, screenType, resolution, displaySize));
                input.nextLine();
                System.out.println("Added successfully");
                break;
            }
            catch (InputMismatchException e) {                
                System.err.println("Input mismatch: " + e.getMessage());
                System.out.println("Invalid input! Please enter a valid input.");
                input.nextLine();
            }
    	}
    }

    //add airfyer
    public static void addAirFryer(ArrayList<Product> arr, Scanner input) {
   	 while (true) {
      	System.out.println("\n_____AIRFRYER_____");
          
          try {
          	  System.out.print("Product name\t\t: ");
              String name = input.nextLine();
              System.out.print("Weight(kg)\t\t: ");
              int weight = input.nextInt();
              System.out.print("Color\t\t\t: ");
              String color = input.nextLine();
              System.out.print("Capacity (in Litres)\t: ");
              int capacity = input.nextInt();
              System.out.print("Quantity available\t: ");
              int quantityAvailable = input.nextInt();
              System.out.print("Price (RM)\t\t: ");
              double price = input.nextDouble();
              System.out.print("Item number\t\t: ");
              int itemNum = input.nextInt();

              arr.add(new AirFryer(itemNum, name, quantityAvailable, price, color, weight, capacity));
              input.nextLine();
              System.out.println("Added successfully");
              break;
          }
          catch (InputMismatchException e) {
              System.err.println("Input mismatch: " + e.getMessage());
              System.out.println("Invalid input! Please enter a valid input.");
              input.nextLine();
          }
      }
  }

    //update product
    public static int updateProduct(ArrayList<Product> arr, Scanner input) {
        for (int i = 0 ; i < arr.size(); i++) {
            System.out.println("Product " + (i + 1) + ": " + arr.get(i).getName());
        }
        System.out.println("(0 - Back to Menu)");
        int choice = 0;
        do {
            System.out.print("\nSelect a product to update: ");
            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid integer");
                input.next();
                continue;
            }
            choice = input.nextInt();
            if (choice == 0) {
                return 0;
            }
            if (choice < 1 || choice > arr.size()) {
                System.out.println("Please enter a valid index within range");
            }
        } while (choice < 1 || choice > arr.size());
        return choice;
    }

    //store products
    public static ArrayList<Product> storeProduct(Scanner input) {
        ArrayList<Product> tmp = new ArrayList<>();
        int choice = 0;
        do {
            System.out.print("Would you like to add products? (1-yes / 0-no): ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please try again.");
                input.next();
                continue;
            }
            choice = input.nextInt();
            if (choice < 0 || choice > 1) {
                System.out.println("Invalid Input (1-yes / 0-no)");
            }
        } while (choice < 0 || choice > 1);

        if (choice == 1) {
            int max = maxProducts(input);
            for (int i = 0; i < max; i++) {
                addProduct(tmp, input);
            }
        }
        return tmp;
    }

    public static void welcomeMessage() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("WELCOME TO SMS");
        System.out.println(formattedDateTime);
        System.out.println(" ");
        System.out.println("<GROUP 96>");
        System.out.println("1. Chey Xin Yi");
        System.out.println("2. Leong Yao Shan");
        System.out.println("3. Ngang Chi Khim");
        System.out.println("4. Wong Kai Ling");
        System.out.println(" ");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        welcomeMessage();

        UserInfo person = new UserInfo();
        person.getNameFromUser(input);
   
        System.out.println("User ID: " + person.getUserId());

        System.out.println();

        ArrayList<Product> arr = storeProduct(input);
        if (arr.isEmpty()) {
            System.out.println();
            System.out.println(person.toString());
            System.out.println("Exiting the system");
            System.exit(0);
        }

        Product p1 = new Refrigerator(1, "hello", 100, 999.99, "sliding", "balck", 50);
        Product p2 = new TV(1, "world", 200, 888.88, "flat", "4k", 32);
        arr.add(p1);
        arr.add(p2);


        boolean end = false;
        do {
            choice = displayMenu(input);
            switch (choice) {
                case 1:
                    viewProducts(arr);
                    break;

                case 2:
                    addStock(arr, input);
                    break;

                case 3:
                    deductStock(arr, input);
                    break;

                case 4:
                    discontinued(arr, input);
                    break;

                case 0:
                    end = true;
                    break;
            }
        } while (!end);

        System.out.println();
        System.out.println(person.toString());
        System.out.println("Exiting the system. Byebye!");

        input.close();
    }


}
