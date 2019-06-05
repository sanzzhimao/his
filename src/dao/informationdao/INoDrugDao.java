package dao.informationdao;

import vo.Department;
import vo.ExpenseClass;
import vo.Fmeditem;
import vo.NoDrug;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface INoDrugDao {
    void setConnection(Connection con);

    //查询当前有效非药品收费项目
    List<NoDrug> selectNoDrug(String item) throws SQLException;

    //根据ID查询当前非药品信息
    NoDrug selectNoDrugByID(int id) throws SQLException;

    //查询有效费用分类
    List<ExpenseClass> selectExpenseClass() throws SQLException;

    //查询有效执行科室
    List<Department> selectDepartment() throws SQLException;

    //判断编码是否重复
    boolean selectItemCode(String itemcode) throws SQLException;

    //新增非药品收费项目
    void addNoDrug(NoDrug nodrug) throws SQLException;

    //修改非药品信息
    void updateNoDrug(NoDrug nodrug) throws SQLException;

    //删除单个非药品信息
    void deleteNoDrug(int id) throws SQLException;

    //批量删除非药品信息
    void deleteAllNoDrug(int[] id) throws SQLException;
}
