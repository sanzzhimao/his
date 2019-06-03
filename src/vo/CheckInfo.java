package vo;

public class CheckInfo {
    //无意义字段
    private int id;
    //患者病历号
    private String registeNum;
    //患者名字
    private String name;
    //患者发票号
    private String invoiceNUm;
    //检查--检验--处置（三个类型）
    private int recordType;

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
}
