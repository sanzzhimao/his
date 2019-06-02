package dao;

import vo.DiseCategory;
import vo.Disease;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 诊断目录管理Dao层接口
 */
public interface IDiagnosisDao {
    void setConnection(Connection con);

    //查询所有有效疾病分类
    List<DiseCategory> selectAllDiseCategory() throws SQLException;

    //通过疾病分类或者编码查询疾病分类
    List<DiseCategory> selectDiseCategory(String dica) throws SQLException;

    //通过ID查询疾病信息
    DiseCategory selectDiseCategory(int id) throws SQLException;

    //判断编码是否存在
    boolean selectDicaCode(String dicacode) throws SQLException;

    //新增疾病分类
    void addDiseCategory(DiseCategory dis) throws SQLException;

    //编辑疾病分类
    void updateDiseCategory(String dicacode,String dicaname,int sequenceno,int id) throws SQLException;

    //删除选中疾病分类
    void deleteDiseCategory(int id) throws SQLException;

    //批量删除选中疾病分类
    void deleteMoreDiseCaregory(int id) throws SQLException;

    //通过编码和名称查询疾病
    List<Disease> selectDisease(String dis) throws SQLException;

    //判断疾病编码是否存在
    boolean selectDiseaseCode(String code) throws SQLException;

    //判断国际ICD编码是否重复
    boolean selectDiseaseICD(String icd) throws SQLException;

    //新增疾病
    void addDisease(Disease dis) throws SQLException;

    //根据ID读取疾病信息
    Disease selectDiseaseByID(int id) throws SQLException;

    //修改疾病信息
    void updateDisease(Disease dis) throws SQLException;

    //根据ID删除选中疾病
    void deleteDisease(int id) throws SQLException;

    //批量删除选中疾病
    void deleteMoreDisease(int id) throws SQLException;
}