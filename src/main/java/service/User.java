package service;

import model.Member;
import model.RentedBooks;
import repository.MemberRepository;
import repository.RentedAtRepository;

import java.util.List;

public class User {

    private RentedAtRepository repository = new RentedAtRepository();
    private MemberRepository repository2=new MemberRepository();

    public List<RentedBooks> rentBook(int bookId, int userId) {
        int checker=repository.findBookIdbyUser(bookId,userId);
        if(checker==0){
            RentedBooks rentedBooks = new RentedBooks(bookId, userId);
            repository.addRented(rentedBooks);
            List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);
            return rentedBooks1;
        }else{
            throw new IllegalBookException("You can`t rent a book more then once a DAY");
        }

    }

    public List<RentedBooks> giveBookBack(int bookId, int userId) {

        repository.giveBackRentedByBookId(bookId, userId);
        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooksByUserId(userId);

        return rentedBooks1;
    }

    public List<RentedBooks> getBooksById(int userId){
        List<RentedBooks> rentedBooks= repository.findAllRentedBooksByUserId(userId);
        return rentedBooks;

    }

    public Member updateNamebyId(int userId, String newName){
        repository2.updateNameById(userId,newName);
        Member member= repository2.findMemberById(userId);
        return member;

    }

//TODO: verlängern
    private List<RentedBooks> printBooks(List<RentedBooks> rentedBooks1) {
       return rentedBooks1;
    }
    private Member printMember(Member member){
        return member;
    }

}
