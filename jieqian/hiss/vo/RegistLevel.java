package com.neusoft.his.vo;

public class RegistLevel {
    int id;
    String registcode;
    String regisname;
    int sequenceno;
    int regisfee;
    int regisquota;
    int delmark;

    @Override
    public String toString() {
        return "RegistLevel{" +
                "id=" + id +
                ", registcode='" + registcode + '\'' +
                ", regisname='" + regisname + '\'' +
                ", sequenceno=" + sequenceno +
                ", regisfee=" + regisfee +
                ", regisquota=" + regisquota +
                ", delmark=" + delmark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistcode() {
        return registcode;
    }

    public void setRegistcode(String registcode) {
        this.registcode = registcode;
    }

    public String getRegisname() {
        return regisname;
    }

    public void setRegisname(String regisname) {
        this.regisname = regisname;
    }

    public int getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(int sequenceno) {
        this.sequenceno = sequenceno;
    }

    public int getRegisfee() {
        return regisfee;
    }

    public void setRegisfee(int regisfee) {
        this.regisfee = regisfee;
    }

    public int getRegisquota() {
        return regisquota;
    }

    public void setRegisquota(int regisquota) {
        this.regisquota = regisquota;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }
}
