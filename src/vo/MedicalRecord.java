package vo;

/**
 * 实体类：患者病历首页
 */
public class MedicalRecord {
    private int id;
    //病历号
    private String caseNumber;
    //挂号ID
    private int registerID;
    //主诉
    private String readme;
    //现病史
    private String present;
    //现病治疗情况
    private String presentTreat;
    //既往史
    private String history;
    //过敏史
    private String allergy;
    //体格检查
    private String physique;
    //检查建议
    private String proposal;
    //注意事项
    private String careful;
    //检查结果
    private String checkResult;
    //诊断结果
    private String diagnosis;
    //处理意见
    private String handling;
    //病历状态
    private int caseState;

    public MedicalRecord() {
    }

    public MedicalRecord(int id, String caseNumber, int registerID, String readme, String present, String presentTreat, String history, String allergy, String physique, String proposal, String careful, String checkResult, String diagnosis, String handling, int caseState) {
        this.id = id;
        this.caseNumber = caseNumber;
        this.registerID = registerID;
        this.readme = readme;
        this.present = present;
        this.presentTreat = presentTreat;
        this.history = history;
        this.allergy = allergy;
        this.physique = physique;
        this.proposal = proposal;
        this.careful = careful;
        this.checkResult = checkResult;
        this.diagnosis = diagnosis;
        this.handling = handling;
        this.caseState = caseState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getPresentTreat() {
        return presentTreat;
    }

    public void setPresentTreat(String presentTreat) {
        this.presentTreat = presentTreat;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getPhysique() {
        return physique;
    }

    public void setPhysique(String physique) {
        this.physique = physique;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public String getCareful() {
        return careful;
    }

    public void setCareful(String careful) {
        this.careful = careful;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }

    public int getCaseState() {
        return caseState;
    }

    public void setCaseState(int caseState) {
        this.caseState = caseState;
    }
}
