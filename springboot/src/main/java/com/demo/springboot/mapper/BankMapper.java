package com.demo.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.demo.springboot.pojo.Agent;
import com.demo.springboot.pojo.Bank;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : BankMapper
 * @date : Create in 2019/10/19 16:09
 */
@Mapper
@Repository
@DS("acctDB")
public interface BankMapper {
    @Select("select busi_id as bankID,busi_name as bankName from a_check_busi")
    List<Bank> getBankNames();

    @Insert("insert into a_agent values(" +
            "#{AGENT_CODE}," +
            "#{AGENT_NAME}," +
            "#{BSS_ORG_ID}," +
            "#{BEGIN_TIME}," +
            "#{END_TIME}," +
            "#{LAST_VS_DATE}," +
            "#{FTP_HOST}," +
            "#{FTP_USER}," +
            "#{FTP_PASSWORD}," +
            "#{FTP_DEC_DIR}," +
            "#{PRINT_FLAG}," +
            "#{STAFF_ID_NEW}," +
            "#{FTP_PUT_DIR}," +
            "#{vs_task_id}," +
            "#{vs_file_name}," +
            "#{STAFF_ID_OLD})")
    int addAgent(Agent agent);

    @Select("SELECT * from a_agent")
    List<Agent> getAgentInfos();

    @Update("UPDATE a_check_file \n" +
            "SET file_path = #{FTP_DEC_DIR},\n" +
            "file_name = #{vs_file_name},\n" +
            "file_host = #{FTP_HOST},\n" +
            "user_name = #{FTP_USER},\n" +
            "user_pass = #{FTP_PASSWORD} \n" +
            "WHERE\n" +
            "	file_id = #{vs_task_id}")
    int updateBank(Agent agent);

    @Select("SELECT\n" +
            "		data_id \n" +
            "	FROM\n" +
            "		a_check_busi_data_rel a\n" +
            "		JOIN a_check_busi b ON a.busi_id = b.busi_id \n" +
            "		AND b.busi_name = #{bankName} \n" +
            "	WHERE\n" +
            "		RELA_TYPE = 1 \n" +
            "	AND DATA_TYPE = 1")
    String getFileId(@Param("bankName") String bankName);

    @Select("select staff_id from staff where staff_code = #{staffCode}")
    String getNewStaffId(@Param("staffCode") String staffCode);

    @Update("update a_agent set staff_id_new = #{newStaffId} where staff_id_old = #{oldStaffId}")
    int updateNewStaffId(@Param("oldStaffId") String oldStaffId,@Param("newStaffId") String newStaffId);

    @Update("update a_check_table_field set filter_value = #{STAFF_ID_NEW} where filter_value = #{STAFF_ID_OLD}")
    int updateStaffId(Agent agent);

    @Select("select * from a_agent where staff_id_new = 1")
    List<Agent> getNewStaffIdisOnw();
}
