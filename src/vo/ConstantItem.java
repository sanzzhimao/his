/**
 * 实体类：常数项表
 *已检查
 * */
package vo;

public class ConstantItem {
    //id总段唯一标识
    private int id;
    //所属常数类别id----指向ConstantType类的(ID)
    private int constantTypeID;
    //常数项编码
    private  String contantCode;
    //常数项名称
    private String constantName;
    //删除标记
    private int delMark;

    public ConstantItem() {
    }

    public ConstantItem(int constantTypeID, String contantCode, String constantName, int delMark) {
        this.constantTypeID = constantTypeID;
        this.contantCode = contantCode;
        this.constantName = constantName;
        this.delMark = delMark;
    }

    public int getConstantTypeID() {
        return constantTypeID;
    }

    public void setConstantTypeID(int constantTypeID) {
        this.constantTypeID = constantTypeID;
    }

    public String getContantCode() {
        return contantCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContantCode(String contantCode) {
        this.contantCode = contantCode;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "ConstantItem{" +
                "id=" + id +
                ", constantTypeID=" + constantTypeID +
                ", contantCode='" + contantCode + '\'' +
                ", constantName='" + constantName + '\'' +
                ", delMark=" + delMark +
                '}';
    }
}
