import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class test {
    @Test
    public void test() {
        Library serviceUnderTest = new Library();
        serviceUnderTest.addMember("Jörg");
        serviceUnderTest.addBook("Isch, ein Roman", 2);
        ArrayList<Book> books = serviceUnderTest.getBooks();
        ArrayList<Member> members = serviceUnderTest.getMembers();

    }
}
