DROP DATABASE mvc2;
CREATE DATABASE IF NOT EXISTS mvc2;
USE mvc2;

DROP TABLE IF EXISTS User;

CREATE TABLE User (
  UserID INT NOT NULL AUTO_INCREMENT,
  PatronName VARCHAR(50),
  EmailAddress VARCHAR(50),
  BookTitle VARCHAR(50),
  DueDate DATE,
  Overdue VARCHAR(50),
  PRIMARY KEY(UserID) 
);