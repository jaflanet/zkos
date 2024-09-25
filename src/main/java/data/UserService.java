package data;

import java.util.Date;
import java.util.List;

public interface UserService {

    public List<User> findAll();

    public List<User> search(String keyword);

    void addUser(String username, String gender, Date birthday, String status, Integer anak);

    void deleteUser(String id);

    void updateUser(User user);
}
