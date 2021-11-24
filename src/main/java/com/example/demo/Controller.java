package com.example.demo;

import java.sql.DriverManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

@RestController
public class Controller {

    @GetMapping("/addBook")
    public void AddBook(@RequestParam(value = "bookID") int bookID, @RequestParam(value = "userID") int userID) {
    try {
        AddToDataBase(userID, bookID);
    } catch (Exception e) {
        
    }
}
    @GetMapping("/deleteBook")
    public void DeleteBook(@RequestParam(value = "bookID") int bookID, @RequestParam(value = "userID") int userID) {
    try {
        DeleteFromDataBase(userID, bookID);
    } catch (Exception e) {
        
    }
}
     @GetMapping("/retrieveList")
    public ShoppingCartData RetrieveList(@RequestParam(value = "userID") int userID) {
    try {
        int[] bookIDs = retrieveDataBase(userID);
        ShoppingCartData scd = new ShoppingCartData(userID, bookIDs);
        return scd;
    } catch (Exception e) {
        return null;
    }
    
}
    public void AddToDataBase(int userID, int bookID) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=");

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("insert into  bookstore.shoppingcart values (default, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, bookID);
            preparedStatement.executeUpdate();
            
            

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
     public void DeleteFromDataBase(int userID, int bookID) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=");

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("delete from bookstore.shoppingcart where bookID=? and userID=?");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setInt(2, userID);
            preparedStatement.setInt(1, bookID);
            preparedStatement.executeUpdate();
            
            

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
     public int[] retrieveDataBase(int userID) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=");

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("select bookID from bookstore.shoppingcart where userID=?");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            
            int[] bookID = new int[0];
            int index = 0;
            while (resultSet.next()) {
                bookID = Arrays.copyOf(bookID, bookID.length+1);
                bookID[index++] = resultSet.getInt("bookID");
            }
            return bookID;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
       private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
}
