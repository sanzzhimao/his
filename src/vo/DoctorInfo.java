package vo;

public class DoctorInfo {
    private int id;
    private String realName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public DoctorInfo(int id, String realName) {
        this.id = id;
        this.realName = realName;
    }
}
