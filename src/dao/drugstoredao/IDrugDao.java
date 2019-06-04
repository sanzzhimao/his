package dao.drugstoredao;

import vo.ConstantItem;
import vo.Drugs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 药品管理Dao层接口
 */
public interface IDrugDao {
    void setConnection(Connection con);

    //通过助记码查询药品
    List<Drugs> selectDrugs(String mnemonicCode) throws SQLException;

    //读取有效药品剂型
    List<ConstantItem> selectDrugsDosage() throws SQLException;

    //读取有效药品类型
    List<ConstantItem> selectDrugsType() throws SQLException;

    //根据ID读取药品信息
    Drugs selectDrug(int id) throws SQLException;

    //判断药品编码是否重复
    boolean selectDrugsCode(String code) throws  SQLException;

    //新增药品
    void addDrugs(Drugs drug) throws SQLException;

    //修改药品
    void updateDrugs(Drugs drug) throws SQLException;

    //根据ID删除药品
    void deleteDrugs(int id) throws SQLException;
}
