# Contact-Manager
The Contact Manager is a Java app facilitating contact management through MySQL. It offers a simple interface for adding, updating, and deleting contacts, suitable for beginners.


DatabaseDemo Application Documentation - Contact Manager
The DatabaseDemo application is a simple Java-based GUI application that demonstrates basic CRUD (Create, Read, Update, Delete) operations on a MySQL database. It utilizes the AWT (Abstract Window Toolkit) for creating the graphical user interface and JDBC (Java Database Connectivity) for database operations.
Features
Add a new record to the database.
Update an existing record based on the ID.
Delete an existing record based on the ID.
User Interface
The application window consists of:
Text fields for entering the Name, Age, and ID of a person.
Buttons to perform add, update, and delete operations.
A message label to display operation status or errors.
Database Setup Steps
To use this application, you need to set up a MySQL database and a table. Follow these steps:
1. Install MySQL
Ensure MySQL is installed on your system. You can download it from the official MySQL website.
2. Create a Database
Log in to your MySQL server and create a new database. For example:
sql
CREATE DATABASE mydatabase;

3. Create a Table
In your database, create a table named mytable with columns for ID, Name, and Age. For instance:
sql
USE mydatabase;

CREATE TABLE mytable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

4. MySQL User and Permissions
Ensure you have a MySQL user with appropriate permissions to access and modify the mydatabase database. For security reasons, it's advised to use a user with limited privileges tailored to the needs of this application.
Connecting to the Database
In the DatabaseDemo constructor, the application establishes a connection to the MySQL database. Note that the password and user details have been omitted for privacy reasons. You should replace "root" and "****your password*****" with your actual MySQL username and password.
java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3308/mydatabase?serverTimezone=UTC&useSSL=false",
    "yourUsername", "yourPassword");

Replace yourUsername and yourPassword with your actual MySQL credentials.
Running the Application
To run the application, compile the DatabaseDemo Java file and run the resulting class file. Ensure you have the MySQL JDBC driver in your classpath. The application window will open, allowing you to interact with the database through the GUI.
Security Note
The code demonstrates a basic approach to performing database operations and is meant for educational purposes. In a production environment, consider the following improvements for better security and performance:
Use prepared statements to prevent SQL injection.
Store sensitive information like database passwords securely, not directly in the code.
Handle database connections and exceptions more robustly.
By following these setup steps and considering security improvements, you can effectively use and build upon the DatabaseDemo application for your Java and MySQL learning journey.

