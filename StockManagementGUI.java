import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StockManagementGUI extends Application {

	private Stage primaryStage; 
	private ArrayList<Product> products = new ArrayList<>();
    private ObservableList<String> productDescriptions = FXCollections.observableArrayList();
    private UserInfo userInfo;

    @Override
	public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        collectUserInfo(primaryStage);
	    }
    
    // Method to show login page
    private void collectUserInfo(Stage primaryStage) {
            
        	if (userInfo == null) {
                userInfo = new UserInfo(); 
            }

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);

            Label dateTimeLabel = new Label("Date and Time: " + formattedDateTime);
            dateTimeLabel.setStyle("-fx-font-family: 'Calibri', serif;-fx-font-size: 12pt; -fx-font-weight: bold;");

            Label nameLabel = new Label("Full Name:  ");
            nameLabel.setStyle("-fx-font-size: 12pt;-fx-font-weight: bold;");
            nameLabel.setPrefWidth(120);
            nameLabel.setWrapText(true);
            nameLabel.setPrefHeight(40);

            TextField nameField = new TextField();
            nameField.setPrefWidth(300);

            HBox nameInputBox = new HBox(20);
            nameInputBox.getChildren().addAll(nameLabel, nameField);
            nameInputBox.setAlignment(Pos.CENTER);
            nameInputBox.setPadding(new Insets(5, 0, 5, 0));

            Button loginButton = new Button("Login");
            loginButton.setStyle("fx-font-family: 'Calibri', serif;-fx-background-color: #0abab5; -fx-text-fill: white; -fx-font-size: 10pt;");
            loginButton.setPrefWidth(70);
            loginButton.setOnAction(event -> {
                String name = nameField.getText();
                if (name.trim().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter your name.");
                    alert.showAndWait();
                } else {
                    userInfo.setName(name);
                    userInfo.generateUserId();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("User Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Hello, " + name + "!");
                    alert.showAndWait();

                    askProductAddition();
                }
            });

            VBox userInfoBox = new VBox(20);
            userInfoBox.setAlignment(Pos.CENTER);
            userInfoBox.setPadding(new Insets(20));
            userInfoBox.setStyle("-fx-font-family: 'Times New Roman', serif;-fx-background-color: #f0f7f4; -fx-border-color: #0abab5; -fx-border-width: 2px;");
            userInfoBox.getChildren().addAll(
                    new Label("Welcome to Stock Management System (SMS)"),
                    nameInputBox,
                    loginButton,
                    dateTimeLabel
            );
            userInfoBox.getChildren().get(0).setStyle("-fx-font-size: 24pt; -fx-font-weight: bold; -fx-text-fill: #0abab5;");

            HBox groupMembersBox = new HBox(10);
            groupMembersBox.setAlignment(Pos.BASELINE_RIGHT);

            Label groupMembersLabel = new Label("Group <96> Members:");
            groupMembersLabel.setStyle("-fx-font-size: 8pt;-fx-font-weight: bold;");
            groupMembersBox.getChildren().add(groupMembersLabel);

            String[] groupMembers = {"Chey Xin Yi", "Leong Yao Shan", "Ngang Chi Khim", "Wong Kai Ling"};
            Arrays.sort(groupMembers);
            for (String member : groupMembers) {
                Label memberLabel = new Label(member);
                memberLabel.setStyle("-fx-font-size: 8pt;");
                groupMembersBox.getChildren().add(memberLabel);
            }

            userInfoBox.getChildren().add(groupMembersBox);

            Scene scene = new Scene(userInfoBox, 800, 300);
            primaryStage.setTitle("Login - Stock Management System (SMS)");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }

    //Method to ask whether users wish to add product or not
    private void askProductAddition() {
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        vbox.setStyle("-fx-background-color: AZURE");

        Label questionLabel = new Label("Do you want to add products?");
        questionLabel.setStyle("-fx-font-size: 16pt; -fx-font-weight: bold; -fx-text-fill: darkblue;");

        ToggleGroup group = new ToggleGroup();

        RadioButton yesButton = new RadioButton("Yes");
        RadioButton noButton = new RadioButton("No");
        yesButton.setToggleGroup(group);
        noButton.setToggleGroup(group);

        // Change radio button color when selected
        yesButton.setStyle("-fx-text-fill: green;");
        noButton.setStyle("-fx-text-fill: red;");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter quantity");
        quantityField.setDisable(true);

        group.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == yesButton) {
                quantityField.setDisable(false);
                quantityField.setStyle("-fx-background-color: white; -fx-border-color: green;"); 
            } else {
                quantityField.setDisable(true);
            }
        });

        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-font-family: 'Calibri', serif; -fx-background-color: #E6E6FA; -fx-text-fill: black; -fx-border-color: purple; -fx-border-radius: 10; -fx-background-radius: 10; -fx-font-size: 10pt;");
        continueButton.setOnAction(e -> {
            if (group.getSelectedToggle() == noButton) {
                handleExit(); 
            } else {
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    if (quantity > 0) {
                        initializeStockManagement(primaryStage); 
                    } else {
                        showAlert("Error", "Please enter a valid number.");
                    }
                } catch (NumberFormatException ex) {
                    showAlert("Error", "Please enter a valid number.");
                }
            }
        });

        vbox.getChildren().addAll(questionLabel, yesButton, noButton, quantityField, continueButton);
        primaryStage.setScene(new Scene(vbox, 400, 300));
        primaryStage.setTitle("Add products?");
        primaryStage.show();
    }
      
    //Method to show StockManagement Page
    private void initializeStockManagement(Stage primaryStage) {
            TabPane tabPane = new TabPane();
            tabPane.setSide(Side.LEFT);
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
            initSampleProducts();

            Tab viewTab = new Tab("View Products", createViewProductsPane());
            Tab addTab = new Tab("Add Product", createAddProductPane());
            Tab manageTab = new Tab("Manage Stock", createStockManagementPane());
            Tab statusTab = new Tab("Check Status", createProductStatusPane());

            tabPane.getTabs().addAll(viewTab, addTab, manageTab, statusTab);
            
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dtf.format(now);

            Label dateTimeLabel = new Label("Date/Time: " + formattedDate);
            dateTimeLabel.setStyle("-fx-text-fill: blue; -fx-font-family: Arial;"); 

            Label userNameLabel = new Label("Welcome, " + userInfo.getName() + "  (User ID: " + userInfo.getUserId() + ")");
            userNameLabel.setStyle("-fx-text-fill: black; -fx-font-family: Times New Roman; -fx-font-size: 15pt; -fx-font-weight: bold;");
            
            Button exitButton = new Button("Exit");
            exitButton.setStyle("-fx-background-color: red; -fx-text-fill: black;");
            exitButton.setOnAction(event -> handleExit());

            HBox topRight = new HBox(dateTimeLabel);
            HBox.setHgrow(dateTimeLabel, Priority.ALWAYS);
            topRight.setStyle("-fx-alignment: top-right;");
            HBox bottomRightBox = new HBox();
            bottomRightBox.setAlignment(Pos.BOTTOM_RIGHT);
            bottomRightBox.getChildren().add(topRight);

            BorderPane topLayout = new BorderPane();
            topLayout.setStyle("-fx-background-color: lightblue;");
            topLayout.setLeft(userNameLabel);
            topLayout.setBottom(bottomRightBox);

            BorderPane root = new BorderPane();
            root.setTop(topLayout);
            root.setCenter(tabPane);
            HBox bottomBox = new HBox(exitButton);
            bottomBox.setStyle("-fx-alignment: bottom-right; -fx-padding: 10;");
            root.setBottom(bottomBox);

            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getBounds().getWidth();
            double screenHeight = screen.getBounds().getHeight();

            Scene scene = new Scene(root, screenWidth, screenHeight);
            primaryStage.setTitle("Stock Management System");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
        }

    //Method to show View Product Pane
    private Pane createViewProductsPane() {
        ListView<String> refrigeratorListView = new ListView<>();
        ListView<String> tvListView = new ListView<>();
        ListView<String> airfryerListView = new ListView<>();
        
        for (Product product : products) {
            if (product instanceof Refrigerator) {
                refrigeratorListView.getItems().add(product.toString());
            } else if (product instanceof TV) {
                tvListView.getItems().add(product.toString());
            } else if (product instanceof AirFryer) {
                airfryerListView.getItems().add(product.toString());
            }
        }

        Button refreshButton = new Button("Refresh");
        refreshButton.setStyle("-fx-background-color: #00008B; -fx-text-fill: White; -fx-font-weight: bold;"); 

        refreshButton.setOnAction(e -> {
        	refreshViewProductsPane();
        });
        
        HBox refreshButtonBox = new HBox(refreshButton);
        refreshButtonBox.setAlignment(Pos.CENTER); 
        refreshButtonBox.setPadding(new Insets(10, 0, 10, 0));
        
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: lightsteelblue;"); 
        VBox.setVgrow(refrigeratorListView, Priority.ALWAYS);
        VBox.setVgrow(tvListView, Priority.ALWAYS);
        VBox.setVgrow(airfryerListView, Priority.ALWAYS);
        vBox.getChildren().addAll(
            new Label("Refrigerators"), refrigeratorListView,
            new Label("TVs"), tvListView,
            new Label("AirFryers"), airfryerListView,
            refreshButtonBox
        );
        
        return vBox;
    }
   
    //Method to show Add Product Pane
    private Pane createAddProductPane() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // Product fields
        TextField nameField = new TextField();
        TextField priceField = new TextField();
        TextField quantityField = new TextField();

        // Refrigerator specific fields
        TextField doorDesignField = new TextField();
        TextField colorRField = new TextField();
        TextField capacityField = new TextField();

        // TV specific fields
        TextField screenTypeField = new TextField();
        TextField resolutionField = new TextField();
        TextField displaySizeField = new TextField();
        
        // AirFryer specific fields
        TextField colorAField = new TextField();
        TextField weightField = new TextField();
        TextField capacityAField = new TextField();

        ComboBox<String> productTypeComboBox = new ComboBox<>();
        productTypeComboBox.getItems().addAll("Refrigerator", "TV","AirFryer");

        Button addButton = new Button("Add Product");
        addButton.setStyle("fx-font-family: 'Calibri', serif;-fx-background-color: #E6E6FA; -fx-text-fill: black; -fx-border-color: purple; -fx-font-size: 10pt;-fx-border-radius: 15; -fx-background-radius: 15;");
        Label successLabel = new Label(" Added Successfully!");
        successLabel.setTextFill(Color.GREEN);
        
        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                int itemNum; 
                
                if ("Refrigerator".equals(productTypeComboBox.getValue())) {
                    itemNum = getMaxRefrigeratorItemNumber() + 1;
                    String doorDesign = doorDesignField.getText();
                    String colorR = colorRField.getText();
                    int capacity = Integer.parseInt(capacityField.getText());
                    Refrigerator newRefrigerator = new Refrigerator(itemNum, name, quantity, price, doorDesign, colorR, capacity);
                    products.add(newRefrigerator);
                } else if ("TV".equals(productTypeComboBox.getValue())) {
                    itemNum = getMaxTVItemNumber() + 1;
                    String screenType = screenTypeField.getText();
                    String resolution = resolutionField.getText();
                    int displaySize = Integer.parseInt(displaySizeField.getText());
                    TV newTV = new TV(itemNum, name, quantity, price, screenType, resolution, displaySize);
                    products.add(newTV);
                } else if ("AirFryer".equals(productTypeComboBox.getValue())) {
                    itemNum = getMaxAirFryerItemNumber() + 1;
                    String colorA = colorAField.getText();
                    int weight = Integer.parseInt(weightField.getText());
                    int capacityA = Integer.parseInt(capacityAField.getText());
                    AirFryer newAirFryer = new AirFryer(itemNum, name, quantity, price, colorA, weight, capacityA);
                    products.add(newAirFryer);
                }

                // If no errors, show success message
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Product Added");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Product added successfully!");
                successAlert.showAndWait();

                // Refresh view pane and clear input fields after a successful addition
                refreshViewProductsPane();
                nameField.clear();
                priceField.clear();
                quantityField.clear();
                doorDesignField.clear();
                colorRField.clear();
                capacityField.clear();
                screenTypeField.clear();
                resolutionField.clear();
                colorAField.clear();
                weightField.clear();
                capacityAField.clear();

            } catch (NumberFormatException ex) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Input Error");
                errorAlert.setHeaderText("Invalid Input");
                errorAlert.setContentText("Please enter valid numerical values for price, quantity, and other numerical fields.");
                errorAlert.showAndWait();
            }
        });

        gridPane.add(new Label("Product Type:"), 0, 0);
        gridPane.add(productTypeComboBox, 1, 0);
        gridPane.add(new Label("Name:"), 0, 1);
        gridPane.add(nameField, 1, 1);
        gridPane.add(new Label("Price:"), 0, 2);
        gridPane.add(priceField, 1, 2);
        gridPane.add(new Label("Quantity:"), 0, 3);
        gridPane.add(quantityField, 1, 3);


        productTypeComboBox.setOnAction(event -> setupProductSpecificFields(gridPane, productTypeComboBox.getValue(),
                doorDesignField, colorRField, capacityField, screenTypeField, resolutionField, colorAField, weightField, capacityAField, displaySizeField, addButton, successLabel));

        return gridPane;
        }

    //Method to show Manage Product Pane
    private Pane createStockManagementPane() {
    ComboBox<String> productTypeComboBox = new ComboBox<>();
    productTypeComboBox.getItems().addAll("Refrigerator", "TV", "AirFryer");

    TextField itemIdField = new TextField();
    itemIdField.setPromptText("Enter Item ID");
    itemIdField.setPrefWidth(200);

    TextField amountField = new TextField();
    amountField.setPromptText("Enter Quantity");
    amountField.setPrefWidth(200);

    Button addButton = new Button("Add Stock");
    Button deductButton = new Button("Deduct Stock");

    Label messageLabel = new Label(); 

    addButton.setOnAction(e -> {
        String category = productTypeComboBox.getValue();
        String itemIdText = itemIdField.getText();

        if (category != null && !category.trim().isEmpty() && itemIdText != null && !itemIdText.trim().isEmpty()) {
            try {
                int itemId = Integer.parseInt(itemIdText); // Extract item ID
                Product selected = findProductByItemNumber(itemId); // Find product by item ID

                if (selected != null && isValidQuantity(amountField.getText())) {
                    int quantity = Integer.parseInt(amountField.getText());
                    selected.addStock(quantity); // Add stock
                    messageLabel.setText("Stock added successfully.");
                    messageLabel.setTextFill(Color.GREEN);
                    refreshViewProductsPane(); 
                } else {
                    messageLabel.setText("Please enter a valid quantity.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid item ID. Please enter a valid integer.");
            }
        } else {
            messageLabel.setText("Please select a product category and enter an item ID.");
        }
    });

    deductButton.setOnAction(e -> {
        String category = productTypeComboBox.getValue();
        String itemIdText = itemIdField.getText();

        if (category != null && itemIdText != null && !itemIdText.trim().isEmpty()) {
            try {
                int itemId = Integer.parseInt(itemIdText);
                Product selected = findProductByItemNumber(itemId);

                if (selected != null && isValidQuantity(amountField.getText())) {
                    int quantity = Integer.parseInt(amountField.getText());
                    selected.deductStock(quantity); // Deduct stock
                    messageLabel.setText("Stock deducted successfully.");
                    messageLabel.setTextFill(Color.RED);
                    refreshViewProductsPane(); 
                } else {
                    messageLabel.setText("Please enter a valid quantity.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid item ID. Please enter a valid integer.");
            }
        } else {
        	messageLabel.setText("Please select a product category and enter an item ID.");        }
    });


    HBox buttonBox = new HBox(10, addButton, deductButton); // Layout for add and deduct buttons
    VBox vBox = new VBox(10, new Label("Select Product Category:"), productTypeComboBox, new Label("Item ID:"), itemIdField, new Label("Quantity:"), amountField, buttonBox, messageLabel); // Main layout for HBox and VBox
    vBox.setPadding(new Insets(10));

    return vBox;
}

    //Method to show Status Product Pane
    private Pane createProductStatusPane() {
    	//GridPane setup
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20));

        //Components setup
        TextField itemIdField = new TextField();
        Button checkStatusButton = new Button("Check Status");
        checkStatusButton.setStyle("fx-font-family: 'Calibri', serif;-fx-background-color: #E6E6FA; -fx-text-fill: black;-fx-border-color: purple; -fx-font-size: 10pt;-fx-border-radius: 15; -fx-background-radius: 15;");
        Label statusLabel = new Label();
        ListView<String> productListView = new ListView<>(); // ListView to display product information

        //Event handler for CheckStatus Button
        checkStatusButton.setOnAction(e -> {
            String itemIdInput = itemIdField.getText();
            boolean found = false;
            for (Product product : products) {
                if (Integer.toString(product.getItemNum()).equals(itemIdInput)) {
                	productListView.getItems().clear();
                	productListView.getItems().add(product.toString());
                	
                	String statusText = "Status: " + (product.isStatus() ? "Active" : "Discontinued");
                    statusLabel.setText(statusText); // Set status text

                    // Set text fill color based on product status
                    if (product.isActive()) {
                        statusLabel.setTextFill(Color.GREEN);
                    } else {
                        statusLabel.setTextFill(Color.ORANGE);
                    }
                    
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                // Handle case when product is not found
                statusLabel.setText("Status: Product Not Found");
                statusLabel.setTextFill(Color.RED); // Set default text color
            }
            
            });
        
        // Discontinue button setup and event handler
        Button discontinueButton = new Button("Discontinue Product");
        discontinueButton.setOnAction(e -> {
            String itemIdInput = itemIdField.getText();
            boolean found = false;
            for (Product product : products) {
                if (Integer.toString(product.getItemNum()).equals(itemIdInput)) {
                    discontinueProduct(product); // Discontinue the selected product
                    statusLabel.setText("Status: Discontinued"); // Update status label
                    statusLabel.setTextFill(Color.ORANGE);
                    found = true;
                    break;
                }
            }
            if (!found) {
                statusLabel.setText("Product not found!");
            }
        });

        // GridPane layout
        gridPane.add(new Label("Enter Item ID:"), 0, 0);
        gridPane.add(itemIdField, 1, 0);
        gridPane.add(checkStatusButton, 2, 0);
        gridPane.add(statusLabel, 0, 1, 3, 1);
        gridPane.add(discontinueButton, 0, 4);
        
        // Add the productListView to the gridPane
        gridPane.add(new Label("Product Information:"), 0, 2);
        gridPane.add(productListView, 0, 3, 3, 1);

        return gridPane;
    }
    
    // Method to discontinue a product
    private void discontinueProduct(Product product) {
        product.setStatus(false); // Set the status of the product to discontinued
        refreshViewProductsPane(); // Refresh the product view to reflect the status change
    }
    
    // Method to refresh the product view pane
    private void refreshViewProductsPane() {
    	// Retrieve necessary componentS
    	TabPane tabPane = (TabPane) this.primaryStage.getScene().getRoot().getChildrenUnmodifiable().get(1);
    	Tab viewTab = tabPane.getTabs().get(0); // Assumes the first tab is "View Products"
    
    	VBox vBox = (VBox) viewTab.getContent();
    	ListView<String> refrigeratorListView = (ListView<String>) vBox.getChildren().get(1);
    	ListView<String> tvListView = (ListView<String>) vBox.getChildren().get(3);
    	ListView<String> airfryerListView = (ListView<String>) vBox.getChildren().get(5);

    	// Clear the existing ListViews
    	refrigeratorListView.getItems().clear();
    	tvListView.getItems().clear();
    	airfryerListView.getItems().clear();

    	// Populate the ListViews with updated product data
    	for (Product product : products) {
    		if (product instanceof Refrigerator) {
    			refrigeratorListView.getItems().add(product.toString());
    		} else if (product instanceof TV) {
    			tvListView.getItems().add(product.toString());
    		} else if (product instanceof AirFryer) {
    			airfryerListView.getItems().add(product.toString());
    		}
    	}
    }

    // Method to find the maximum item number for refrigerators
    private int getMaxRefrigeratorItemNumber() {
        int maxItemNumber = 100; // Start refrigerators at 100
        for (Product product : products) {
            if (product instanceof Refrigerator && product.getItemNum() > maxItemNumber) {
                maxItemNumber = product.getItemNum();
            }
        }
        return maxItemNumber;
    }
   
    // Method to find the maximum item number for TVs
    private int getMaxTVItemNumber() {
        int maxItemNumber = 200; // Start TVs at 200
        for (Product product : products) {
            if (product instanceof TV && product.getItemNum() > maxItemNumber) {
                maxItemNumber = product.getItemNum();
            }
        }
        return maxItemNumber;
    }
   
    // Method to find the maximum item number for AirFryers 
    private int getMaxAirFryerItemNumber() {
        int maxItemNumber = 200; // Start AirFryers at3200
        for (Product product : products) {
            if (product instanceof AirFryer && product.getItemNum() > maxItemNumber) {
                maxItemNumber = product.getItemNum();
            }
        }
        return maxItemNumber;
    }
    
    // Method to check if a quantity is valid
    private boolean isValidQuantity(String quantity) {
        try {
            int qty = Integer.parseInt(quantity);
            return qty > 0; // Valid if positive
        } catch (NumberFormatException e) {
            return false; // Invalid if not a number
        }
    }
    
    // Method to find a product by item number
    private Product findProductByItemNumber(int itemNumber) {
        for (Product product : products) {
            if (product.getItemNum() == itemNumber) {
                return product; // Product found
            }
        }
        return null; // Product not found
    }

    // Method to show an alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to initialize sample products
    private void initSampleProducts() {
        products.add(new Refrigerator(101, "Samsung Fridge", 5, 1200.00, "Side-by-Side", "Silver", 500));
        products.add(new TV(201, "LG OLED", 10, 2500.00, "OLED", "4K", 55));
        products.add(new AirFryer(301,"Panasonic",23,180, "Purple",2.75,3.7));
        // Populate the observable list with the product descriptions
        products.forEach(product -> productDescriptions.add(product.toString()));
    }
    // Method to setup product specific fields in the grid
    private void setupProductSpecificFields(GridPane gridPane, String productType,
            TextField doorDesignField, TextField colorRField, TextField capacityField,
            TextField screenTypeField, TextField resolutionField, 
            TextField colorAField, TextField weightField, TextField capacityAField, TextField displaySizeField,
            Button addButton, Label successLabel)	
    {
			gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 4);  // Remove previous specific fields
			
			if ("Refrigerator".equals(productType)) {
			gridPane.add(new Label("Door Design:"), 0, 4);
			gridPane.add(doorDesignField, 1, 4);
			gridPane.add(new Label("Color:"), 0, 5);
			gridPane.add(colorRField, 1, 5);
			gridPane.add(new Label("Capacity:"), 0, 6);
			gridPane.add(capacityField, 1, 6);
			gridPane.add(addButton, 1, 7);
			} else if ("TV".equals(productType)) {
			gridPane.add(new Label("Screen Type:"), 0, 4);
			gridPane.add(screenTypeField, 1, 4);
			gridPane.add(new Label("Resolution:"), 0, 5);
			gridPane.add(resolutionField, 1, 5);
			gridPane.add(new Label("Display Size:"), 0, 6);
			gridPane.add(displaySizeField, 1, 6);
			gridPane.add(addButton, 1, 7);
			} else if ("AirFryer".equals(productType)) {
			gridPane.add(new Label("Color:"), 0, 4);
			gridPane.add(colorAField, 1, 4);
			gridPane.add(new Label("Weight:"), 0, 5);
			gridPane.add(weightField, 1, 5);
			gridPane.add(new Label("Capacity:"), 0, 6);			
			gridPane.add(capacityAField, 1, 6);
			gridPane.add(addButton, 1, 7);
			}
}
    
    // Method to handle application exit
    private void handleExit() {
        // Capture the current time for exit
        LocalDateTime exitTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedExitTime = dtf.format(exitTime);

        // Prepare the exit message
        String exitMessage = String.format("Full Name: %s\nUser ID: %s\nExit Time: %s",
                userInfo.getName(), userInfo.getUserId(), formattedExitTime);

        // Show an alert with the exit message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Thank you for using the Stock Management System");
        alert.setContentText(exitMessage);
        alert.showAndWait();

        // Exit the application
        System.exit(0); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}