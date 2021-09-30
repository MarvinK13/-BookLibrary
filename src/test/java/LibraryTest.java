import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void rentBookTest() {
        Library library = new Library();

        library.addMember("Jörg");
        library.addBook("Isch, ein Roman", 2);

        Map<Integer,Member> members =library.getMembers();
        Map<Integer,Book>books=library.getBooks();

        int id = library.findUserIdByName("Jörg");
        library.rentBook(id, 2);
        ArrayList<Integer> test = members.get(id).getBookList();

        assertEquals(2, test.get(0));
        assertEquals(true,books.get(2).isRented());
        assertEquals(id,books.get(2).getBookRentedFrom());
    }

    @Test
    public void giveBookBackTest() {
        Library library = new Library();

        library.addMember("Jörg");
        library.addBook("Isch, ein Roman", 2);

        Map<Integer,Member> members = library.getMembers();
       Map<Integer,Book>books= library.getBooks();

        int id = library.findUserIdByName("Jörg");
        library.rentBook(id, 2);
        library.giveBookBack(id,2);
        ArrayList<Integer> test = members.get(id).getBookList();

        assertEquals(true,test.isEmpty());
        assertEquals(false,books.get(2).isRented());
        assertEquals(0,books.get(2).getBookRentedFrom());
    }

}
