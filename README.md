# Stock Management System
Developed a Java-based Stock Management System using OOP and GUI, featuring user login, product viewing, stock updating, and status tracking. Implemented input validation, real-time inventory updates, and a user-friendly interface with multiple interactive panes. Applied object-oriented principles for modular design and demonstrated the system with UML diagrams and live functionality. This system offers an intuitive graphical user interface (GUI) to enhance user experience and improve efficiency.

# Technical Details
- **Language & IDE:** Java 
- **OOP Principles:**  
  - **Encapsulation & Single Responsibility:** each class has one clear purpose  
  - **Open/Closed Principle:** easy to extend with new product types  
  - **Polymorphism:** `Product` is an abstract base; `Refrigerator`, `TV`, and `AirFryer` extend it  
- **Core Classes:**  
  - `Product` (abstract): common fields (item number, name, price, quantity, status) and methods  
  - `Refrigerator` / `TV` / `AirFryer`: extend `Product` with specific attributes (e.g. capacity, door design; screen type, resolution) and override `toString()`  
  - `UserInfo`: prompts for user name, generates a user ID (first initial + surname or “guest”)  
  - `StockManagement`: application driver (menu loop, static helpers for input validation, product array management)
  
# Program Flow
   * On start: displays welcome banner with current date/time and group member names
   * Prompts user for full name → generates user ID
   * Main menu (loop until exit):

     1. View products
     2. Add stock
     3. Deduct stock
     4. Discontinue product
     5. Add new product (Refrigerator or TV)
     6. Exit
   * Upon exit: displays generated user ID and name

# Showcase
