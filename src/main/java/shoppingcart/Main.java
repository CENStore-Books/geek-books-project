/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class Main {

    public static void main(String args[]) throws IOException {
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/hello", new ShoppingCart());
        server.createContext("/api/shoppingcart/add", new AddBookEndpoint());
        server.createContext("/api/shoppingcart/delete", new DeleteBookEndpoint());
        server.createContext("/api/shoppingcart/retrieve", new RetrieveListEndpoint());
        server.setExecutor(null);
        server.start();
       
        
    }
}
