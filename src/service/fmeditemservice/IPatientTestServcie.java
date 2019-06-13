package service.fmeditemservice;

import vo.CheckInfo;

import java.util.List;

/**
 * @Author lym
 * @Description:医技管理的service层接口
 * @Param
 * @return
**/
public interface IPatientTestServcie {
    /**
     * @Author lym
     * @Description通过患者的名字找到一些基本信息
     * @Param [name]
     * @return java.util.List<vo.CheckInfo>
    **/
    List<CheckInfo> findCheckInfoByName(String name);
}
