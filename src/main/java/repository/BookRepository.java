package repository;

import model.Book;

import configuration.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRepository {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public BookRepository() {

    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books(author,title,pages,ISBN) VALUES(?,?,?,?)";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setString(1, book.getAuthor());
            prepareStatement.setString(2, book.getTitle());
            prepareStatement.setInt(3, book.getPages());
            prepareStatement.setInt(4, book.getISBN());
            prepareStatement.executeUpdate();
            System.out.println("Finished Task");

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void removeBookById(int id) {
        String sql = "DELETE FROM books WHERE bookId = ?";

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

