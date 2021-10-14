package model;

import java.sql.Date;
import java.time.LocalDate;

public class RentedBooks {
    private int bookId;
    private int memberId;
    private Date rentedAt;

    public RentedBooks(int bookId, int memberId){
        this.bookId=bookId;
        this.memberId=memberId;

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(Date rentedAt) {
        this.rentedAt = rentedAt;
    }
}
