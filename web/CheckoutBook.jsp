<%-- 
    Document   : CheckoutBook
    Created on : Dec 1, 2015, 7:39:42 PM
    Author     : jeniferrhodes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSC 330 Homework 4</title>
    </head>
    <body>
        <h1>Checkout a book</h1>
        <form id="book-form" name="book-form" method="post" action="goelon">
            <input type="hidden" name="action" value="add">
        <p>
            <label for="FirstName"> First Name: </label>
            <input name="FirstName" type="text" id="FirstName" required/></p>
        <p>
            <label for="LastName"> Last Name: </label>
            <input name="LastName" type="text" id="LastName" required/></p>
        <p>
            <label for="Email"> Email: </label>
            <input name="Email" type="email" id="Email" required/></p>
        <p>
            <label for="BookTitle"> Book Title: </label>
            <input name="BookTitle" type="text" id="BookTitle" /></p>
        <input type="submit"  value="Checkout" id="checkout" name="checkout">
        </form>
    </body>
</html>
