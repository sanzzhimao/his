/**
 * 实体类--挂号级别表
 * */
package vo;

public class RegistLevel {
    //唯一标识
    private int id;
    //号别编码
    private String registCode;
    //号别名称
    private String registName;
    //显示顺序号
    private int sequenceNo;
    //挂号费用
    private Double registFree;
    //挂号限额
    private int registquota;
    //删除标记
    private int delMark;

    public RegistLevel(String registCode, String registName, int sequenceNo, Double registFree, int registquota, int delMark) {
        this.registCode = registCode;
        this.registName = registName;
        this.sequenceNo = sequenceNo;
        this.registFree = registFree;
        this.registquota = registquota;
        this.delMark = delMark;
    }

    public RegistLevel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getRegistName() {
        return registName;
    }

    public void setRegistName(String registName) {
        this.registName = registName;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Double getRegistFree() {
        return registFree;
    }

    public void setRegistFree(Double registFree) {
        this.registFree = registFree;
    }

    public int getRegistquota() {
        return registquota;
    }

    public void setRegistquota(int registquota) {
        this.registquota = registquota;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "RegistLevel{" +
                "id=" + id +
                ", registCode='" + registCode + '\'' +
                ", registName='" + registName + '\'' +
                ", sequenceNo=" + sequenceNo +
                ", registFree=" + registFree +
                ", registquota=" + registquota +
                ", delMark=" + delMark +
                '}';
    }
}
