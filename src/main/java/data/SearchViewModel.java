package data;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;

import java.util.Date;
import java.util.List;

public class SearchViewModel {

    private String keyword;
    private String username;
    private String gender;
    private Date birthday;
    private String status;
    private Integer anak;
    private UserService userService = new UserServiceImpl();
    private List<User> userList = new ListModelList<>(userService.findAll());
    private User selectedUser;



    @Command
    public void search() {
        userList.clear();
        userList.addAll(userService.search(keyword));
    }

    @Command
    @NotifyChange("userList")
    public void addNew() {
        userService.addUser(username, gender, birthday, status, anak);
        System.out.println(username);
        System.out.println(userService);
        search();
        Executions.sendRedirect("search-mvvm.zul");
    }

    @Command
    @NotifyChange("userList")
    public void delete() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before delete");

        userService.deleteUser(selectedUser.getId());
        userList.remove(selectedUser);
        Executions.sendRedirect("search-mvvm.zul");

        System.out.println("--------------------");
        System.out.println("Id: " + selectedUser.getId());
        System.out.println("Username: " + selectedUser.getUsername());
        System.out.println("Gender: " + selectedUser.getGender());
        System.out.println("--------------------");
    }

    @Command
    @NotifyChange({"userList", "selectedUser"})
    public void update() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before updating");

        userService.updateUser(selectedUser);
        Executions.sendRedirect("search-mvvm.zul");

        System.out.println("--------------------");
        System.out.println("Updated User Id: " + selectedUser.getId());
        System.out.println("Username: " + selectedUser.getUsername());
        System.out.println("--------------------");
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

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getKeyword() { return keyword; }

    public List<User> getUserList() { return  userList; }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() { return selectedUser; }



}
