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
            response.setHeader("Access-Control-Allow-Origin","*");
            PrintWriter printWriter = response.getWriter();

            String responseJson = new ObjectMapper().writer().writeValueAsString(books);
            printWriter.write(responseJson);
            printWriter.flush();

        } else if (pathinfo.equals("/rentedbooks")){

            List<RentedBooks> books = admin.seeRentedBooks();
            response.setHeader("Access-Control-Allow-Origin","*");
            PrintWriter printWriter = response.getWriter();

            String responseJson = new ObjectMapper().writer().writeValueAsString(books);
            printWriter.write(responseJson);
            printWriter.flush();

        }
        System.out.println("Hello");
    }
}
