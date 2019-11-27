package com.demo.nmcheck.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : CheckMapper
 * @date : Create in 2019/11/11 21:19
 */
@Mapper
@Repository
@DS("master")
public interface CheckMapper {
    @Select("select SEQ_CHECK_BUSI_ID.nextval")
    Integer getCheckBusiId();

    @Select("select SEQ_CHECK_FILE_ID.nextval")
    Integer getCheckFileId();

    @Select("select SEQ_CHECK_TABLE_ID.nextval")
    Integer getCheckTableId();

    @Select("select agent_code as agentCode,agent_name as agentName,bss_org_id as orgId from a_agent where agent_code in (${agentCodes})")
    List<HashMap<String,Object>> getAgentInfos(@Param("agentCodes") String agentCodes);

    @Select("select staff_id as staffId from staff where org_id = #{orgId}")
    List<String> getStaffIds(@Param("orgId") String orgId);

    @Insert("INSERT INTO `a_check_busi` (`BUSI_ID`, `BUSI_NAME`, `REGION_ID`, `CHECK_ACTION_FLAG`, `MOD_ACTION_FLAG`, `MOD_DIFF_LIMIT`, `EFF_DATE`, `EXP_DATE`, `PAYMENT_CHANNEL_ID`," +
            " `RECORD_STATE`) VALUES (#{busiId}, #{busiName}, #{regionId}, '0', '0', '0', '2019-09-01 00:00:00', '2039-09-01 00:00:00', '5', '1')")
    Integer addCheckBusi(@Param("busiId") Integer busiId,@Param("busiName") String busiName,@Param("regionId") String regionId);

    @Insert("INSERT INTO `a_check_busi_data_rel` (`BUSI_DATA_REL_ID`, `BUSI_ID`, `RELA_TYPE`, `DATA_TYPE`, `DATA_ID`, `RECORD_STATE`) VALUES" +
            "(SEQ_CHECK_BUSI_DATA_REL_ID.nextval, #{busiId}, #{relaType}, #{dataType}, #{checkId}, '1')")
    Integer addCheckBusiDataRel(@Param("busiId") Integer busiId,@Param("checkId") Integer checkId,@Param("relaType") Integer relaType,@Param("dataType") Integer dataType);

    @Insert("INSERT INTO `a_check_table` (`TABLE_ID`, `DATABASE_TYPE`, `ORACLE_SCHEME`, `MYSQL_URL`, `USER_NAME`, `USER_PASS`, `TABLE_NAME`, `TABLE_SPLIT_FLAG`, `SELECT_FIELD_COUNT`," +
            " `WHERE_FIELD_COUNT`, `FORWARD_REVERSE_FLAG`, `FORWARD_REVERSE_VALUE`, `RECORD_STATE`) VALUES (#{checkTableId}, '2', NULL, 'jdbc:mysql://10.218.2.116:8904/ACCT_ACCTDB', 'acct'," +
            " 'BA_bs_0917_a', #{tableName}, #{tableSplitFlag}, '1', #{whereFieldCount}, '0', NULL, '1')")
    Integer addCheckTable(@Param("checkTableId") Integer checkTableId,@Param("tableName") String tableName,@Param("tableSplitFlag") String tableSplitFlag,@Param("whereFieldCount") String whereFieldCount);

    @Insert("INSERT INTO `a_check_table_field` (`TABLE_FIELD_ID`, `TABLE_ID`, `FIELD_NAME`, `COMPARE_FLAG`, `COMPARE_NAME`, `FIELD_TYPE`, `FILTER_FLAG`, `FILTER_VALUE`, `FIELD_PRECISION`," +
            " `FIELD_SCALE`, `FIELD_TIMES_VALUE`, `FORWARD_VALUE`, `REVERSE_VALUE`, `RECORD_STATE`) VALUES" +
            "(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'PAY_SERIAL_NBR', '2', 'paymentID', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'AGENT_CODE', '0', 'AGENT_CODE', '1', '1', #{agentCode}, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'VS_DATE', '0', 'VS_DATE', '3', '7', null, NULL, NULL, NULL, NULL, NULL, '1')")
    Integer addCheckTableFieldSource(@Param("checkTableId") Integer checkTableId,@Param("agentCode") String agentCode);

    @Insert("INSERT INTO `a_check_table_field` (`TABLE_FIELD_ID`, `TABLE_ID`, `FIELD_NAME`, `COMPARE_FLAG`, `COMPARE_NAME`, `FIELD_TYPE`, `FILTER_FLAG`, `FILTER_VALUE`, `FIELD_PRECISION`," +
            " `FIELD_SCALE`, `FIELD_TIMES_VALUE`, `FORWARD_VALUE`, `REVERSE_VALUE`, `RECORD_STATE`) VALUES" +
            "(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'PAYMENT_ID', '2', 'paymentID', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'PAYMENT_DATE', '0', 'PAYMENT_DATE', '3', '7', NULL, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'STATUS_CD', '0', 'STATUS_CD', '2', '4', '3,4', NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'STAFF_ID', '0', 'STAFF_ID', '2', '3', #{staffIds}, NULL, NULL, NULL, NULL, NULL, '1')")
    Integer addCheckTableFieldTarget(@Param("checkTableId") Integer checkTableId,@Param("staffIds") String staffIds);

    @Select("SELECT\n" +
            "	A.BUSI_ID as busiId,\n" +
            "   A.BUSI_NAME as busiName\n," +
            "	C.TABLE_FIELD_ID as acctIdTableFieldId,\n" +
            "	D.TABLE_FIELD_ID as paymentIdTableFieldId,\n" +
            "   E.TABLE_FIELD_ID as staffIdTableFieldId\n" +
            "FROM\n" +
            "	a_check_busi a\n" +
            "	JOIN a_check_busi_data_rel b ON a.busi_id = b.busi_id \n" +
            "	AND b.rela_type = 2\n" +
            "	JOIN a_check_table_field c ON b.data_id = c.table_id \n" +
            "	AND c.field_name = 'ACCT_ID'\n" +
            "	JOIN a_check_table_field D ON b.data_id = D.table_id \n" +
            "	AND D.field_name = 'PAYMENT_ID'\n" +
            "   JOIN a_check_table_field e ON b.data_id = e.table_id \n" +
            "   AND e.field_name = 'STAFF_ID' and e.filter_flag is null " +
            "where a.busi_id = 100008000")
    List<HashMap<String,Object>> getModList();

    @Select("select seq_a_check_mod.nextVal")
    String getModId();

    @Insert("insert into a_check_mod(MOD_ID, BUSI_ID, MOD_REMARK, RESULT_TYPE, FORWARD_REVERSE_TYPE, SERVICE_TYPE, SERVICE_NAME) values (#{modId}, #{busiId}, concat(#{busiName},'平帐源缺少，调用核心返销'), '2', '0',null, 'bankCommonReverse')")
    Integer addCheckMod(@Param("modId") String modId,@Param("busiId") String busiId,@Param("busiName") String busiName);

    @Insert("insert into a_check_mod_parameter(mod_parameter_id, mod_id, parameter_name, parameter_position, parameter_flag, parameter_value, rela_type, data_type, parameter_times_value) values " +
            "(seq_a_check_mod_parameter.nextVal, #{modId}, 'staffId', 1, 2, #{staffIdTableFieldId}, 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'paymentId', 2,2, #{paymentIdTableFieldId}, 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'serialType', 3, 1, '1', 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'reason', 4, 1, '对帐功能触发自动返销', 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'acctId', 5, 2, #{acctIdTableFieldId}, 2, 2, null)")
    Integer addCheckModParam(@Param("modId") String modId,@Param("paymentIdTableFieldId") String paymentIdTableFieldId,@Param("acctIdTableFieldId") String acctIdTableFieldId,@Param("staffIdTableFieldId") String staffIdTableFieldId);
}
