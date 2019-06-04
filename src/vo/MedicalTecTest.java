package vo;
/**
 * @Author lym
 * @Description:医技检验的实体(数据主要从CheckApply和FmedItem中获取)
 * @Param
 * @return
**/
public class MedicalTecTest {
    //无意义的标识
    private  int id;
    //检验名称
    private String meTecTestName;
    //检验部位
    private String meTectestPosition;
    //数量
    private int num;
    //单位
    private String format;
    //单价
    private double price;
    //总价格
    private double totalPrice;
    //状态（已检验--未检验）
    private int state;

    @Override
    public String toString() {
        return "MedicalTecTest{" +
                "id=" + id +
                ", meTecTestName='" + meTecTestName + '\'' +
                ", meTectestPosition='" + meTectestPosition + '\'' +
                ", num=" + num +
                ", format='" + format + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", state=" + state +
                '}';
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

    public String getMeTecTestName() {
        return meTecTestName;
    }

    public void setMeTecTestName(String meTecTestName) {
        this.meTecTestName = meTecTestName;
    }

    public String getMeTectestPosition() {
        return meTectestPosition;
    }

    public void setMeTectestPosition(String meTectestPosition) {
        this.meTectestPosition = meTectestPosition;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
