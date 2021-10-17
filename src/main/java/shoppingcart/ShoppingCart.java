/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoppingCart implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        if (!params.containsKey("A")) {
            exchange.sendResponseHeaders(500, 0);
            exchange.getResponseBody().flush();
            exchange.close();
            return;
        }
        System.out.println("param A=" + params.get("A"));
        OutputStream output = exchange.getResponseBody();
        JSONObject object = new JSONObject();
        try {
            object.append("1", new int[]{2, 1, 0});
        } catch (JSONException e) {

        }
        exchange.sendResponseHeaders(200, object.toString().getBytes().length);
        output.write(object.toString().getBytes());
        System.out.print(object.toString());

        output.flush();
        exchange.close();

        try {
            readDataBase();
        } catch (Exception e) {

        }
    }

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?" + "user=root&password=");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from bookstore.shoppingcart");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  bookstore.shoppingcart values (default, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 12);
            preparedStatement.executeUpdate();

            
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int ID = resultSet.getInt("ID");
            int userID = resultSet.getInt("userID");
            int bookID = resultSet.getInt("bookID");
            System.out.println("ID: " + ID);
            System.out.println("UserID: " + userID);
            System.out.println("BookID: " + bookID);
        }
    }

    public Map<String, String> queryToMap(String query) {
        if (query == null) {
            return null;
        }
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

    // You need to close the resultSet
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
