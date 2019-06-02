package com.neusoft.his.vo;

public class ExpenseClass {
    int id;
    String expcode;
    String expname;
    int delmark;

    public ExpenseClass() {

    }

    public ExpenseClass(String expcode, String expname, int delmark) {
        this.expcode = expcode;
        this.expname = expname;
        this.delmark = delmark;
    }

    @Override
    public String toString() {
        return "ExpenseClass{" +
                "id=" + id +
                ", expcode='" + expcode + '\'' +
                ", expname='" + expname + '\'' +
                ", delmark=" + delmark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpcode() {
        return expcode;
    }

    public void setExpcode(String expcode) {
        this.expcode = expcode;
    }

    public String getExpname() {
        return expname;
    }

    public void setExpname(String expname) {
        this.expname = expname;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }
}
