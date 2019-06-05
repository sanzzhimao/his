/*
常数项管理服务接口
何金华
 */
package service.informationservice;

import vo.ConstantItem;
import vo.ConstantType;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IConstantTypeService {
    //查询所有常数类别
    ArrayList<ConstantType> selectAllConstantType();
    //新增常数类别
    boolean addConstantType(ConstantType constantType);
    //通过常数类别或常数名称查询常数类别
    ConstantType selectConstantType(String string);
    //通过常数类别查询常数项
    ArrayList<ConstantItem> selectAllConstantItem(String string);
    //通过常数项名字或者编号模糊查询常数项
    ArrayList<ConstantItem> selectConstantItem(String string);
    //新增常数项
    boolean addConstantItem(ConstantItem constantItem);
    //编辑常数项
    boolean modifyConstantItem(ConstantItem constantItem);
    //删除常数项；
    boolean delectConstantItem(ConstantItem constantItem);
    //批量删除常数项 传入常数项id集合
    boolean delectDuoConstantItem(ArrayList arrayList);
}
