package com.neusoft.his.dao;

import com.neusoft.his.vo.ExpenseClass;

import java.sql.SQLException;

public interface IExpenseClassDao {
    //读取当前有效费用科目
    ExpenseClass findInfByCodeorName(String expc,String expn)throws SQLException;
    //新增费用科目
    void addExpenseclass(String expc)throws SQLException;
    //通过id读取科目信息
    ExpenseClass findInfByID(int id)throws SQLException;
    //判断费用科目信息是否重复
    void setExpenseclassByExpC(String expc)throws SQLException;
    //置删除记录状态无效
    void invalideDelMarkByID(int id)throws SQLException;
}
