package service;

import vo.DoctorCrew;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * 医生排班管理业务接口
 */
public interface IDoctorCrewService {
    //根据日期查询医生排班
    List<DoctorCrew> selectDoctor(Date starttime, Date endtime) throws SQLException;
}
