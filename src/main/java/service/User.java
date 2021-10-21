package service;

import model.Member;
import model.RentedBooks;
import repository.MemberRepository;
import repository.RentedAtRepository;

import java.util.List;

public class User {

    private RentedAtRepository repository = new RentedAtRepository();
    private MemberRepository repository2=new MemberRepository();

    public void rentBook(int bookId, int userId) {
        int checker=repository.findBookIdbyUser(bookId,userId);
        if(checker==0){
            RentedBooks rentedBooks = new RentedBooks(bookId, userId);
            repository.addRented(rentedBooks);
            List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);
            printBooks(rentedBooks1);
        }else{
            throw new IllegalBookException("You can`t rent a book more then once a DAY");
        }

    }

    public void giveBookBack(int bookId, int userId) {

        repository.giveBackRentedByBookId(bookId, userId);
        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        printBooks(rentedBooks1);
    }

    public void getBooksById(int userId){
        List<RentedBooks> rentedBooks= repository.findAllRentedBooksByUserId(userId);
        printBooks(rentedBooks);

    }

    public void updateNamebyId(int userId,String newName){
        repository2.updateNameById(userId,newName);
        Member member= repository2.findMemberById(userId);
        printMember(member);

    }

//TODO: verlängern
    private void printBooks(List<RentedBooks> rentedBooks1) {
        System.out.println("==============================");
        System.out.println("The titles of your books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }
    private void printMember(Member member){
        System.out.println("==============================");
        System.out.println("The titles of your books are: ");
        System.out.println("");

        System.out.println(member);

        System.out.println("==============================");
        System.out.println("");
    }

}
