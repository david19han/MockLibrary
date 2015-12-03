<%-- 
    Document   : Home
    Created on : Dec 1, 2015, 7:39:14 PM
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
    <div id="container">
      <%@ include file="/header.jsp" %>
      <div class = "redbox">
        <p><a href="library?action=checkout" title="Check Out" >Check out a book</a></p>
        <p><a href="library?action=manage">Manage checked out books</a></p>
      </div>
      <%@ include file="/footer.jsp" %>
    </div>
  </body>
</html>
