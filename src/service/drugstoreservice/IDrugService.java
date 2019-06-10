package service.drugstoreservice;

import vo.ConstantItem;
import vo.Drugs;

import java.sql.SQLException;
import java.util.List;

public interface IDrugService {
    //查询药品按钮
    List<Drugs> selectDrugs(String mnemonicCode) throws SQLException;

    //读取有效药品剂型
    List<ConstantItem> selectDrugsDosage() throws SQLException;

    //读取有效药品类型
    List<ConstantItem> selectDrugsType() throws SQLException;

    //根据ID读取药品信息
    Drugs selectDrug(int id) throws SQLException;

    //新增药品
    void addDrugs(Drugs drug) throws SQLException;

    //修改药品
    void updateDrugs(Drugs drug) throws SQLException;

    //根据ID删除药品
    void deleteDrugs(int id) throws SQLException;
}
