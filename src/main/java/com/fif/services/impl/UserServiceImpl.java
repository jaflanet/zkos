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

    public List<User> search(String keyword) {
        return userRepository.searchByKeyword(keyword);
    }

}
