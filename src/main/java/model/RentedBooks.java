package model;

import java.sql.Date;

public class RentedBooks {
    private int bookId;
    private int userId;
    private Date rentedAt;
    private String overdrawn;

    public RentedBooks(int bookId, int memberId) {
        this.bookId = bookId;
        this.userId = memberId;

    }

    public RentedBooks() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(Date rentedAt) {
        this.rentedAt = rentedAt;
    }

    public String getOverdrawn() {
        return overdrawn;
    }

    public void setOverdrawn(String overdrawn) {
        this.overdrawn = overdrawn;
    }

    @Override
    public String toString() {
        return "Book= " +
                "bookId= " + bookId +
                "| userId= '" + userId + '\'' +
                "| rentedAt= '" + rentedAt + '\'' +
                "| overdrawn= " + overdrawn;
    }
}
