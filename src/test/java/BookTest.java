import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void testGetStatus() {
        Book book=new Book("Isch, ein Roman", 2);

        book.setRented(true);
        Boolean ausgabe = book.isRented();

        assertEquals(true, ausgabe);
    }

}
