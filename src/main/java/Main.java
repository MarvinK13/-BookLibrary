import model.Member;
import model.Book;
import service.Admin;
import service.User;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        Calendar calender = Calendar.getInstance();
        calender.set(2004,6,13);
        Date date=calender.getTime();
        Timestamp timestamp=new Timestamp(date.getTime());
        Admin admin=new Admin();
        User user=new User();
        user.getBooksById(1);


    }

}
