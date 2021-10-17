/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import org.json.JSONException;

public class ShoppingCartData {
    int userID = 0;
    int[] bookID;
    
    public ShoppingCartData(int userID, int[] bookID) {
        this.userID = userID;
        this.bookID = bookID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public int getUserID() {
        return this.userID;
    }
    
    public void setBookID(int[] bookID) {
        this.bookID = bookID;
    }
    
    public int[] getBookID() {
        return this.bookID;
    }
}
