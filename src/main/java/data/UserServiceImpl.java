package data;

import java.util.*;

public class UserServiceImpl implements UserService {


    private UserRepository userList = new UserRepository();

    @Override
    public List<User> findAll() {
        return userList.findAll();
    }





    public List<User> search(String keyword){
        List<User> result = new LinkedList<User>();
        List<User> userSearch = userList.findAll();
        if(keyword==null|| "".equals(keyword)) {
            result = userSearch;
        }else{
            for(User u: userSearch){
                if(u.getUsername().toLowerCase().contains(keyword.toLowerCase())){
                    result.add(u);
                }
            }
        }
        return result;
    }

    public void addUser(String username, String gender, String birthday, String status, Integer anak) {
        User newUser = new User(UUID.randomUUID().toString(), username, gender, birthday, status, anak);
        userList.addUser(newUser);
    }


}
