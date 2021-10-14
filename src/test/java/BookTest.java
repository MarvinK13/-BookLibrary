
import model.Book;
import configuration.DatabaseConnection;
import repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private BookRepository repository = new BookRepository();
    private Book book1 = new Book(1, "20.000 Meilen unter dem Meer", "Jules Verne", 512);
    private Book book2 = new Book(2, "In 80 Tagen um die Welt", "Jules Verne", 320);
    private Book book3 = new Book(3, "In 80 Tagen um die Welt", "Jules Verne", 320);
    private Book book4 = new Book(4, "Eine kurze Geschichte der Menschheit", "Yuval Noah Harari", 580);
    private Book book5 = new Book(5, "Eine kurze Geschichte der Menschheit", "Yuval Noah Harari", 580);

    @Test
    public void addBook() {



        repository.addBook(book5);




    }

}

