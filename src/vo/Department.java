/**
 * 实体类：科室类
 *已检查
 * */
package vo;

public class Department {
    //唯一标识id；
    private  int id;
    //科室编码
    private String deptCode;
    //科室名称
    private  String deptName;
    //科室分类
    private  int deptCategoryID;
    //科室类型1-临床；2-医技；3-财务；4-行政；5-其他
    private  int deptType;
    //删除标记；1-正常；0-已删除
    private int delMark;

    public Department(String deptCode, String deptName, int deptCategoryID, int deptType, int delMark) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.deptCategoryID = deptCategoryID;
        this.deptType = deptType;
        this.delMark = delMark;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptCategoryID() {
        return deptCategoryID;
    }

    public void setDeptCategoryID(int deptCategoryID) {
        this.deptCategoryID = deptCategoryID;
    }

    public int getDeptType() {
        return deptType;
    }

    public void setDeptType(int deptType) {
        this.deptType = deptType;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptCategoryID=" + deptCategoryID +
                ", deptType=" + deptType +
                ", delMark=" + delMark +
                '}';
    }
}
