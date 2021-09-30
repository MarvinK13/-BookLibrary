import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void testGetStatus() {
        Library serviceUnderTest = new Library();
        ArrayList<Member> members = serviceUnderTest.getMembers();
        ArrayList<Book> books = serviceUnderTest.getBooks();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        int id = members.get(0).getId();
        serviceUnderTest.rentBook(id, 2);
        Boolean ausgabe = books.get(0).getStatus();

        assertEquals(true, ausgabe);
    }

    @Test
    public void testBookRentedFrom() {
        Library serviceUnderTest = new Library();
        ArrayList<Member> members = serviceUnderTest.getMembers();
        ArrayList<Book> books = serviceUnderTest.getBooks();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        int id = members.get(0).getId();
        serviceUnderTest.rentBook(id, 2);
        int ausgabe = books.get(0).bookRentedFrom;

        assertEquals(id, ausgabe);
    }

    @Test
    public void testBookGetName() {
        Library serviceUnderTest = new Library();
        ArrayList<Book> books = serviceUnderTest.getBooks();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        String ausgabe = books.get(0).getName();

        assertEquals("Isch, ein Roman", ausgabe);
    }

    @Test
    public void testBookGetId() {
        Library serviceUnderTest = new Library();
        ArrayList<Book> books = serviceUnderTest.getBooks();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        int ausgabe = books.get(0).getId();

        assertEquals(2, ausgabe);
    }

    @Test
    public void testBookGetStatus() {
        Library serviceUnderTest = new Library();
        ArrayList<Book> books = serviceUnderTest.getBooks();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        boolean ausgabe = books.get(0).getStatus();

        assertEquals(false, ausgabe);
    }
}
