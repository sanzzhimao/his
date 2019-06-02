package vo;

import java.sql.Date;

/**
 * 实体类：非药品管理实体类(已用)
 */
public class NoDrug {
    private int id;
    //项目编码
    private String itemCode;
    //项目名称
    private String itemName;
    //规格
    private String format;
    //单价
    private double price;
    //所属费用科目ID
    private int expClassID;
    //执行科室ID
    private int deptID;
    //拼音助记码
    private String mnemonicCode;
    //创建时间
    private Date creationDate;
    //最后修改时间
    private Date lastUpdateDate;
    //项目类型
    private int recordType;
    //删除标记
    private int delMark;
    //所属费用科目名称
    private String expName;
    //执行科室名称
    private String deptName;

    public NoDrug() {
    }

    public NoDrug(String itemCode, String itemName, String format, double price, int expClassID, int deptID, String mnemonicCode, Date creationDate, Date lastUpdateDate, int recordType, int delMark, String expName, String deptName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.format = format;
        this.price = price;
        this.expClassID = expClassID;
        this.deptID = deptID;
        this.mnemonicCode = mnemonicCode;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.recordType = recordType;
        this.delMark = delMark;
        this.expName = expName;
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getExpClassID() {
        return expClassID;
    }

    public void setExpClassID(int expClassID) {
        this.expClassID = expClassID;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getRecordType() {
        return recordType;
    }

    public void setRecordType(int recordType) {
        this.recordType = recordType;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "NoDrug{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", format='" + format + '\'' +
                ", price=" + price +
                ", expClassID=" + expClassID +
                ", deptID=" + deptID +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", recordType=" + recordType +
                ", delMark=" + delMark +
                ", expName='" + expName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
