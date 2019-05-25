package top.kgoogle.data;

public class user {
    public int id;
    public String name;
    public String pwd;
    public int level;

    public user( String name) {
        this.name = name;
    }
    public user( String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public user( String name, String pwd, int level) {
        this.name = name;
        this.pwd = pwd;
        this.level = level;
    }

    public user() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
