package vo;

import java.util.Date;

public class CheckInfo {
    //无意义字段
    private int id;
    //患者病历号
    private String registeNum;
    //患者名字
    private String name;
    //患者年龄
    private int age;
    //结算类别
    private String settleName;
    //就诊科室、
    private String department;
    //处方状态
    private int prescriptionState;
    //收费日期
    private Date creatonTime;
    //开单医生
    private  String doc;
    //发票号码
    private String invoceNumber;
    //患者发票号
    private String invoiceNUm;
    //检查--检验--处置（三个类型）
    private int recordType;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSettleName() {
        return settleName;
    }

    public void setSettleName(String settleName) {
        this.settleName = settleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPrescriptionState() {
        return prescriptionState;
    }

    public void setPrescriptionState(int prescriptionState) {
        this.prescriptionState = prescriptionState;
    }

    public Date getCreatonTime() {
        return creatonTime;
    }

    public void setCreatonTime(Date creatonTime) {
        this.creatonTime = creatonTime;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getInvoceNumber() {
        return invoceNumber;
    }

    public void setInvoceNumber(String invoceNumber) {
        this.invoceNumber = invoceNumber;
    }

    public int getRecordType() {

        return recordType;
    }

    public void setRecordType(int recordType) {
        this.recordType = recordType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisteNum() {
        return registeNum;
    }

    public void setRegisteNum(String registeNum) {
        this.registeNum = registeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvoiceNUm() {
        return invoiceNUm;
    }

    public void setInvoiceNUm(String invoiceNUm) {
        this.invoiceNUm = invoiceNUm;
    }

    @Override
    public String
    toString() {
        return "CheckInfo{" +
                "id=" + id +
                ", registeNum='" + registeNum + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", settleName='" + settleName + '\'' +
                ", department='" + department + '\'' +
                ", prescriptionState=" + prescriptionState +
                ", creatonTime=" + creatonTime +
                ", doc='" + doc + '\'' +
                ", invoceNumber='" + invoceNumber + '\'' +
                ", invoiceNUm='" + invoiceNUm + '\'' +
                ", recordType=" + recordType +
                '}';
    }
}
