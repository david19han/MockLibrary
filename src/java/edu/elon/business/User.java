package edu.elon.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * User bean class that stores information on patron name, email address, book 
 * title, due date.
 * @author davidhan
 */
public class User implements Serializable {
    private String patronName;
    private String emailAddress;
    private String bookTitle;
    private Calendar dueDate;
    
    public User() {
        patronName = "";
        emailAddress = "";
        bookTitle = "";
        dueDate = null;
        
    }

    public User(String patronName, String emailAddress, String bookTitle,Calendar dueDate) {
        this.patronName = patronName;
        this.emailAddress = emailAddress;
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
    }
/**
 * Getter method for email.
 * @return 
 */
    public String getEmail() {
        return emailAddress;
    }
/**
 * Setter method for email.
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
 * Getter method for due date.
 * @return 
 */
    public Calendar getDueDate() {
        return dueDate;
    }
/**
 * Setter method for due date.
 * @param dueDate 
 */
    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }
/**
 * Getter method for determining if book is overdue or not.
 * @return 
 */
    public String getOverDue() {
        int diff = dueDate.compareTo(Calendar.getInstance());
        String overdue;
        if(diff<0){
        overdue = "overdue";
        }else{
          overdue="";
        } 
        return overdue;
    }
/**
 * Getter method for due date of book in string format.
 * @return 
 */
    public String getStrDueDate(){
            int year = dueDate.get(Calendar.YEAR);
            int day = dueDate.get(Calendar.DAY_OF_MONTH);
            int month = dueDate.get(Calendar.MONTH) + 1;
            String sqldue = month + "-" + day + "-" + year;
            return sqldue;
    }
}
