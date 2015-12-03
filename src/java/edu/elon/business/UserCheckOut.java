package edu.elon.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Creates a UserCheckOut Bean that is very similar to User bean but allows for 
 * due date to be a string instead of calendar.
 * @author davidhan
 */
public class UserCheckOut implements Serializable {
    private String patronName;
    private String emailAddress;
    private String bookTitle;
    private String strdate;
/*
    private String dueDate;
    private String overDue;
*/
    public UserCheckOut() {
        patronName = "";
        emailAddress = "";
        bookTitle = "";
        strdate = "";
/*        
        dueDate = "";
        overDue = "";
 */       
    }
    public UserCheckOut(String patronName, String emailAddress, String bookTitle,String strdate) {
        this.patronName = patronName;
        this.emailAddress = emailAddress;
        this.bookTitle = bookTitle;
        this.strdate = strdate;
/*       
        this.dueDate = dueDate;
        this.overDue = overDue;
        */
    }
/**
 * Getter method for email address.
 * @return 
 */
    public String getEmail() {
        return emailAddress;
    }
/**
 * Setter method for email address
 * @param emailAddress 
 */
    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }
/**
 * Getter method for patron name.
 * @return 
 */
    public String getPatronName() {
        return patronName;
    }
/**
 * Setter method for patron name.
 * @param patronName 
 */
    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }
/**
 * Getter method for book title.
 * @return 
 */
    public String getBookTitle() {
        return bookTitle;
    }
/**
 * Setter method for book title.
 * @param bookTitle 
 */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
/**
 * Getter method for the due date string.
 * @return 
 */
    public String getStrDate() {
        return strdate;
    }
/**
 * Setter method for the due date string.
 * @param strdate 
 */
    public void setStrDate(String strdate) {
        this.strdate = strdate;
    }
    
    public String getConvertStrDate(){
      String year = Character.toString(strdate.charAt(0)) + 
              Character.toString(strdate.charAt(1)) + 
              Character.toString(strdate.charAt(2)) +
              Character.toString(strdate.charAt(3));
      String month = Character.toString(strdate.charAt(5)) + 
              Character.toString(strdate.charAt(6));
      String day = Character.toString(strdate.charAt(8)) + 
              Character.toString(strdate.charAt(9));
      String newdate = month + "-" + day + "-" + year;
      return newdate;
    }
}