import model.Member;
import model.Book;
import service.Admin;
import service.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Admin admin=new Admin();
       User user=new User();
       user.rentBook(1,1);

       //admin.seeRentedBooks();

    }

    private static void printBook(Book book) {
        System.out.println("==============================");
        System.out.println("Found this book: ");
        System.out.println("");

        System.out.println(book);

        System.out.println("==============================");
        System.out.println("");
    }

    private static void printBooks(List<Book> books) {
        System.out.println("==============================");
        System.out.println("List of books: ");
        System.out.println("");

        books.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }

    private static void printMembers(List<Member> members) {
        System.out.println("==============================");
        System.out.println("List of members: ");
        System.out.println("");

        members.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }

    private static void printTitles(List<String> titles) {
        System.out.println("==============================");
        System.out.println("The titles of all books are: ");
        System.out.println("");

        titles.forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("");
    }
}
