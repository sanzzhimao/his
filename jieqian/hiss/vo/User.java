package com.neusoft.his.vo;

public class User {
    int id;
    String username;
    String password;
    String realname;
    int usetype;
    int doctitleid;
    String isscheduling;
    int deptid;
    int registleid;
    int delmark;

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getRegistleid() {
        return registleid;
    }

    public void setRegistleid(int registleid) {
        this.registleid = registleid;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getUsetype() {
        return usetype;
    }

    public void setUsetype(int usetype) {
        this.usetype = usetype;
    }

    public int getDoctitleid() {
        return doctitleid;
    }

    public void setDoctitleid(int doctitleid) {
        this.doctitleid = doctitleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", usetype=" + usetype +
                ", doctitleid=" + doctitleid +
                ", isscheduling='" + isscheduling + '\'' +
                '}';
    }

    public String getIsscheduling() {
        return isscheduling;
    }

    public void setIsscheduling(String isscheduling) {
        this.isscheduling = isscheduling;
    }
}
