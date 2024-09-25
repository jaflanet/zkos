package com.fif.services.impl;

import com.fif.entity.User;
import com.fif.repository.UserRepository;
import com.fif.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.*;
@Service("userService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public  User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.queryAll();
    }

    public void deleteUser(Integer id){
        userRepository.delete(id);
    }

    public void updateUser(User user){
        userRepository.update(user);
    }





//
//    private UserRepository userList = new UserRepository();
//
//    @Override
//    public List<User> findAll() {
//        return userList.findAll();
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        UserRepository.userList.removeIf(user -> user.getId().equals(id));
//    }
//
//    @Override
//    public void updateUser(User updatedUser) {
//        userList.findAll().stream()
//                .filter(user -> user.getId().equals(updatedUser.getId()))
//                .findFirst()
//                .ifPresent(existingUser -> {
//                    existingUser.setUsername(updatedUser.getUsername());
//                    existingUser.setGender(updatedUser.getGender());
//                    existingUser.setBirthday(updatedUser.getBirthday());
//                    existingUser.setStatus(updatedUser.getStatus());
//                    existingUser.setAnak(updatedUser.getAnak());
//                });
//    }
//
//    public List<User> search(String keyword){
//        List<User> result = new LinkedList<User>();
//        List<User> userSearch = userList.findAll();
//        if(keyword==null|| "".equals(keyword)) {
//            result = userSearch;
//        }else{
//            for(User u: userSearch){
//                if(u.getUsername().toLowerCase().contains(keyword.toLowerCase())){
//                    result.add(u);
//                }
//            }
//        }
//        return result;
//    }
//
//    public void addUser(String username, String gender, Date birthday, String status, Integer anak) {
//        User newUser = new User( username, gender, birthday, status, anak);
//        userList.addUser(newUser);
//    }
//



}
