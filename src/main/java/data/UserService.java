package data;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public List<User> search(String keyword);

    void addUser(String username, String gender, String birthday, String status, Integer anak);
}
