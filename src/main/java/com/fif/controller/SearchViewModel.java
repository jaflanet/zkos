package com.fif.controller;

import com.fif.entity.Log;
import com.fif.entity.User;
import com.fif.services.UserService;
import com.fif.services.impl.UserServiceImpl;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel {

//    private String keyword;
    @WireVariable
    private UserService userService;

    private List<User> userList;
    private String username;
    private String gender;
    private Date birthday;
    private String status;
    private Integer anak;
    private User selectedUser;
//
//    public ListModelList<User> getUserList() {
//        return userListModel;
//    }

    @Init
    public void init() {
        userList = new ListModelList<>();
        userList.addAll(userService.getUsers());
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAnak() {
        return anak;
    }

    public void setAnak(Integer anak) {
        this.anak = anak;
    }

    @Command
    public void addUser() {
        User user= new User(username,gender,birthday,status,anak);
        user = userService.addUser(user);
        userList.add(user);
        Executions.sendRedirect("search-mvvm.zul");
    }



//    @Command
//    public void search() {
//        userList.clear();
//        userList.addAll(userService.search(keyword));
//    }



    @Command
    @NotifyChange("userList")
    public void delete() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before delete");

        userService.deleteUser(selectedUser.getId());
        userList.remove(selectedUser);
        Executions.sendRedirect("search-mvvm.zul");
    }

    @Command
    @NotifyChange({"userList", "selectedUser"})
    public void update() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before updating");
        userService.updateUser(selectedUser);
        Executions.sendRedirect("search-mvvm.zul");
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Integer getAnak() {
//        return anak;
//    }
//
//    public void setAnak(Integer anak) {
//        this.anak = anak;
//    }
//
//    public void setKeyword(String keyword) { this.keyword = keyword; }
//
//    public String getKeyword() { return keyword; }
//
//    public List<User> getUserList() { return  userList; }
//
    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() { return selectedUser; }



}
