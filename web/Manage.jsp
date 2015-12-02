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
    <link rel ="stylesheet" href ="styles/mainmurach.css" type="text/css"/>        
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
  
  </tr>
</c:forEach>
</table>

<form action="" method="post">
  <input type="hidden" name="action" value="shop">
  <input type="submit" value="Return to front page">
</form>

    </body>
    <%@ include file="/footer.jsp" %>
</html>
