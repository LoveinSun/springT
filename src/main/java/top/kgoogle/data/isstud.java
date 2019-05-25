package top.kgoogle.data;

public class isstud {
    public int id;
    public String name;
    public String sex;
    String nation;
    String birthday;
    String dmtB;
    String dmtN;
    String bedN;
    String tel;
    String homeT;
    String address;
    public isstud(int id, String name, String sex, String nation, String birthday, String dmtB, String dmtN, String bedN, String tel, String homeT, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.dmtB = dmtB;
        this.dmtN = dmtN;
        this.bedN = bedN;
        this.tel = tel;
        this.homeT = homeT;
        this.address = address;
    }
    public isstud(){}
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDmtB() {
        return dmtB;
    }

    public void setDmtB(String dmtB) {
        this.dmtB = dmtB;
    }

    public String getDmtN() {
        return dmtN;
    }

    public void setDmtN(String dmtN) {
        this.dmtN = dmtN;
    }

    public String getBedN() {
        return bedN;
    }

    public void setBedN(String bedN) {
        this.bedN = bedN;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHomeT() {
        return homeT;
    }

    public void setHomeT(String homeT) {
        this.homeT = homeT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
