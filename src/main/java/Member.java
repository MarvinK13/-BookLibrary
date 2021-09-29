import java.util.ArrayList;

public class Member {
    String name;
    String id;
    ArrayList<Integer> books = new ArrayList<>();

    Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public ArrayList<Integer> getBooks() {
        return books;
    }

    public void setBooks(int id) {
        books.add(id);
    }

    public String getId() {
        return id;
    }

    public void removeBook(int id) {
        books.remove(id);
    }

    public String getName() {
        return name;
    }
}
