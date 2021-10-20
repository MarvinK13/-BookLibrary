package repository;

import configuration.DatabaseConnection;
import model.RentedBooks;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class RentedAtRepository {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addRented(RentedBooks rentedBooks) {
        String sql = "INSERT INTO rentedBooks (bookId,userId,rentedAt,overdrawn,givenBack)VALUES ((SELECT bookId from books Where bookId= ?),(SELECT userId from members Where userId= ?),?,?,null)";
        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            Calendar calender= Calendar.getInstance();
            Date now=calender.getTime();
            calender.add(Calendar.DAY_OF_YEAR,14);
            Date calenderTime = calender.getTime();
            Timestamp endDate=new Timestamp(calenderTime.getTime());

            prepareStatement.setInt(1, rentedBooks.getBookId());
            prepareStatement.setInt(2,rentedBooks.getUserId());
            prepareStatement.setTimestamp(3,new Timestamp(now.getTime()));
            prepareStatement.setTimestamp(4,endDate);

            prepareStatement.executeUpdate();
            System.out.println("Finished Task");

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void modifyOverDrawn(int bookId,int userId,String overdrawn) {
        String sql = "UPDATE rentedBooks SET overdrawn= ? WHERE bookId = ? AND userId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            Calendar calender= Calendar.getInstance();
            calender.add(Calendar.DAY_OF_YEAR,7);
            Date calenderTime = calender.getTime();
            Timestamp endDate=new Timestamp(calenderTime.getTime());

            prepareStatement.setTimestamp(1,endDate);
            prepareStatement.setInt(2, bookId);
            prepareStatement.setInt(3, userId);

            prepareStatement.executeUpdate();
            System.out.println("Finished Task");

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void giveBackRentedByBookId(int bookId, int userId) {
        String sql = "UPDATE rentedBooks SET givenBack= ? WHERE bookId = ? AND userId = ?";
        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            Calendar calender= Calendar.getInstance();
            Date now=calender.getTime();
            prepareStatement.setTimestamp(1,new Timestamp(now.getTime()));
            prepareStatement.setInt(2, bookId);
            prepareStatement.setInt(3, userId);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

    }

    public List<RentedBooks> findAllRentedBooks() {
        String sql = "SELECT * FROM rentedBooks";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
             ResultSet resultSet = prepareStatement.executeQuery();
        ) {
            List<RentedBooks> rentedBooks = new LinkedList<>();
            while (resultSet.next()) {
                RentedBooks rentedBook = new RentedBooks();
                rentedBook.setBookId(resultSet.getInt("bookId"));
                rentedBook.setUserId(resultSet.getInt("userId"));
                rentedBook.setRentedAt(resultSet.getDate("rentedAt"));
                rentedBook.setOverdrawn(resultSet.getString("overdrawn"));
                rentedBooks.add(rentedBook);
            }
            return rentedBooks;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

        return null;
    }

    public List<RentedBooks> findAllRentedBooksByUserId(int id) {
        String sql = "SELECT * FROM rentedBooks WHERE userId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<RentedBooks> rentedBooks = new LinkedList<>();
            while (resultSet.next()) {
                RentedBooks rentedBook = new RentedBooks();
                rentedBook.setBookId(resultSet.getInt("bookId"));
                rentedBook.setUserId(resultSet.getInt("userId"));
                rentedBook.setOverdrawn(resultSet.getString("overdrawn"));
                rentedBook.setRentedAt(resultSet.getDate("rentedAt"));
                rentedBooks.add(rentedBook);
            }
            return rentedBooks;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

        return null;
    }

    public List<RentedBooks> findAllRentedBooksByBookId(int id) {
        String sql = "SELECT * FROM rentedBooks WHERE bookId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<RentedBooks> rentedBooks = new LinkedList<>();
            while (resultSet.next()) {
                RentedBooks rentedBook = new RentedBooks();
                rentedBook.setBookId(resultSet.getInt("bookId"));
                rentedBook.setUserId(resultSet.getInt("userId"));
                rentedBook.setOverdrawn(resultSet.getString("overdrawn"));
                rentedBooks.add(rentedBook);
            }
            return rentedBooks;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

        return null;
    }

    public int findBookIdbyUser(int bookId,int userId) {
        String sql = "SELECT Count(*) FROM rentedBooks WHERE userId = ? AND bookId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, userId);
            prepareStatement.setInt(2, bookId);
            ResultSet resultSet = prepareStatement.executeQuery();

            resultSet.next();
            int id = resultSet.getInt("Count(*)");
            resultSet.close();
            return id;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return 0;
    }


}
