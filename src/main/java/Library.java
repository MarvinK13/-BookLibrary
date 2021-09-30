import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer,Book> books = new HashMap();
    private Map<Integer,Member> members = new HashMap();

    public void addBook(String name, int id) {
        books.put(id,new Book(name, id));
    }

    public void removeBook(int id) {
            if (books.containsKey(id)) {
                books.remove(id);
            }
    }

    public void addMember(String name) {
        int id=idGenerator();
        members.put(id,new Member(name,id));
    }

    public void removeMember(int id) {
            if (members.containsKey(id)) {
                members.remove(id);
            }
    }

    public void rentBook(int memberId, int bookId) {
            if (members.containsKey(memberId)) {
                members.get(memberId).addBookToList(bookId);

            }
            if (books.containsKey(bookId)) {
                books.get(bookId).setBookRentedFrom(memberId);
                books.get(bookId).setRented(true);
            }
    }

    public void giveBookBack(int memberId, int bookId) {
            if (members.containsKey(memberId)) {
                members.get(memberId).removeBookFromList(bookId);
            }
            if (books.containsKey(bookId)) {
                books.get(bookId).setBookRentedFrom(0);
                books.get(bookId).setRented(false);
            }
    }

    private int idGenerator() {
        return (int) (Math.random() * 10000000);
    }

    public void printMembersAndBooks() {
        String nameMember;
        String nameBook;
        int id;
        boolean status;

        System.out.println("\nBooks: ");
        for (Book bookElement : books.values()) {
            nameBook = bookElement.getName();
            id = bookElement.getBookRentedFrom();
            status = bookElement.isRented();
            System.out.println("=> " + nameBook + " geliehen von: " + id + " Status: " + status);
        }
        System.out.println("Members: ");
        for (Member memberElement : members.values()) {
            nameMember = memberElement.getName();
            System.out.println("=> " + nameMember);
        }
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<Integer, Member> getMembers() {
        return members;
    }

    public int findUserIdByName(String name) {
        for (Member element : members.values()) {
            if (element.getName().equals(name)) {
                return element.getId();
            }
        }
        return 0;
    }

}

