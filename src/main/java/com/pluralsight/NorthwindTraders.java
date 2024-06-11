package com.pluralsight;

import java.sql.*;
import java.util.Scanner;


public class NorthwindTraders {

public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        String password = args[0];
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";

        System.out.println("Select an Option:\n 1) Display All Products\n 2) Display All Customers\n 0) Exit");

        String userInput = myScanner.nextLine();

        try {

            if (userInput.equalsIgnoreCase("1")) {
                System.out.println("All Products: \n");
                String allProductsQuery = "SELECT * FROM Products";


                Connection connection;
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(allProductsQuery);


                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    System.out.println(results.getString("ProductName"));
                }

                results.close();
                statement.close();
                connection.close();


            } else if (userInput.equalsIgnoreCase("2")) {
                System.out.println("All Customers: \n");
                String allCustomersQuery = "SELECT * FROM Customers";


                Connection connection;
                connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(allCustomersQuery);


                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    System.out.println(results.getString("ContactName"));
                }

                results.close();
                statement.close();
                connection.close();


            } else {
                System.exit(0);
            }


        }






        
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        




    }
}
