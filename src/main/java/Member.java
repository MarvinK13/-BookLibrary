import java.util.ArrayList;

public class Member {
    private String name;
    private int id;
    private ArrayList<Integer> books = new ArrayList<>();

    Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public ArrayList<Integer> getBooks() {
        return books;
    }

    public void addBookToList(int id) {
        books.add(id);
    }

    public int getId() {
        return id;
    }

    //muss überarbeitet werden
    public void removeBookFromList(int id) {
        int pos=getPositionOfBook(id);
        books.remove(pos);
    }

    public String getName() {
        return name;
    }

    private int getPositionOfBook(int id) {
        int pos = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.contains(id)) {
                pos = i;
            }
        }
        return pos;
    }
}
