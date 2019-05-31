/**
 * 实体类：用户类表
 * */
package vo;

public class User {
    //唯一标识
    private int id;
    //用户名
    private String userName;
    //用户密码
    private String password;
    //真实名字
    private String realName;
    //用户类型---1-医院管理员；2-挂号管理员；3-门诊医生；4-医技医生；5-药房操作员；6-财务管理员
    private  int useTpye;
    //医生职称
    private int docTileID;
    //是否排班
    private Boolean isScheduling;
    //部门编号
    private int deptid;
    //挂号级别id
    private int  registLeID;
    //删除编号
    private int delMark;

    public User(String userName, String password, String realName, int useTpye, int docTileID, Boolean isScheduling, int deptid, int registLeID, int delMark) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.useTpye = useTpye;
        this.docTileID = docTileID;
        this.isScheduling = isScheduling;
        this.deptid = deptid;
        this.registLeID = registLeID;
        this.delMark = delMark;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getUseTpye() {
        return useTpye;
    }

    public void setUseTpye(int useTpye) {
        this.useTpye = useTpye;
    }

    public int getDocTileID() {
        return docTileID;
    }

    public void setDocTileID(int docTileID) {
        this.docTileID = docTileID;
    }

    public Boolean getScheduling() {
        return isScheduling;
    }

    public void setScheduling(Boolean scheduling) {
        isScheduling = scheduling;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getRegistLeID() {
        return registLeID;
    }

    public void setRegistLeID(int registLeID) {
        this.registLeID = registLeID;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", useTpye=" + useTpye +
                ", docTileID=" + docTileID +
                ", isScheduling=" + isScheduling +
                ", deptid=" + deptid +
                ", registLeID=" + registLeID +
                ", delMark=" + delMark +
                '}';
    }
}
