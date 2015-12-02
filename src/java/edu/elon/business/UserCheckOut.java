package edu.elon.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getStrDate() {
        return strdate;
    }
    public void setStrDate(String strdate) {
        this.strdate = strdate;
    }
}
/*
    public String getDueDate(){
        return dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public String getOverDue(){
        return dueDate;
    }

    public void setOverDue(String overDue){
        this.overDue = overDue;
    }
    */
