package model;

public class Member {
    private String name;
    private int id;
//TODO: existierst du noch?
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
        return "Book= " +
                "ISBN= " + name +
                "| title= '" + id + '\'';
    }
}
