Inventory Management System

#Main Features

1.Login System:
Secure login page for authorized access.
Role-based permissions restricted to managers for advanced actions.
https://github.com/SyntaxSunset/Inventory-Management/issues/1#issue-2665288700

2.Navigation Dashboard:
Simple interface with buttons to access key modules like Product, Employee, Supplier, and Sales.

3.Product Module:
Helps in organizing and visualizing product categories and inventory layout.

4.Employee Management:
Add, update, and manage employee details for better workforce tracking.

5.Supplier Management:
Maintain supplier information and track supply chain activities.

6.Order Management:
Keep track of incoming and outgoing orders to ensure proper stock levels.

7.Sales Management:
Record and monitor daily sales to analyze performance and profitability.

8.Restricted Permissions:
Only managers have full access to sensitive modules like sales and orders, ensuring data security.

#Designed For

1.Small Business Owners:
Ideal for retail shops, small warehouses, or startups needing a cost-effective and simple inventory solution.

2.Managers of Small Teams:
Helps manage inventory, oversee employee roles, and coordinate smoothly with suppliers.

#Setup Instructions

Prerequisites:
1.Java Development Kit (JDK) installed on your system.

2.Database setup: MySQL or any other relational database.

3.Git for cloning the repository

#Technologies Used

1.Frontend: Java Swing (for UI design)

2.Backend: Core Java

3.Database: MySQL

4.Version Control: Git

#How to run this program

1. Clone the Repository

Open your terminal or command prompt.

Clone the project repository:

    git clone <repository_url>
Navigate to the project folder:

    cd inventory-management
2. Set Up the Database

Open your MySQL client or terminal.
Create the database and import the SQL file:

    CREATE DATABASE inventory_db;
    USE inventory_db;
    SOURCE inventory.sql;
Update the database credentials in the DBConnection.java file:

    String url = "jdbc:mysql://localhost:3306/inventory_db";
    String user = "root";
    String password = "root";//your sql password
3. Compile the Program

Compile the Java files to generate class files:

    javac -d out src/**/*.java
4. Run the Program

Run the main class to start the system:

    java -cp out Main
