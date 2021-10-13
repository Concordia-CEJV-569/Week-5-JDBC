package com.company;

import com.company.helper.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();

        String insertQuery = "INSERT INTO users(firstname,lastname,username,password) VALUES(?,?,?,?)";

        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "Pranav");
        preparedStatement.setString(2, "Bhatia");
        preparedStatement.setString(3, "pb");
        preparedStatement.setString(4, "secret");

        preparedStatement.executeUpdate();
    }
}
