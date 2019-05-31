package vo;
/**
 * 疾病表
 * 检查
 * */
public class Disease {
    //唯一标识
    private int id;
    //疾病助记编码
    private String diseaseCode;
    //疾病名称
    private String diseaseName;
    //国际ICD编码
    private String diseaseICD;
    //疾病所属分类
    private int diseCategoryID;
    //删除标记
    private int delMark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseICD() {
        return diseaseICD;
    }

    public void setDiseaseICD(String diseaseICD) {
        this.diseaseICD = diseaseICD;
    }

    public int getDiseCategoryID() {
        return diseCategoryID;
    }

    public void setDiseCategoryID(int diseCategoryID) {
        this.diseCategoryID = diseCategoryID;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    public Disease(String diseaseCode, String diseaseName, String diseaseICD, int diseCategoryID, int delMark) {
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.diseaseICD = diseaseICD;
        this.diseCategoryID = diseCategoryID;
        this.delMark = delMark;
    }

    public Disease() {
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", diseaseCode='" + diseaseCode + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", diseaseICD='" + diseaseICD + '\'' +
                ", diseCategoryID=" + diseCategoryID +
                ", delMark=" + delMark +
                '}';
    }
}
