/**
 * 实体类：常数类别表
 *已检查
 * */
package vo;

public class ConstantType {
    //id字段唯一标识
    private int id;
    //常数类别字段
    private String constantTypeCode;
    //常数名称字段
    private String constantTypeName;
    //删除标记：1-正常；0-已删除
    private int delMark;

    public ConstantType(String constantTypeCode, String constantTypeName, int delMark) {
        this.constantTypeCode = constantTypeCode;
        this.constantTypeName = constantTypeName;
        this.delMark = delMark;
    }

    public ConstantType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstantTypeCode() {
        return constantTypeCode;
    }

    public void setConstantTypeCode(String constantTypeCode) {
        this.constantTypeCode = constantTypeCode;
    }

    public String getConstantTypeName() {
        return constantTypeName;
    }

    public void setConstantTypeName(String constantTypeName) {
        this.constantTypeName = constantTypeName;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "ConstantType{" +
                "id=" + id +
                ", constantTypeCode='" + constantTypeCode + '\'' +
                ", constantTypeName='" + constantTypeName + '\'' +
                ", delMark=" + delMark +
                '}';
    }
}
