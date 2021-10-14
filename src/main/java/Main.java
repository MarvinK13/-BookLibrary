import model.Member;
import model.RentedBooks;
import repository.BookRepository;
import model.Book;
import repository.MemberRepository;
import repository.RentedAtRepository;

public class Main {
    public static void main(String[] args) {
        Book book=new Book("Moin","Moin",1,1234);
        BookRepository repo=new BookRepository();
        //repo.addBook(book);
        //repo.removeBookById(1);

        Member member=new Member("Moin");
        MemberRepository repo2=new MemberRepository();
        //repo2.addMember(member);
        //repo2.removeMemberById(1);

        RentedBooks rentedBooks=new RentedBooks(2,1);
        RentedAtRepository repository=new RentedAtRepository();
        repository.addRented(rentedBooks);
        //repository.removeRentedByBookId(1);



    }
}
