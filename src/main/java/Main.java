import model.Member;
import model.Book;
import service.Admin;
import service.User;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


public class Main {
    public static void main(String[] args) {


        Admin admin=new Admin();
        User user=new User();
        user.rentBook(1,1);


    }

}
