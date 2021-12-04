/*
- On a 5 star review system with commenting on a book by user with a datestamp.
- Able to retrieve a list of ratings/comments sorted by highest to lowest.
- Able to retrieve average rating for a book.
 */

package bookreview;

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
    private final String date_time;
    
    public BookReview(long id, long userid, long bookid, long rating, String date_time, String comment){
        
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
        this.rating = rating;
        this.comment = comment;
        this.date_time = date_time;
                   
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
    
    public String getdate_time(){
        return date_time;
    }
}
