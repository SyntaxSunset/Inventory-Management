# Inventory Management System

## Description

The Inventory Management System is designed to help small to medium businesses track and manage their inventory in real-time. It allows users to add, update, remove, and view products, ensuring efficient stock management and avoiding overstocking or stockouts.

## Table of Contents
•⁠  ⁠[Description](#description)
•⁠  ⁠[Features](#features)
•⁠  ⁠[Usage](#usage)
•⁠  ⁠[Contributing](#contributing)

## Features
- ⁠Add, update, and delete products in the inventory.
- Track stock levels and update inventory in real-time.
- Employee management system working inside the inventory.
- ⁠Generate reports on sales, and reorder levels.

## Usage

<h3>Main Features</h3>

1.Login System:
Secure login page for authorized access.
Role-based permissions restricted to managers for advanced actions.


<img width="782" alt="Screenshot 2024-11-17 at 10 48 49 AM" src="https://github.com/user-attachments/assets/ea67c333-f5ae-46a0-bd89-a5883b3028a7">


2.Navigation Dashboard:
Simple interface with buttons to access key modules like Product, Employee, Supplier, and Sales.


<img width="838" alt="Screenshot 2024-11-17 at 10 49 44 AM" src="https://github.com/user-attachments/assets/5e746c78-27cc-4587-8b4f-8ab080a5d0a7">


3.Product Module:
Helps in organizing and visualizing product categories and inventory layout.


<img width="777" alt="Screenshot 2024-11-17 at 10 50 57 AM" src="https://github.com/user-attachments/assets/ac6e56bb-3d4d-4ee5-8462-02e5863b4167">


4.Employee Management:
Add, update, and manage employee details for better workforce tracking.


<img width="891" alt="Screenshot 2024-11-17 at 10 51 17 AM" src="https://github.com/user-attachments/assets/e243fc1e-aa85-4b42-aaaa-08a1132aa892">


5.Supplier Management:
Maintain supplier information and track supply chain activities.


<img width="889" alt="Screenshot 2024-11-17 at 10 51 46 AM" src="https://github.com/user-attachments/assets/4d6a9169-7c4b-4565-a98b-849f0ca01f76">


6.Order Management:
Keep track of incoming and outgoing orders to ensure proper stock levels.


<img width="893" alt="Screenshot 2024-11-17 at 11 14 17 AM" src="https://github.com/user-attachments/assets/263bb098-45a7-486c-b0ff-ec50c4eaa3fd">


7.Sales Management:
Record and monitor daily sales to analyze performance and profitability.


<img width="893" alt="Screenshot 2024-11-17 at 10 52 37 AM" src="https://github.com/user-attachments/assets/a71fa41e-a9d8-477c-ad17-5551f82b4dd1">


<h3>Restricted Permissions:</h3>
Only managers have full access to sensitive modules like sales and orders, ensuring data security.

<h3>#Designed For</h3>

1.Small Business Owners:
Ideal for retail shops, small warehouses, or startups needing a cost-effective and simple inventory solution.

2.Managers of Small Teams:
Helps manage inventory, oversee employee roles, and coordinate smoothly with suppliers.

<h3>#Setup Instructions</h3>

Prerequisites:

1.Java Development Kit (JDK) installed on your system.

2.Database setup: MySQL or any other relational database.

3.Git for cloning the repository

<h3>#Technologies Used</h3>

1.Frontend: Java Swing (for UI design)

2.Backend: Core Java

3.Database: MySQL

4.Version Control: Git

<h3>#How to run this program</h3>

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


