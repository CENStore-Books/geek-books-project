package com.example.demo;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.util.List;

@RestController
public class controller {

	@RequestMapping(value = "/AddReview")
	public ResponseEntity<Object> Addreview(@RequestParam(value = "userid")long userid, 
			@RequestParam(value = "bookid")long bookid, 
			@RequestParam(value = "rating")long rating,
			@RequestParam(value = "comment")String comment) {
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/geektextdb","root","wfan003@fiu");
			String query = "INSERT INTO `ratings`(`userid`, `bookid`, `rating`, `comment`) "
				+ "VALUES (?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setLong (1, userid);
		    preparedStmt.setLong (2, bookid);
		    preparedStmt.setLong (3, rating);
		    preparedStmt.setString (4, comment);
		    
		    preparedStmt.execute();
		    
		    con.close();
		     
			}catch(Exception e){ System.out.println(e);}
		
		return new ResponseEntity<>("Review is created successfully", HttpStatus.OK);
		
			}
	
	

@RequestMapping(value = "/retrievereview")
public  ResponseEntity<Object> Getreview(@RequestParam(value = "bookid", required = false, defaultValue = "3")long bookid) {
	
	try{ 
		List <BookReview> toreturn = new ArrayList <BookReview>();
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/geektextdb","root","wfan003@fiu");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, userid, rating, comment FROM ratings WHERE bookid = "+ bookid);
	    
		while (rs.next()) {
	    
	    	BookReview review = new BookReview(rs.getInt("id"), rs.getInt("userid"), 
	    			bookid, rs.getInt("rating"), rs.getString("comment"));
	    	
	    	toreturn.add(review);
	    }
		
	    con.close();
	    return new ResponseEntity<>(toreturn, HttpStatus.OK);
	     
		}catch(Exception e){ System.out.println(e);}
	
	return null;
	}

}
	
	

