package data;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class SearchViewModel {

    private String keyword;
    private String username;
    private String gender;
    private String birthday;
    private String status;
    private Integer anak;
    private List<User> userList = new ListModelList<>();
    private User selectedUser;
    private UserService userService = new UserServiceImpl();


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
    }

    @Command
    public void delete() {
        if (selectedUser == null) throw new RuntimeException("Please select user before delete");
        System.out.println("--------------------");
        System.out.println("Id: " + selectedUser.getId());
        System.out.println("Username: " + selectedUser.getUsername());
        System.out.println("Gender: " + selectedUser.getGender());
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
