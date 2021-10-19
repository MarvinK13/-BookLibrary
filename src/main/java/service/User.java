package service;

import model.Member;
import model.RentedBooks;
import repository.RentedAtRepository;

import java.util.List;

public class User {

    private RentedAtRepository repository = new RentedAtRepository();

    public void rentBook(int bookId,int userId) {
        RentedBooks rentedBooks = new RentedBooks(bookId, userId);
        repository.addRented(rentedBooks);
        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        System.out.println("==============================");
        System.out.println("The titles of your books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }

    public void giveBookBack(int bookId,int userId) {
        RentedBooks rentedBooks = new RentedBooks(bookId, userId);
        repository.removeRentedByBookId(bookId, userId);

        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        System.out.println("==============================");
        System.out.println("The titles of your books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }
}
