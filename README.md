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
* User
<img width="1919" height="987" alt="Screenshot 2025-07-28 075527" src="https://github.com/user-attachments/assets/1c09a52c-fb81-417d-884c-a5a81811d39c" />
<img width="807" height="337" alt="Screenshot 2025-07-28 071307" src="https://github.com/user-attachments/assets/b3988d4c-e86a-48e8-a67a-2e9b1a49ac28" />
<img width="389" height="319" alt="Screenshot 2025-07-28 080729" src="https://github.com/user-attachments/assets/ee1b0414-2a91-4ef0-9b70-aab3f663cb78" />
<img width="1919" height="1079" alt="Screenshot 2025-07-28 073022" src="https://github.com/user-attachments/assets/b3c055fb-a8a2-47bb-b700-dd8c3641b14f" />
<img width="1919" height="1019" alt="Screenshot 2025-07-28 073441" src="https://github.com/user-attachments/assets/2bba9887-52f1-403b-b5ae-1002bf50b021" />
<img width="1919" height="1009" alt="Screenshot 2025-07-28 074415" src="https://github.com/user-attachments/assets/12b9bc0c-51e8-449b-bfb3-d1d03d327d21" />
<img width="1919" height="1020" alt="Screenshot 2025-07-28 074542" src="https://github.com/user-attachments/assets/9ed13235-0cf7-4c30-9fb6-61e7e6ba67ad" />
<img width="1919" height="1018" alt="Screenshot 2025-07-28 074903" src="https://github.com/user-attachments/assets/7ab905fd-c736-4383-8e30-124618094ace" />
<img width="1917" height="1012" alt="Screenshot 2025-07-28 075216" src="https://github.com/user-attachments/assets/a189359e-1004-439d-9cce-7ea90cd61868" />
<img width="1919" height="987" alt="Screenshot 2025-07-28 075527" src="https://github.com/user-attachments/assets/fa2fc952-406d-4d80-8241-65169cbbb27b" />
<img width="1917" height="1019" alt="Screenshot 2025-07-28 075901" src="https://github.com/user-attachments/assets/5fd8a124-6695-49c3-a038-cdbe660aae6d" />
<img width="1919" height="1013" alt="Screenshot 2025-07-28 080528" src="https://github.com/user-attachments/assets/6698cb61-db79-4bc4-b20d-5114bac09373" />
<img width="1917" height="1016" alt="Screenshot 2025-07-28 080625" src="https://github.com/user-attachments/assets/7e980981-9085-45b6-8187-84b1167d6695" />
<img width="395" height="326" alt="Screenshot 2025-07-28 072057" src="https://github.com/user-attachments/assets/a0ac990a-8f20-43d4-9426-7a1a9de97dd2" /> <br>
<img width="489" height="239" alt="Screenshot 2025-07-28 071628" src="https://github.com/user-attachments/assets/8dde7d97-cdee-4abe-a406-0ddf5e07886f" />

* Guest
<img width="802" height="335" alt="Screenshot 2025-07-28 070621" src="https://github.com/user-attachments/assets/b4fbf712-00af-40b3-9369-ff360099cd07" />
<img width="488" height="236" alt="Screenshot 2025-07-28 071850" src="https://github.com/user-attachments/assets/3a835888-2239-415f-8b11-96561eee87e1" />

