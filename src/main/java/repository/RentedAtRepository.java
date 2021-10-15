package repository;

import configuration.DatabaseConnection;
import model.RentedBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentedAtRepository {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addRented(RentedBooks rentedBooks) {
        String sql = "INSERT INTO rentedBooks (bookId,memberId,rentedAt)VALUES ((SELECT bookId from books Where bookId= ?),(SELECT userId from members Where userId= ?),'2021-07-13')";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, rentedBooks.getBookId());
            prepareStatement.setInt(2,rentedBooks.getMemberId());
            //prepareStatement.setDate(3,'2021-07-13');

            prepareStatement.executeUpdate();
            System.out.println("Finished Task");

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void removeRentedByBookId(int id) {
        String sql = "DELETE FROM rentedBooks WHERE bookId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

    }

}
