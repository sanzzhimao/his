/**
 * 实体类：结算类别表
 * */
package vo;

public class SettleCategory {
    //唯一标识
    private int id;
    //类别编码
    private String settleCode;
    //类别名称
    private String settleName;
    //显示顺序号
    private int sequenceNo;
    //删除标记
    private int delMark;

    public SettleCategory(String settleCode, String settleName, int sequenceNo, int delMark) {
        this.settleCode = settleCode;
        this.settleName = settleName;
        this.sequenceNo = sequenceNo;
        this.delMark = delMark;
    }

    public SettleCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSettleCode() {
        return settleCode;
    }

    public void setSettleCode(String settleCode) {
        this.settleCode = settleCode;
    }

    public String getSettleName() {
        return settleName;
    }

    public void setSettleName(String settleName) {
        this.settleName = settleName;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "SettleCategory{" +
                "id=" + id +
                ", settleCode='" + settleCode + '\'' +
                ", settleName='" + settleName + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", delMark=" + delMark +
                '}';
    }
}
