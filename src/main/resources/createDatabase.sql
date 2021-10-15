CREATE DATABASE bookLibrary;
USE bookLibrary;
CREATE TABLE books(bookId int PRIMARY KEY auto_increment,author varchar(50),title varchar(50),pages int,ISBN int);
CREATE TABLE members(name varchar(50),userId int PRIMARY KEY auto_increment);
CREATE TABLE rentedBooks(bookId int ,memberId int,rentedAt DATE,Foreign Key (bookId) References books(bookId),FOREIGN KEY (memberId) REFERENCES members(userId));
ALTER TABLE books AUTO_INCREMENT = 1;
ALTER TABLE members AUTO_INCREMENT = 1;


