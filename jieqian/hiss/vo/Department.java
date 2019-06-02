package com.neusoft.his.vo;

public class Department {
    int id;
    String deptcode;
    String deptname;
    int deptcategoryid;
    int depttype;
    int delmark;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptcode='" + deptcode + '\'' +
                ", deptname='" + deptname + '\'' +
                ", deptcategoryid=" + deptcategoryid +
                ", depttype=" + depttype +
                ", delmark=" + delmark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public int getDeptcategoryid() {
        return deptcategoryid;
    }

    public void setDeptcategoryid(int deptcategoryid) {
        this.deptcategoryid = deptcategoryid;
    }

    public int getDepttype() {
        return depttype;
    }

    public void setDepttype(int depttype) {
        this.depttype = depttype;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }
}
