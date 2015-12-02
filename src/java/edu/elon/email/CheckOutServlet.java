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

public class CheckOutServlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
      doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
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
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");

            String patronname = firstName +" " + lastName;
            
            Calendar duedate= Calendar.getInstance();
            duedate.add(Calendar.DATE, 14);
            Date time = duedate.getTime();
            // store data in User object
            User user = new User(patronname,email,bookTitle,duedate);
            // validate the parameters
            UserDB.insert(user);
            session.setAttribute("user", user);
            url = "/ThankYou.jsp";
        }
        else if (action.equals("manage")){
        try {
          
          String quantityString = request.getParameter("quantity");
          //int quantity = Integer.parseInt(quantityString);
          CheckoutCart cart = UserDB.getCheckoutList();
          request.setAttribute("cart", cart);
          //if (quantity == 0) {
            //  cart.removeItem(lineItem);
            //}
          
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
}