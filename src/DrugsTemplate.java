import java.util.Date;
/*
  实体类：成药处方模板表
 */
public class DrugsTemplate {
  private int id;
  //名称
  private String  name;
  //医生id
  private  int userID;
  //创建时间
 private Date creationTime;
 //使用范围
  private String scope;
  //删除标记
  private int delMark;

    @Override
    public String toString() {
        return "DrugsTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userID=" + userID +
                ", creationTime=" + creationTime +
                ", scope='" + scope + '\'' +
                ", delMark=" + delMark +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }


}
