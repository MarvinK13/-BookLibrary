package service;

import model.Book;
import model.Member;
import model.RentedBooks;
import repository.BookRepository;
import repository.MemberRepository;
import repository.RentedAtRepository;

import java.sql.Timestamp;
import java.util.List;

public class Admin {

    private BookRepository repo = new BookRepository();
    private MemberRepository repo2 = new MemberRepository();
    private RentedAtRepository repository = new RentedAtRepository();

    public List<Book> addBook(String author, String title, int pages, int ISBN) {
        Book book = new Book(author, title, pages, ISBN);

        repo.addBook(book);
        List<Book> books = repo.findAllBooks();

        return books;
    }

    public List<Member> addMember(String name, String email, Timestamp birthday) {
        Member member = new Member(name, email, birthday);
        repo2.addMember(member);
        List<Member> members = repo2.findAllMembers();

        return members;
    }

    public List<Member> removeMember(int userId) {
        repo2.removeMemberById(userId);
        List<Member> members = repo2.findAllMembers();

        return members;
    }

    public List<RentedBooks> seeRentedBooks() {
        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooks();
        return rentedBooks1;
    }

    public List<Book> seeallBooks() {
        List<Book> rentedBooks1 = repo.findAllBooks();
        return rentedBooks1;
    }

    public List<RentedBooks> setOverDrawnBook(int bookId, int memberId, String overdrawn) {

        RentedBooks rentedBooks = new RentedBooks(bookId, memberId);
        repository.modifyOverDrawn(bookId, memberId, overdrawn);

        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooks();

        return rentedBooks1;
    }
    //TODO: kaputte bücher kaufen ,adim unendlich ausleihen
}
