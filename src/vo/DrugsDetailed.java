package vo;

/**
 * 实体类：成药模板明细
 */
public class DrugsDetailed {
    private int id;
    private int drugsTempID;//成药模板ID
    private int drugsID;//药品ID
    private String durgsUsage;//用法
    private String dosage;//用量
    private String frequency;//频次

    public DrugsDetailed() {
    }

    public DrugsDetailed(int drugsTempID, int drugsID, String durgsUsage, String dosage, String frequency) {
        this.drugsTempID = drugsTempID;
        this.drugsID = drugsID;
        this.durgsUsage = durgsUsage;
        this.dosage = dosage;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrugsTempID() {
        return drugsTempID;
    }

    public void setDrugsTempID(int drugsTempID) {
        this.drugsTempID = drugsTempID;
    }

    public int getDrugsID() {
        return drugsID;
    }

    public void setDrugsID(int drugsID) {
        this.drugsID = drugsID;
    }

    public String getDurgsUsage() {
        return durgsUsage;
    }

    public void setDurgsUsage(String durgsUsage) {
        this.durgsUsage = durgsUsage;
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

    @Override
    public String toString() {
        return "DrugsDetailed{" +
                "id=" + id +
                ", drugsTempID=" + drugsTempID +
                ", drugsID=" + drugsID +
                ", durgsUsage='" + durgsUsage + '\'' +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
