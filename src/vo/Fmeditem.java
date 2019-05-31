/**
 * 实体类：非药品收费项目
 * 检查
 * */
package vo;

import javax.sound.midi.Track;
import java.util.Date;

public class Fmeditem {
    //唯一标识
    private  int id;
    //项目编码
    private String itemCode;
    //项目名称
    private String itemName;
    //规格
    private String format;
    //单价
    private double price;
    //所属费用科目id
    private int expClassID;
    //执行科室id
    private int deptID;
    //拼音助记码
    private String mnemonicCode;
    //创建时间
    private Date creationDate;
    //最后修改时间
    private Date lastUpdateDate;
    //项目类型（1--检查  2--检验  3--处置）
    private int recordType;
    //删除标记
    private int delMark;

    @Override
    public String toString() {
        return "Fmeditem{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", format='" + format + '\'' +
                ", price=" + price +
                ", expClassID=" + expClassID +
                ", deptID=" + deptID +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", recordType=" + recordType +
                ", delMark=" + delMark +
                '}';
    }
}
