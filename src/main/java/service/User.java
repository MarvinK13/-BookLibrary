package service;

import model.RentedBooks;
import repository.RentedAtRepository;

import java.util.List;

public class User {

    private RentedAtRepository repository = new RentedAtRepository();

    public void rentBook(int bookId, int userId) {
        //TODO: check ob ausgeliehen
        int checker=repository.findBookIdbyUser(bookId,userId);
        if(checker==0){
            RentedBooks rentedBooks = new RentedBooks(bookId, userId);
            repository.addRented(rentedBooks);
            List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);
            printBooks(rentedBooks1);
        }else{
            throw new IllegalBookException("You can`t rent a book more then once");
        }

    }

    public void giveBookBack(int bookId, int userId) {
        RentedBooks rentedBooks = new RentedBooks(bookId, userId);
        repository.giveBackRentedByBookId(bookId, userId);
        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        printBooks(rentedBooks1);
    }

//TODO: user can change name
//TODO: alle bücher ausgeben ,verlängern
    private void printBooks(List<RentedBooks> rentedBooks1) {
        System.out.println("==============================");
        System.out.println("The titles of your books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }
}
