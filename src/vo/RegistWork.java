package vo;
/*
    操作员日结
 */
import java.util.Date;

public class RegistWork {
    private  int id;
    private int registerID;//收费员ID
    private Date startTime;//日结起始时间
    private Date endTime;//日结结束时间

    public RegistWork() {
    }

    public RegistWork(int registerID, Date startTime, Date endTime) {
        this.registerID = registerID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "RegistWork{" +
                "id=" + id +
                ", registerID=" + registerID +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
