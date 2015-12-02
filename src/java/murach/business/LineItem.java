package murach.business;

import java.io.Serializable;


public class LineItem implements Serializable {

    private UserCheckOut usercheckout;
    private String userID;
    private String overdue;

  
    public LineItem(UserCheckOut usercheckout, String userID,String overdue) {
        this.usercheckout = usercheckout;
        this.userID=userID;
        this.overdue=overdue;
    }

    public void setUsercheckout(UserCheckOut p) {
        usercheckout = p;
    }

    public UserCheckOut getUsercheckout() {
        return usercheckout;
    }

    public String getUserID() {
        return userID;
    }
    public void setUserID(String u) {
        userID = u;
    }
    public String getOverdue() {
        return overdue;
    }
    public void setOverdue(String u) {
        overdue = u;
    }

}