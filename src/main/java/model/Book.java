package model;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int pages;
    private int ISBN;
    private int id;


    public Book(String author, String title, int pages, int ISBN) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public Book(){

    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return ISBN == book.ISBN && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public String toString() {
        return "Book= " +
                "ISBN= " + ISBN +
                "| title= '" + title + '\'' +
                "| author= '" + author + '\'' +
                "| pages= " + pages;
    }
}