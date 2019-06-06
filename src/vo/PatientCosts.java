package vo;

import java.util.Date;

/**
 * 实体类：患者费用明细
 */
public class PatientCosts {
    private int id;
    private int registID;//挂号ID
    private int invoiceID;//发票ID
    private int itemID;//项目ID
    private int itemType;//项目类型
    private String name;//项目名称
    private double price;//项目单价
    private double amount;//数量
    private int deptID;//执行科室ID
    private Date createTime;//开立时间
    private int createOperID;//开立人员ID
    private Date payTime;//收/退费时间
    private int registerID;//收/退费人员ID
    private int feeType;//收费方式
    private int backID;//退费对应ID

    public PatientCosts() {
    }

    public PatientCosts(int registID, int invoiceID, int itemID, int itemType, String name, double price, double amount, int deptID, Date createTime, int createOperID, Date payTime, int registerID, int feeType, int backID) {
        this.registID = registID;
        this.invoiceID = invoiceID;
        this.itemID = itemID;
        this.itemType = itemType;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.deptID = deptID;
        this.createTime = createTime;
        this.createOperID = createOperID;
        this.payTime = payTime;
        this.registerID = registerID;
        this.feeType = feeType;
        this.backID = backID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistID() {
        return registID;
    }

    public void setRegistID(int registID) {
        this.registID = registID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreateOperID() {
        return createOperID;
    }

    public void setCreateOperID(int createOperID) {
        this.createOperID = createOperID;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public int getBackID() {
        return backID;
    }

    public void setBackID(int backID) {
        this.backID = backID;
    }

    @Override
    public String toString() {
        return "PatientCosts{" +
                "id=" + id +
                ", registID=" + registID +
                ", invoiceID=" + invoiceID +
                ", itemID=" + itemID +
                ", itemType=" + itemType +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", deptID=" + deptID +
                ", createTime=" + createTime +
                ", createOperID=" + createOperID +
                ", payTime=" + payTime +
                ", registerID=" + registerID +
                ", feeType=" + feeType +
                ", backID=" + backID +
                '}';
    }

    public void getDeptID(int deptID) {
    }
}
