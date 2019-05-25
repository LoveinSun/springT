package top.kgoogle.data;

import java.io.Serializable;

public class choose implements Serializable {
    private static final long serialVersionUID = 1L;
    public int bookID;
    public int userID;
    public String begin;
    public String end;

    public choose(int bookID, int userID) {
        this.bookID = bookID;
        this.userID = userID;
    }

    public choose() {
    }

    public choose(int bookID, int userID, String begin, String end) {
        this.bookID = bookID;
        this.userID = userID;
        this.begin = begin;
        this.end = end;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
