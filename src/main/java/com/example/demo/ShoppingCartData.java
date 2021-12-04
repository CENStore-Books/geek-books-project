
package com.example.demo;



public class ShoppingCartData {
    private int userID = 0;
    private int[] bookID;
    
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
