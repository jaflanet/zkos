package data;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> userList = new LinkedList<User>();

    private Integer id=1;

    public UserServiceImpl() {
        userList.add(new User(id++, "john_doe", "male", "1998-01-15", "single", 0));
        userList.add(new User(id++, "jane_smith", "female", "1993-05-20", "married", 2));
        userList.add(new User(id++, "alex_brown", "male", "2001-08-12", "single", 0));
        userList.add(new User(id++, "mary_jones", "female", "1988-03-30", "widowed", 1));
        userList.add(new User(id++, "charlie_white", "male", "1995-11-25", "married", 3));
        userList.add(new User(id++, "lisa_black", "female", "1996-07-07", "single", 0));
        userList.add(new User(id++, "tom_green", "male", "1983-12-01", "married", 4));
        userList.add(new User(id++, "susan_yellow", "female", "1991-04-14", "divorced", 1));
        userList.add(new User(id++, "david_blue", "male", "1978-09-19", "single", 0));
        userList.add(new User(id++, "emily_red", "female", "1994-10-10", "married", 2));
    }



    public List<User> findAll(){return userList;}

    public List<User> search(String keyword){
        List<User> result = new LinkedList<User>();
        if(keyword==null|| "".equals(keyword)) {
            result = userList;
        }else{
            for(User u: userList){
                if(u.getUsername().toLowerCase().contains(keyword.toLowerCase())){
                    result.add(u);
                }
            }
        }
        return result;
    }
}
