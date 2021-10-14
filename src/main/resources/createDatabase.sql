CREATE DATABASE bookLibrary;
USE bookLibrary;
CREATE TABLE books(bookId int PRIMARY KEY auto_increment,author char,title char,pages int,ISBN int);
CREATE TABLE members(name char,userId int PRIMARY KEY auto_increment);
CREATE TABLE rentedBooks(bookId int,memberId int,rentedAt DATE);
ALTER Table rentedBooks Add Foreign Key (bookId) References books(bookId);
Alter Table rentedBooks ADD FOREIGN KEY (memberId) REFERENCES members(userId);
ALTER TABLE books AUTO_INCREMENT = 1;
ALTER TABLE members AUTO_INCREMENT = 1;


