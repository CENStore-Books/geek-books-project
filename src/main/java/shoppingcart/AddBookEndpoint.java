package shoppingcart;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class AddBookEndpoint implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
        if (!params.containsKey("userID") || !params.containsKey("bookID")) {
            exchange.sendResponseHeaders(500, 0);
            exchange.getResponseBody().flush();
            exchange.close();
            return;
        }
        int userID = Integer.parseInt(params.get("userID"));
        int bookID = Integer.parseInt(params.get("bookID"));
        try {
            AddToDataBase(userID, bookID);
            exchange.sendResponseHeaders(200, 0);
            exchange.getResponseBody().flush();
            exchange.close();
            return;
        } catch (Exception e) {
            exchange.sendResponseHeaders(500, 0);
            exchange.getResponseBody().flush();
            exchange.close();
            return;
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
