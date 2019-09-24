package com.example.viewWithSecurity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "userstbl")
public class User {

    @Id
    private int userId;
    private String name;
    private String family;
    private String pass;
    private Date insertdate;

    public User() {
    }

    public User(int userId, String name, String family, String pass, Date insertdate) {
        this.userId = userId;
        this.name = name;
        this.family = family;
        this.pass = pass;
        this.insertdate = insertdate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }
}
