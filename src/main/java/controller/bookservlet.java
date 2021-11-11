package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;
import model.RentedBooks;
import service.Admin;
import service.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "bookservlet", value = "/books/*")
public class bookservlet extends HttpServlet {

    private Admin admin = new Admin();
    private User user = new User();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pathinfo = request.getPathInfo();
        if (pathinfo == null || pathinfo.equals("/")) {

            List<Book> books = admin.seeallBooks();
            response.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter printWriter = response.getWriter();

            String responseJson = new ObjectMapper().writer().writeValueAsString(books);
            printWriter.write(responseJson);
            printWriter.flush();

        } else if (pathinfo.equals("/rentedbooks")) {

            List<RentedBooks> rentedBooks = admin.seeRentedBooks();
            response.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter printWriter = response.getWriter();

            String responseJson = new ObjectMapper().writer().writeValueAsString(rentedBooks);
            printWriter.write(responseJson);
            printWriter.flush();

        }
        System.out.println("Hello");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bodyAsJsonString = getBodyAsJson(request);
        System.out.println(bodyAsJsonString+" ist leer?");
        Book book = new ObjectMapper().readValue(bodyAsJsonString, Book.class);
        admin.addBook2(book);
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Allow", "GET, POST, DELETE, OPTIONS");
    }

    private String getBodyAsJson(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line.trim());
        }
        String jsonString = sb.toString();
        return jsonString;
    }
}
