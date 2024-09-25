package com.fif.services;

import com.fif.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

//    public List<User> findAll();
//
//    public List<User> search(String keyword);
//
//    void addUser(String username, String gender, Date birthday, String status, Integer anak);
//
//    void deleteUser(int id);
//
//    void updateUser(User user);

    User addUser(User user);
    List<User> getUsers();
    void deleteUser(Integer id);
    void updateUser(User user);
}
