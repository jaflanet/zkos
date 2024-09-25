package data;

import java.util.Date;

public class User {
    private String id;
    private String username;
    private String gender;
    private Date birthday;
    private String status;
    private Integer anak;

    public User(String id, String username, String gender, Date birthday, String status, Integer anak) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.anak = anak;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
