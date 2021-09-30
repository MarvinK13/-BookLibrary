import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(String name, int id) {
        books.add(new Book(name, id));
    }

    public void removeBook(int id) {
        for (Book element : books) {
            if (element.getId() == id) {
                books.remove(element);
            }
        }
    }

    public void addMember(String name) {
        members.add(new Member(name, idGenerator()));
    }

    public void removeMember(int id) {
        for (Member element : members) {
            if (element.getId() == id) {
                members.remove(element);
            }
        }
    }

    public void rentBook(int memberid, int bookid) {
        for (Member memberelement : members) {
            if (memberelement.getId()==memberid) {
                memberelement.addBookToList(bookid);

            }
        }
        for (Book bookElement : books) {
            if (bookElement.getId() == bookid) {
                bookElement.setBookRentedFrom(memberid);
                bookElement.setStatus(true);
            }
        }
    }

    public void giveBookback(int memberid, int bookid) {
        for (Member memberelement : members) {
            if (memberelement.getId()==memberid) {
                memberelement.removeBookFromList(memberelement.getPositionOfBook(bookid));
            }

        }
        for (Book bookElement : books) {
            if (bookElement.getId() == bookid) {
                bookElement.setBookRentedFrom(0);
                bookElement.setStatus(false);
            }
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
        for (Book bookElement : books) {
            nameBook = bookElement.getName();
            id = bookElement.getBookRentedFrom();
            status = bookElement.getStatus();
            System.out.println("=> " + nameBook + " geliehen von: " + id + " Status: " + status);
        }
        System.out.println("Members: ");
        for (Member memberElement : members) {
            nameMember = memberElement.getName();
            System.out.println("=> " + nameMember);
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public int giveIdFromUsers(String name) {
        for (Member element : members) {
            if (element.getName().equals(name)) {
                return element.getId();
            }
        }
        return 0;
    }

}

