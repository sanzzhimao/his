/***
 * 实体类：费用科目表
 * 检查
 */

package vo;

public class ExpenseClass {
    //唯一标识
    private int id;
    //费用科目编码
    private String expCode;
    //费用科目名称
    private String expName;
    //删除标记
    private  int delMark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    public ExpenseClass(String expCode, String expName, int delMark) {
        this.expCode = expCode;
        this.expName = expName;
        this.delMark = delMark;
    }

    public ExpenseClass() {
    }

    @Override
    public String toString() {
        return "ExpenseClass{" +
                "id=" + id +
                ", expCode='" + expCode + '\'' +
                ", expName='" + expName + '\'' +
                ", delMark=" + delMark +
                '}';
    }
}
