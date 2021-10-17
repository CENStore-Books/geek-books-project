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
import java.util.Arrays;

public class RetrieveListEndpoint implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        if (!params.containsKey("userID")) {
            exchange.sendResponseHeaders(500, 0);
            exchange.getResponseBody().flush();
            exchange.close();
            return;
        }
        int userID = Integer.parseInt(params.get("userID"));
        OutputStream output = exchange.getResponseBody();
        JSONObject object = new JSONObject();
        try {
            int[] bookID = retrieveDataBase(userID);
            object.append("bookIDs", bookID);
        } catch (Exception e) {
            System.err.println("Caught Exception: " + e.getMessage());
        }
        exchange.sendResponseHeaders(200, object.toString().getBytes().length);
        output.write(object.toString().getBytes());
        output.flush();
        exchange.close();

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
