package vo;

import java.util.Date;

/**
 * 实体类：药品目录类
 *已检查
 * */
public class Drugs {
    //唯一标识
    private int id;
    //药品编码
    private String drugCode;
    //药品名称
    private String drugName;
    //药品规格
    private String drugsFormat;
    //包装单位
    private String drugsUnit;
    //生产厂家
    private String Maufacturer;
    //药品剂型
    private int drugsDosageID;
    //药品类型
    private int drugsTpyeID;
    //药品单价
    private Double drugsPrice;
    //拼音助记码
    private String mnemonicCode;
    //创建时间
    private Date creationDate;
    //最后修改时间
    private Date lastUpdateDate;
    //删除标记
    private int delMark;

    public Drugs(String drugCode, String drugName, String drugsFormat, String drugsUnit, String maufacturer, int drugsDosageID, int drugsTpyeID, Double drugsPrice, String mnemonicCode, Date creationDate, Date lastUpdateDate, int delMark) {
        this.drugCode = drugCode;
        this.drugName = drugName;
        this.drugsFormat = drugsFormat;
        this.drugsUnit = drugsUnit;
        Maufacturer = maufacturer;
        this.drugsDosageID = drugsDosageID;
        this.drugsTpyeID = drugsTpyeID;
        this.drugsPrice = drugsPrice;
        this.mnemonicCode = mnemonicCode;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.delMark = delMark;
    }

    public Drugs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugsFormat() {
        return drugsFormat;
    }

    public void setDrugsFormat(String drugsFormat) {
        this.drugsFormat = drugsFormat;
    }

    public String getDrugsUnit() {
        return drugsUnit;
    }

    public void setDrugsUnit(String drugsUnit) {
        this.drugsUnit = drugsUnit;
    }

    public String getMaufacturer() {
        return Maufacturer;
    }

    public void setMaufacturer(String maufacturer) {
        Maufacturer = maufacturer;
    }

    public int getDrugsDosageID() {
        return drugsDosageID;
    }

    public void setDrugsDosageID(int drugsDosageID) {
        this.drugsDosageID = drugsDosageID;
    }

    public int getDrugsTpyeID() {
        return drugsTpyeID;
    }

    public void setDrugsTpyeID(int drugsTpyeID) {
        this.drugsTpyeID = drugsTpyeID;
    }

    public Double getDrugsPrice() {
        return drugsPrice;
    }

    public void setDrugsPrice(Double drugsPrice) {
        this.drugsPrice = drugsPrice;
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

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "Drugs{" +
                "id=" + id +
                ", drugCode='" + drugCode + '\'' +
                ", drugName='" + drugName + '\'' +
                ", drugsFormat='" + drugsFormat + '\'' +
                ", drugsUnit='" + drugsUnit + '\'' +
                ", Maufacturer='" + Maufacturer + '\'' +
                ", drugsDosageID=" + drugsDosageID +
                ", drugsTpyeID=" + drugsTpyeID +
                ", drugsPrice=" + drugsPrice +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", delMark=" + delMark +
                '}';
    }
}
