<%-- 
    Document   : ThankYou
    Created on : Dec 1, 2015, 7:39:58 PM
    Author     : jeniferrhodes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CSC 330 Homework 4</title>
    <link rel ="stylesheet" href ="styles/main.css" type="text/css"/>
  </head>
  <div id="container">
    <body>
      <%@ include file="/header.jsp" %>
      <div class="redbox">
        <p> Thank you for your patronage of the Belk Library.  You've
          successfully checked out the book, ${user.bookTitle}. Please note that this book
          is due back on ${user.strDueDate}.  A friendly email reminder will be sent to you
          if your book becomes overdue.
        </p><br>

        <p><a href='Home.jsp' title='Return to front page'>Return to front
            page</a></p>
      </div>
      <%@ include file="/footer.jsp" %>
  </div>
</body>
</html>
