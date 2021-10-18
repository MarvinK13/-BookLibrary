package repository;

import configuration.DatabaseConnection;
import model.RentedBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RentedAtRepository {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addRented(RentedBooks rentedBooks) {
        String sql = "INSERT INTO rentedBooks (bookId,userId,rentedAt)VALUES ((SELECT bookId from books Where bookId= ?),(SELECT userId from members Where userId= ?),'2021-07-13')";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, rentedBooks.getBookId());
            prepareStatement.setInt(2,rentedBooks.getUserId());

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
            prepareStatement.setString(1,overdrawn);
            prepareStatement.setInt(2, bookId);
            prepareStatement.setInt(3, userId);
            //prepareStatement.setDate(3,'2021-07-13');

            prepareStatement.executeUpdate();
            System.out.println("Finished Task");

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void removeRentedByBookId(int bookId,int userId) {
        String sql = "DELETE FROM rentedBooks WHERE bookId = ? AND userId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, bookId);
            prepareStatement.setInt(2, userId);
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


}
