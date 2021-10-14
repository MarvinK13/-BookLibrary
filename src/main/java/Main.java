import model.Member;
import repository.BookRepository;
import model.Book;
import repository.MemberRepository;

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



    }
}
