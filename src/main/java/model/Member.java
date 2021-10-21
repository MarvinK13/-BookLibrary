package model;

import java.sql.Timestamp;
import java.util.Date;

public class Member {
    private String name;
    private int id;
    private String email;
    private Timestamp birthday;
    private String active;

    public Member(String name,String email,Timestamp birthday) {
        this.name = name;
        this.email =email;
        this.birthday =birthday;
    }

    public Member() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Member= " +
                "Name= " + name +
                "| id= " + id +
                "| email= " + email +
                "| birthday= " + birthday +
                "| active= "+active+'\'';
    }
}
