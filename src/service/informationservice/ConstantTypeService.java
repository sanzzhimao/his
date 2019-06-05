/*
常数项类别及常数项管理
何金华
 */
package service.informationservice;

import dao.informationdao.ConstantTypeDao;
import util.JdbcUtil;
import vo.ConstantItem;
import vo.ConstantType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConstantTypeService implements IConstantTypeService {
    Connection con=null;
    // //查询所有常数类别
    @Override
    public ArrayList<ConstantType> selectAllConstantType(){
        ArrayList<ConstantType> list=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            list=ctd.selectAllConstantType();
            con.commit();
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return list;
        }

    }
    //新增常数类别
    @Override
    public boolean addConstantType(ConstantType constantType){
        boolean check=true;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            ctd.addConstantType(constantType);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            check=false;
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return check;
        }
    }
    //通过常数类别或常数名称查询常数类别
    @Override
    public ConstantType selectConstantType(String string){
        ConstantType constantType=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            constantType=ctd.selectConstantType(string);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return constantType;
        }

    }
    //通过常数类别查询常数项
    @Override
    public ArrayList<ConstantItem> selectAllConstantItem(String string){
        ArrayList<ConstantItem> list=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            list=ctd.selectAllConstantItem(string);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return list;
        }
    }
    //通过常数项名字或者编号模糊查询常数项
    @Override
    public ArrayList<ConstantItem> selectConstantItem(String string){
        ArrayList<ConstantItem> list=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            list=ctd.selectConstantItem(string);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return list;
        }
    }
    //新增常数项
    @Override
    public boolean addConstantItem(ConstantItem constantItem){
        boolean check=true;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            ctd.addConstantItem(constantItem);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            check=false;
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return check;
        }

    }
    //编辑常数项 通过id
    @Override
    public boolean modifyConstantItem(ConstantItem constantItem){
        boolean check=true;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            ctd.modifyConstantItem(constantItem);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            check=false;
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return check;
        }

    }
    //删除常数项；
    @Override
    public boolean delectConstantItem(ConstantItem constantItem){
        boolean check=true;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            ctd.delectConstantItem(constantItem);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            check=false;
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return check;
        }

    }
    //批量删除常数项 传入常数项id集合
    @Override
    public boolean delectDuoConstantItem(ArrayList arrayList){
        boolean check=true;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ConstantTypeDao ctd=new ConstantTypeDao();
            ctd.setConnection(con);
            ctd.delectDuoConstantItem(arrayList);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            check=false;
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return check;
        }

    }
}
