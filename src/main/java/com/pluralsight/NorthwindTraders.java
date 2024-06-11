package com.pluralsight;

import java.sql.*;



public class NorthwindTraders {

    public static void main(String[] args) {
        String password = args[0];
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";

        String query = "SELECT * FROM Products";


        try {

            Connection connection;
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);


            ResultSet results = statement.executeQuery();

            while(results.next()) {
                System.out.println(results.getString("ProductName"));
            }

            results.close();
            statement.close();
            connection.close();

            
        }
        
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        




    }
}
