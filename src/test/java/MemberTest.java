import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTest {
    @Test
    public void testgetName() {
        Library serviceUnderTest = new Library();
        ArrayList<Member> members = serviceUnderTest.getMembers();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        String ausgabe = members.get(0).getName();

        assertEquals("Jörg", ausgabe);
    }

    @Test
    public void testgetId() {
        Library serviceUnderTest = new Library();
        ArrayList<Member> members = serviceUnderTest.getMembers();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        String id=serviceUnderTest.giveIdFromUsers("Jörg");
        serviceUnderTest.rentBook(id,2);
        int ausgabe = members.get(0).getPositionOfBook(2);

        assertEquals(0, ausgabe);
    }

    @Test
    public void testgetBooks() {
        Library serviceUnderTest = new Library();
        ArrayList<Member> members = serviceUnderTest.getMembers();

        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        String id=serviceUnderTest.giveIdFromUsers("Jörg");
        serviceUnderTest.rentBook(id,2);
        ArrayList<Integer> books = members.get(0).getBooks();

        assertEquals(2, books.get(0));
    }
}
