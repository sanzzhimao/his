package vo;

/**
 * 实体类：草药处方明细
 */
public class HerbalDetailed {
    private int id;
    private int herbalPresID;//草药处方ID
    private int herbalID;//药品ID
    private String dosage;//用量
    private double price;//药品单价
    private String footnote;//脚注
    private String herbalName;//药品名称

    public HerbalDetailed() {
    }

    public HerbalDetailed(int herbalPresID, int herbalID, String dosage, double price, String footnote) {
        this.herbalPresID = herbalPresID;
        this.herbalID = herbalID;
        this.dosage = dosage;
        this.price = price;
        this.footnote = footnote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHerbalPresID() {
        return herbalPresID;
    }

    public void setHerbalPresID(int herbalPresID) {
        this.herbalPresID = herbalPresID;
    }

    public int getHerbalID() {
        return herbalID;
    }

    public void setHerbalID(int herbalID) {
        this.herbalID = herbalID;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public String getHerbalName() {
        return herbalName;
    }

    public void setHerbalName(String herbalName) {
        this.herbalName = herbalName;
    }

    @Override
    public String toString() {
        return "HerbalDetailed{" +
                "id=" + id +
                ", herbalPresID=" + herbalPresID +
                ", herbalID=" + herbalID +
                ", dosage='" + dosage + '\'' +
                ", price=" + price +
                ", footnote='" + footnote + '\'' +
                ", herbalName='" + herbalName + '\'' +
                '}';
    }
}
