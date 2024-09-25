package data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class UserRepository {
    public static List<User> userList = new ArrayList<>();

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            userList.add(new User(UUID.randomUUID().toString(), "john_doe", "male", sdf.parse("1999-05-20"), "single", 0));
            userList.add(new User(UUID.randomUUID().toString(), "jane_smith", "female", sdf.parse("1993-05-20"), "married", 2));
            userList.add(new User(UUID.randomUUID().toString(), "alex_brown", "male", sdf.parse("2001-08-12"), "single", 0));
            userList.add(new User(UUID.randomUUID().toString(), "mary_jones", "female", sdf.parse("1988-03-30"), "widowed", 1));
            userList.add(new User(UUID.randomUUID().toString(), "charlie_white", "male", sdf.parse("1995-11-25"), "married", 3));
            userList.add(new User(UUID.randomUUID().toString(), "lisa_black", "female", sdf.parse("1996-07-07"), "single", 0));
            userList.add(new User(UUID.randomUUID().toString(), "tom_green", "male", sdf.parse("1983-12-01"), "married", 4));
            userList.add(new User(UUID.randomUUID().toString(), "susan_yellow", "female", sdf.parse("1991-04-14"), "divorced", 1));
            userList.add(new User(UUID.randomUUID().toString(), "david_blue", "male", sdf.parse("1978-09-19"), "single", 0));
            userList.add(new User(UUID.randomUUID().toString(), "emily_red", "female", sdf.parse("1994-10-10"), "married", 2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
