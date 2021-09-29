public class Book {
    String name;
    int id;
    String bookRentedFrom;
    boolean status;

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

    public String getBookRentedFrom() {
        return bookRentedFrom;
    }

    public boolean getSatus() {
        return status;
    }



    public void setStatus(boolean status){
        this.status=status;
    }

    public void setBookRentedFrom(String bookRentedFrom){
        this.bookRentedFrom=bookRentedFrom;
    }
}
