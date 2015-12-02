<%-- 
    Document   : Manage
    Created on : Dec 1, 2015, 7:39:51 PM
    Author     : jeniferrhodes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CSC 330 Homework 4</title>
    <link rel ="stylesheet" href ="styles/main.css" type="text/css"/>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <%@ include file="/header.jsp" %>
<table>
  <tr>
    <th>Patron Name</th>
    <th>Email Address</th>
    <th>Book Title</th>
    <th>Due Date</th>
    <th>Overdue</th>
    <th></th>
  </tr>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="item" items="${cart.items}">
  <tr>
    <td><c:out value='${item.usercheckout.patronName}'/></td>
    <td>${item.usercheckout.email}</td>
    <td>${item.usercheckout.bookTitle}</td>
    <td>${item.usercheckout.strDate}</td>
    <td>${item.overdue}</td>
    <td>
      <form action="library" method="post">
        <input type="hidden" name="userID" 
               value="<c:out value='${item.userID}'/>">
        <input type="hidden" name="item" 
               value="<c:out value='${item}'/>">
         <input type="hidden" name="action" value="checkin">
        <input type="submit" value="Check in">
      </form>
    </td>
  </tr>
</c:forEach>
</table>

<a href="library?action=return" title="Return to front page" >Return to front page</a>


    </body>
    <%@ include file="/footer.jsp" %>
</html>
