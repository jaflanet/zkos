package data;

import java.util.*;

public class UserServiceImpl implements UserService {


    private UserRepository userList = new UserRepository();

    @Override
    public List<User> findAll() {
        return userList.findAll();
    }

    @Override
    public void deleteUser(String id) {
        UserRepository.userList.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void updateUser(User updatedUser) {
        userList.findAll().stream()
                .filter(user -> user.getId().equals(updatedUser.getId()))
                .findFirst()
                .ifPresent(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setGender(updatedUser.getGender());
                    existingUser.setBirthday(updatedUser.getBirthday());
                    existingUser.setStatus(updatedUser.getStatus());
                    existingUser.setAnak(updatedUser.getAnak());
                });
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
