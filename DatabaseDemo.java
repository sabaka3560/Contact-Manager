// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DatabaseDemo extends Frame implements ActionListener
{
    private TextField nameField, ageField, idField;
    private Button addButton, updateButton, deleteButton;
    private Label messageLabel;
    private Connection connection;

    public DatabaseDemo()
    {
        super("Database Demo");

        // Create text fields
        nameField = new TextField(20);
        ageField = new TextField(20);
        idField = new TextField(20);

        // Create buttons
        addButton = new Button("Add");
        addButton.addActionListener(this);
        updateButton = new Button("Update");
        updateButton.addActionListener(this);
        deleteButton = new Button("Delete");
        deleteButton.addActionListener(this);

        // Create message label
        messageLabel = new Label("");

        // Add components to window
        setLayout(new GridLayout(4, 2));
        add(new Label("Name:"));
        add(nameField);
        add(new Label("Age:"));
        add(ageField);
        add(new Label("ID:"));
        add(idField);
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(messageLabel);

        // Connect to MySQL database
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/mydatabase?serverTimezone=UTC&useSSL=false", "", "");
        }
        catch
        (Exception ex)
        {
            messageLabel.setText("Error connecting to database: " + ex.getMessage());
        }

        // Set window size and visibility
        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            Statement statement = connection.createStatement();
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            int id = Integer.parseInt(idField.getText());

            if (e.getSource() == addButton)
            {
                String sql ="INSERT INTO mytable (name, age, id) VALUES ('" + name + "', " + age + ", " + id + ")";
                System.out.println(sql);
                statement.executeUpdate("INSERT INTO mytable (name, age, id) VALUES ('" + name + "', " + age + ", " + id + ")");
                messageLabel.setText("Record added successfully");
            }
            else if (e.getSource() == updateButton)
            {
                String sqlUPdate="UPDATE mytable SET name = '" + name + "', age = " + age + " WHERE id = " + id;
                System.out.println(sqlUPdate);
                statement.executeUpdate("UPDATE mytable SET name = '" + name + "', age = " + age + " WHERE id = " + id);
                messageLabel.setText("Record updated successfully");
            }
            else if (e.getSource() == deleteButton)
            {
                statement.executeUpdate("DELETE FROM mytable WHERE id = " + id);

                messageLabel.setText("Record deleted successfully");
            }
        }
        catch (Exception ex)
        {
            messageLabel.setText("Error performing operation: " + ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        new DatabaseDemo();
    }
}