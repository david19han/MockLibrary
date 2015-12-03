package edu.elon.business;

import java.io.Serializable;

/**
 * LineItem bean that stores the usercheckout bean, userID from database, and 
 * whether or not book is overdue.
 * @author davidhan
 */
public class LineItem implements Serializable {

    private UserCheckOut usercheckout;
    private String userID;
    private String overdue;

  
    public LineItem(UserCheckOut usercheckout, String userID,String overdue) {
        this.usercheckout = usercheckout;
        this.userID=userID;
        this.overdue=overdue;
    }
/**
 * Setter method for usercheckout.
 * @param p 
 */
    public void setUsercheckout(UserCheckOut p) {
        usercheckout = p;
    }
/**
 * Getter method for usercheckout.
 * @return 
 */
    public UserCheckOut getUsercheckout() {
        return usercheckout;
    }
/**
 * Getter method for userID.
 * @return 
 */
    public String getUserID() {
        return userID;
    }
/**
 * Setter method for userID.
 * @param u 
 */
    public void setUserID(String u) {
        userID = u;
    }
/**
 * Getter method for overdue or not.
 * @return 
 */
    public String getOverdue() {
        return overdue;
    }
/**
 * Setter method for overdue or not.
 * @param u 
 */
    public void setOverdue(String u) {
        overdue = u;
    }
}