package edu.elon.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import edu.elon.business.CheckoutCart;
import edu.elon.business.LineItem;
import edu.elon.business.User;
import edu.elon.business.UserCheckOut;

public class UserDB {

    public static int insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO User (PatronName,EmailAddress,BookTitle, DueDate, Overdue) "
                + "VALUES (?, ?, ?, ?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getPatronName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getBookTitle());
            
            Calendar duedate = user.getDueDate();
            int year = duedate.get(Calendar.YEAR);
            int day = duedate.get(Calendar.DAY_OF_MONTH);
            int month = duedate.get(Calendar.MONTH) + 1;
            String sqldue = year + "-" + month + "-" + day;
            ps.setString(4,sqldue);
            ps.setString(5,user.getOverDue());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(String UserID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM User "
                + "WHERE UserID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,UserID);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static CheckoutCart getCheckoutList()
            throws SQLException{
      CheckoutCart cart = new CheckoutCart();
      ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM mvc2.User";
        try {
            ps = connection.prepareStatement(query);
            ResultSet results= ps.executeQuery(query);
            ResultSetMetaData metaData = results.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (results.next()){
              String userID=null;
              String patronname = null;
              String email = null;
              String booktitle=null;
              String duedate=null;
              String overdue=null;
            for (int i = 1; i <= columnCount; i++) { 
              if(i==1){
                userID = results.getString(i);
              } else if(i==2){
                patronname = results.getString(i);
              } else if(i==3){
                email = results.getString(i);
              } else if(i==4){
                booktitle = results.getString(i);
              } else if (i==5){
                duedate = results.getString(i);
              } else{
                overdue = results.getString(i);
              }
            }
            UserCheckOut user = new UserCheckOut(patronname,email,booktitle, duedate);
            LineItem lineitem = new LineItem(user,userID,overdue);
            cart.addItem(lineitem);
            }
            return cart;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}