package top.kgoogle.data;

public class book {
    public  Integer id;
    public String name;
    public int authorID;

    public book(int id, String name, int authorID) {
        this.id = id;
        this.name = name;
        this.authorID = authorID;
    }

    public book(){}

    public book(String name, int authorID) {
        this.name = name;
        this.authorID = authorID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
}
