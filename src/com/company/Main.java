package com.company;

import com.company.helper.DBHandler;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();

//        writeToDB();
//        readFromDB();
        updateDB("Cristiano", "Rolando", "cr", "secret", 5);
    }


    public static void readFromDB() throws SQLException {
        String readQuery = "SELECT * from users";
        PreparedStatement preparedStatement = connection.prepareStatement(readQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Name: " + resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
        }
    }

    public static void writeToDB() throws SQLException {
        String insertQuery = "INSERT INTO users(firstname,lastname,username,password) VALUES(?,?,?,?)";

        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "Lionel");
        preparedStatement.setString(2, "Messi");
        preparedStatement.setString(3, "lm");
        preparedStatement.setString(4, "secret");

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void updateDB(String firstName, String lastName, String username, String password, int id) throws SQLException {
        String query = "UPDATE users SET firstname = ?, lastname = ?, username = ?, password = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, username);
        preparedStatement.setString(4, password);
        preparedStatement.setInt(5, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
