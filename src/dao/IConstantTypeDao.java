package dao;
/*
常数类别接口
何金华
 */
import vo.ConstantItem;
import vo.ConstantType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
public interface IConstantTypeDao {
    //链接数据库
    void setConnection(Connection con);
    //查询所有常数类别
    ArrayList<ConstantType> selectAllConstantType() throws SQLException;
    //新增常数类别
    void addConstantType(ConstantType constantType) throws SQLException ;
    //通过常数类别或常数名称查询常数类别
    ConstantType selectConstantType(String string) throws SQLException;
    //通过常数类别查询常数项
    ArrayList<ConstantItem> selectAllConstantItem(String string) throws SQLException;
    //通过常数项名字或者编号查询常数项
    ArrayList<ConstantItem> selectConstantItem(String string) throws SQLException;
    //新增常数项
    void addConstantItem(ConstantItem constantItem) throws SQLException;
    //编辑常数项
    void modifyConstantItem(ConstantItem constantItem) throws SQLException;
    //删除常数项；
    void delectConstantItem(ConstantItem constantItem) throws SQLException;
    //批量删除常数项
    void delectDuoConstantItem();

}
