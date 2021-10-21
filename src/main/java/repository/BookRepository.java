package repository;

import model.Book;

import configuration.DatabaseConnection;
import service.IllegalBookException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public String findTitleByBookId(int id) {
        String sql = "SELECT title FROM books WHERE bookId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            resultSet.next();
            String title = resultSet.getString("title");
            resultSet.close();
            return title;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return null;
    }

    public List<Book> findBooksByTitle(String title) {
        String sql = "SELECT * FROM books WHERE title = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setString(1, title);
            ResultSet resultSet = prepareStatement.executeQuery();

            List<Book> books = new LinkedList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("bookId"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setISBN(resultSet.getInt("ISBN"));
                books.add(book);
            }
            resultSet.close();
            return books;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return null;
    }

    public Book findBookById(int id) {
        String sql = "SELECT * FROM books WHERE bookId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();

            Book book = new Book();
            book.setId(resultSet.getInt("bookId"));
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("title"));
            book.setPages(resultSet.getInt("pages"));
            book.setISBN(resultSet.getInt("ISBN"));
            resultSet.close();

            return book;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return null;
    }

    public List<String> findAllTitles() {
        String sql = "SELECT title FROM books";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
             ResultSet resultSet = prepareStatement.executeQuery();
        ) {
            List<String> titles = new LinkedList<>();
            while (resultSet.next()) {
                titles.add(resultSet.getString("title"));
            }
            return titles;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

        return null;
    }

    public List<Book> findAllBooks() {
        String sql = "SELECT * FROM books";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
             ResultSet resultSet = prepareStatement.executeQuery();
        ) {
            List<Book> books = new LinkedList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("bookId"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                book.setISBN(resultSet.getInt("ISBN"));
                books.add(book);
            }
            return books;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);

        }

        return null;
    }
}

