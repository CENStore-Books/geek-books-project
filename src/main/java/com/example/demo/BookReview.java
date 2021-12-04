/*
- On a 5 star review system with commenting on a book by user with a datestamp.
- Able to retrieve a list of ratings/comments sorted by highest to lowest.
- Able to retrieve average rating for a book.
 */

package com.example.demo;

/**
 *
 * @author dunn
 */
public class BookReview {
    
    private final long id;
    private final long userid;
    private final long bookid;
    private final long rating;
    private final String comment;
    
    public BookReview(long id, long userid, long bookid, long rating, String comment){
        
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
        this.rating = rating;
        this.comment = comment;
                   
    }
    
    public long getid(){
        return id;    
    }
    
    public long getuserid(){
        return userid;
    }
    
    public long getbookid(){
        return bookid;
    }
    
    public long getrating(){
        return rating;
    }
    
    public String comment(){
        return comment;
    }
}
