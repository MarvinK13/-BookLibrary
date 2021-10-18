package model;

import java.util.ArrayList;

public class Member {
    private String name;
    private int id;

    public Member(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Book{" +
                "ISBN= " + name +
                ", title= '" + id + '\'' +
                '}';
    }
}
