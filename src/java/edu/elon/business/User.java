package edu.elon.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
    private String patronName;
    private String emailAddress;
    private String bookTitle;
    private Calendar dueDate;
    private String strDueDate;
/*
    private String dueDate;
    private String overDue;
*/
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
    public Calendar getDueDate() {
        return dueDate;
    }
    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }
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
    public String getStrDueDate(){
            int year = dueDate.get(Calendar.YEAR);
            int day = dueDate.get(Calendar.DAY_OF_MONTH);
            int month = dueDate.get(Calendar.MONTH) + 1;
            String sqldue = month + "-" + day + "-" + year;
            return sqldue;
    }
}
