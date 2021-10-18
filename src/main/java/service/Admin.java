package service;

import model.Book;
import model.Member;
import model.RentedBooks;
import repository.BookRepository;
import repository.MemberRepository;
import repository.RentedAtRepository;

import java.util.List;

public class Admin {
    public void addBook(String author,String title,int pages,int ISBN ) {
        Book book = new Book(author, title, pages, ISBN);
        BookRepository repo = new BookRepository();
        repo.addBook(book);
        List<Book> books = repo.findAllBooks();

        System.out.println("##############################");
        System.out.println("List of books: ");
        System.out.println("");

        books.forEach(System.out::println);

        System.out.println("##############################");
        System.out.println("");
    }

    public void addMember(String name) {
        Member member = new Member(name);
        MemberRepository repo2 = new MemberRepository();
        repo2.addMember(member);
        List<Member> members = repo2.findAllMembers();

        System.out.println("##############################");
        System.out.println("List of members: ");
        System.out.println("");

        members.forEach(System.out::println);

        System.out.println("##############################");
        System.out.println("");
    }

    public void seeRentedBooks() {
        RentedBooks rentedBooks = new RentedBooks();
        RentedAtRepository repository = new RentedAtRepository();

        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooks();

        System.out.println("##############################");
        System.out.println("The titles of all books are: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("##############################");
        System.out.println("");
    }

    public void setOverDrawnBook(int bookId,int memberId,String overdrawn) {

        RentedBooks rentedBooks = new RentedBooks(bookId, memberId);
        RentedAtRepository repository = new RentedAtRepository();
        repository.modifyOverDrawn(bookId, memberId, overdrawn);

        List<RentedBooks> rentedBooks1 = repository.findAllRentedBooks();

        System.out.println("##############################");
        System.out.println("List of books: ");
        System.out.println("");

        rentedBooks1.forEach(System.out::println);

        System.out.println("##############################");
        System.out.println("");
    }
}
