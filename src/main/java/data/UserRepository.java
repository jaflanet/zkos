package data;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    public static List<User> userList = new ArrayList<User>();

    static {
        userList.add(new User(UUID.randomUUID().toString(), "john_doe", "male", "1998-01-15", "single", 0));
        userList.add(new User(UUID.randomUUID().toString(), "jane_smith", "female", "1993-05-20", "married", 2));
        userList.add(new User(UUID.randomUUID().toString(), "alex_brown", "male", "2001-08-12", "single", 0));
        userList.add(new User(UUID.randomUUID().toString(), "mary_jones", "female", "1988-03-30", "widowed", 1));
        userList.add(new User(UUID.randomUUID().toString(), "charlie_white", "male", "1995-11-25", "married", 3));
        userList.add(new User(UUID.randomUUID().toString(), "lisa_black", "female", "1996-07-07", "single", 0));
        userList.add(new User(UUID.randomUUID().toString(), "tom_green", "male", "1983-12-01", "married", 4));
        userList.add(new User(UUID.randomUUID().toString(), "susan_yellow", "female", "1991-04-14", "divorced", 1));
        userList.add(new User(UUID.randomUUID().toString(), "david_blue", "male", "1978-09-19", "single", 0));
        userList.add(new User(UUID.randomUUID().toString(), "emily_red", "female", "1994-10-10", "married", 2));
    }

    public List<User> findAll() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

}
