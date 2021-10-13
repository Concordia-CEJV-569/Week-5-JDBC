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
        readFromDB();
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
    }
}
