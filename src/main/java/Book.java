public class Book {
    private String name;
    private int id;
    private int bookRentedFrom;
    private boolean status;

    Book(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBookRentedFrom() {
        return bookRentedFrom;
    }

    public boolean isRented() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBookRentedFrom(int bookRentedFrom) {
        this.bookRentedFrom = bookRentedFrom;
    }
}
