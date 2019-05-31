package vo;
/*
患者成药处方明细表
 */
public class PrescriptionDetailed {
    private int id;//id
    private int prescriptionID;//成药处方id
    private int drugsID;//药品id
    private String drugsUsage;//用法
    private String dosage;//用量
    private String frequency;//频次
    private Double amount;//数量
    private int state;//状态

    public PrescriptionDetailed() {
    }

    public PrescriptionDetailed(int prescriptionID, int drugsID, String drugsUsage, String dosage, String frequency, Double amount, int state) {
        this.prescriptionID = prescriptionID;
        this.drugsID = drugsID;
        this.drugsUsage = drugsUsage;
        this.dosage = dosage;
        this.frequency = frequency;
        this.amount = amount;
        this.state = state;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public int getDrugsID() {
        return drugsID;
    }

    public void setDrugsID(int drugsID) {
        this.drugsID = drugsID;
    }

    public String getDrugsUsage() {
        return drugsUsage;
    }

    public void setDrugsUsage(String drugsUsage) {
        this.drugsUsage = drugsUsage;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PrescriptionDetailed{" +
                "id=" + id +
                ", prescriptionID=" + prescriptionID +
                ", drugsID=" + drugsID +
                ", drugsUsage='" + drugsUsage + '\'' +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", amount=" + amount +
                ", state=" + state +
                '}';
    }
}
