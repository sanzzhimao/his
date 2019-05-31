/**
 * 实体类：疾病分类表
 *检查
 * */
package vo;

public class DiseCategory {
    //唯一标识
    private int id;
    //分类编码
    private  String dicaCode;
    //分类名称
    private String dicaName;
    //显示顺序号
    private int sequenceNo;
    //疾病类型
    private  int dicaType;
    //删除标记
    private int delMark;

    public DiseCategory(String dicaCode, String dicaName, int sequenceNo, int dicaType, int delMark) {
        this.dicaCode = dicaCode;
        this.dicaName = dicaName;
        this.sequenceNo = sequenceNo;
        this.dicaType = dicaType;
        this.delMark = delMark;
    }

    public DiseCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDicaCode() {
        return dicaCode;
    }

    public void setDicaCode(String dicaCode) {
        this.dicaCode = dicaCode;
    }

    public String getDicaName() {
        return dicaName;
    }

    public void setDicaName(String dicaName) {
        this.dicaName = dicaName;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public int getDicaType() {
        return dicaType;
    }

    public void setDicaType(int dicaType) {
        this.dicaType = dicaType;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "DiseCategory{" +
                "id=" + id +
                ", dicaCode='" + dicaCode + '\'' +
                ", dicaName='" + dicaName + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", dicaType=" + dicaType +
                ", delMark=" + delMark +
                '}';
    }
}
