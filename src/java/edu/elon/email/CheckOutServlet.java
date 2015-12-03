package edu.elon.email;

import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.elon.business.CheckoutCart;
import edu.elon.business.User;
import edu.elon.data.UserDB;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Processes requests made by the client using doget and dopost methods.
 * @author davidhan
 */

public class CheckOutServlet extends HttpServlet {
  /**
   * Processes requests made by the client for doget.
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException 
   */
   @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
      doPost(request,response);
    }
/**
 * Processes requests made by the clients for the dopost.
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
      try {
      // load the driver
      Class.forName("com.mysql.jdbc.Driver");

      // get a connection to local MySQL database. The database is
      // called murach. The database can be created by running the
      // create_database.sql file provided in Moodle. My suggestion for
      // simplicity is to modify the create_database.sql file to 
      // create a database with the same name as your database on
      // openshift and to then modify the next line of code to change
      // murach to your app name.
      String dbURL = "jdbc:mysql://localhost:3307/mvc";//should be mvc
      String username = "root";
      String password = "";

            //Determine if running on OpenShift by getting value of
      //OpenShift environement variable. If it is set (non null) then
      //we are and need to reset some variables. If no then no need to
      //reset and we are running locally.
      String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
      if ((host != null) && (host.trim().length() > 1)) {
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String appname = System.getenv("OPENSHIFT_APP_NAME");
        username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
      }

      Connection connection = DriverManager.getConnection(
        dbURL, username, password);

      HttpSession session = request.getSession();
        String url = "/CheckoutBook.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
           url = "/Home.jsp";
        }
        else if (action.equals("checkout")) {
           url = "/CheckoutBook.jsp";
        }
        else if (action.equals("add")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            String patronname = firstName +" " + lastName;       
            Calendar duedate= Calendar.getInstance();
            duedate.add(Calendar.DATE, 14);
            Date time = duedate.getTime();
            User user = new User(patronname,email,bookTitle,duedate);
            UserDB.insert(user);
            session.setAttribute("user", user);
            url = "/ThankYou.jsp";
        }
        else if (action.equals("manage")){
        try {
          String quantityString = request.getParameter("quantity");
          CheckoutCart cart = UserDB.getCheckoutList();
          request.setAttribute("cart", cart);
          url = "/Manage.jsp";
        } catch (SQLException ex) {
          System.out.println(ex);
        }
        }
        else if (action.equals("checkin")){
          try {
          String userID = request.getParameter("userID");
          CheckoutCart cart;
          cart = UserDB.getCheckoutList();
          request.setAttribute("cart", cart);
          UserDB.delete(userID);
          cart.removeItem(userID);
          url = "/Manage.jsp";
        } catch (SQLException ex) {
          Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if (action.equals("return")){
                  url = "/Home.jsp";
                  }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
      }
      catch (ClassNotFoundException e) {
    } catch (SQLException e) {
      
    }
        
    }    
}