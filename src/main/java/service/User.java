package service;

import model.Member;
import model.RentedBooks;
import repository.RentedAtRepository;

import java.util.List;

public class User {

    public void rentBook(int bookId,int userId) {
        RentedBooks rentedBooks = new RentedBooks(bookId, userId);
        RentedAtRepository repository = new RentedAtRepository();
        repository.addRented(rentedBooks);
        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        System.out.println("##############################");
        System.out.println("The titles of all books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("##############################");
        System.out.println("");
    }

    public void giveBookBack(int bookId,int userId) {
        RentedBooks rentedBooks = new RentedBooks(bookId, userId);
        RentedAtRepository repository = new RentedAtRepository();
        repository.removeRentedByBookId(bookId, userId);

        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        System.out.println("##############################");
        System.out.println("The titles of all books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("##############################");
        System.out.println("");
    }
}
