package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;
import repository.BookRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "bookservlet", value = "/books/*")
public class bookservlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pathinfo=request.getPathInfo();
        if (pathinfo == null ||pathinfo.equals("/")) {
            List<Book> books=new LinkedList<>();

            BookRepository repo=new BookRepository();
            PrintWriter writer = response.getWriter();

            String responsejson = new ObjectMapper().writeValueAsString(repo.findAllBooks());
            writer.write(responsejson);
        }
        System.out.println("Hello");
    }
}
