package com.neusoft.his.vo;

public class ConstantItem {
    int id;
    int constanttypeid;
    String constantcode;
    String constantname;
    int delmark;

    @Override
    public String toString() {
        return "ConstantItem{" +
                "id=" + id +
                ", constanttypeid=" + constanttypeid +
                ", constantcode='" + constantcode + '\'' +
                ", constantname='" + constantname + '\'' +
                ", delmark=" + delmark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConstanttypeid() {
        return constanttypeid;
    }

    public void setConstanttypeid(int constanttypeid) {
        this.constanttypeid = constanttypeid;
    }

    public String getConstantcode() {
        return constantcode;
    }

    public void setConstantcode(String constantcode) {
        this.constantcode = constantcode;
    }

    public String getConstantname() {
        return constantname;
    }

    public void setConstantname(String constantname) {
        this.constantname = constantname;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }
}
