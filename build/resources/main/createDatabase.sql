CREATE DATABASE bookLibrary;
USE bookLibrary;
CREATE TABLE books(bookId int PRIMARY KEY auto_increment,author varchar(50),title varchar(50),pages int,ISBN int);
CREATE TABLE members(name varchar(50),userId int PRIMARY KEY auto_increment);
CREATE TABLE rentedBooks(bookId int ,userId int ,rentedAt DATE,Foreign Key (bookId) References books(bookId),FOREIGN KEY (userId) REFERENCES members(userId),overdrawn ENUM('false', 'true') NOT NULL DEFAULT 'false',CONSTRAINT  PRIMARY KEY (bookId, userId, rentedAt));
ALTER TABLE books AUTO_INCREMENT = 1;
ALTER TABLE members AUTO_INCREMENT = 1;


