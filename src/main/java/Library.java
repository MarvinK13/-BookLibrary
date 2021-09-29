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

    public void removeMember(String id) {
        for (Member element : members) {
            if (element.getId() == id) {
                members.remove(element);
            }
        }
    }

    public void rentBook(String memberid, int bookid) {
        for (Member memberelement : members) {
            if (memberelement.getId() == memberid) {
                memberelement.setBooks(bookid);

                for (Book bookElement : books) {
                    if (bookElement.getId() == bookid) {
                        bookElement.setBookRentedFrom(memberid);
                        bookElement.setStatus(true);
                    }
                }
            }
        }
    }

    public void giveBookback(String memberid, int bookid) {
        for (Member memberelement : members) {
            if (memberelement.getId() == memberid) {
                memberelement.removeBook(bookid);

                for (Book bookElement : books) {
                    if (bookElement.getId() == bookid) {
                        bookElement.setBookRentedFrom(null);
                        bookElement.setStatus(false);
                    }
                }
            }
        }
    }

    private String idGenerator() {
        String id = "";
        int random;
        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * 9);
            id = id + random;
        }
        return id;
    }

    public void printMembersAndBooks() {
        String nameMember;
        String nameBook;

        for (Book bookElement : books) {
            nameBook = bookElement.getName();
            System.out.println("Book: " + nameBook+" "+bookElement.getBookRentedFrom());
        }
        for (Member memberElement : members) {
            nameMember = memberElement.getName();
            System.out.println("Member: " + nameMember);
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public String giveName(String name){
        for (Member element : members) {
            if (element.getName().equals(name)) {
                return element.getId();
            }
        }
        return null;
    }

}

