public class Book {
    private String name;
    private int id;
    private int bookRentedFrom;
    private boolean isRented;

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
        return isRented;
    }

    public void setRented(boolean rented) {
        this.isRented = rented;
    }

    public void setBookRentedFrom(int memberId) {
        this.bookRentedFrom = memberId;
    }
}
