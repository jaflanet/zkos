package com.fif.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "User")
public class User implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String gender;

    @Column
    Date birthday;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    Integer anak;

    public User() {
    }

    public User(String username, String gender, Date birthday, String status, Integer anak) {
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.anak = anak;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
