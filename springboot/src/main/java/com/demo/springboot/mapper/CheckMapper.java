package com.demo.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : CheckMapper
 * @date : Create in 2019/9/19 16:50
 */
@Repository
@Mapper
@DS("acctDB")
public interface CheckMapper {
    @Select("select SEQ_CHECK_BUSI_ID.nextval")
    Integer getCheckBusiId();

    @Select("select SEQ_CHECK_FILE_ID.nextval")
    Integer getCheckFileId();

    @Select("select SEQ_CHECK_TABLE_ID.nextval")
    Integer getCheckTableId();

    @Insert("INSERT INTO `a_check_busi` (`BUSI_ID`, `BUSI_NAME`, `REGION_ID`, `CHECK_ACTION_FLAG`, `MOD_ACTION_FLAG`, `MOD_DIFF_LIMIT`, `EFF_DATE`, `EXP_DATE`, `PAYMENT_CHANNEL_ID`," +
            " `RECORD_STATE`) VALUES (#{checkBusiId}, #{bankName}, #{regionId}, '0', '0', '0', '2019-09-01 00:00:00', '2039-09-01 00:00:00', '1003', '1')")
    Integer addCheckBusi(@Param("checkBusiId") Integer checkBusiId,@Param("bankName") String bankName,@Param("regionId") String regionId);

    @Insert("INSERT INTO `a_check_busi_data_rel` (`BUSI_DATA_REL_ID`, `BUSI_ID`, `RELA_TYPE`, `DATA_TYPE`, `DATA_ID`, `RECORD_STATE`) VALUES" +
            "(SEQ_CHECK_BUSI_DATA_REL_ID.nextval, #{checkBusiId}, #{relaType}, #{dataType}, #{checkId}, '1')")
    Integer addCheckBusiDataRel(@Param("checkBusiId") Integer checkBusiId,@Param("checkId") Integer checkId,@Param("relaType") Integer relaType,@Param("dataType") Integer dataType);

    @Insert("INSERT INTO `a_check_file` (`FILE_ID`, `FILE_TYPE`, `FILE_NAME`, `FILE_PATH`, `FILE_HOST`, `FTP_PORT`, `FTP_MODE`, `USER_NAME`, `USER_PASS`, `FILE_HEAD_LINE`, `FILE_SKIP_LINE`," +
            " `FIELD_SPLITTER`, `HEAD_SPLITTER`, `FIELD_FIX_WIDTH`, `HEAD_FIX_WIDTH`, `FILE_POST_ACTION_WIDTH`, `FILE_BAK_PATH`, `HEAD_FIELD_COUNT`, `FILE_FIELD_COUNT`," +
            " `FORWARD_REVERSE_FLAG`, `FORWARD_REVERSE_VALUE`, `RECORD_STATE`, `FIELD_END_SPLITTER`, `HEAD_END_SPLITTER`) VALUES (#{checkFileId}, '3', 'N0531T%Y%M%DV'," +
            " '/PaaS/ci/ci_service/file', '137.0.253.73', '22', '0', 'acct', 'bss3.0test', '0', '0', '-1', NULL, '1', NULL, '1', NULL, NULL, '6', '0', NULL, '1', '-1', '-1')")
    Integer addCheckFile(@Param("checkFileId") Integer checkFileId);

    @Insert("INSERT INTO `a_check_file_field` (`FILE_FIELD_ID`, `FILE_ID`, `FIELD_NAME`, `FIELD_NUM`, `FIELD_PART`, `HEAD_FIELD_FLAG`, `HEAD_FIELD_NUM`, `COMPARE_FLAG`," +
            " `COMPARE_NAME`, `FIELD_TYPE`, `FIELD_OFFSET`, `FIELD_SIZE`, `FIELD_PRECISION`, `FIELD_SCALE`, `FIELD_TIMES_VALUE`, `FORWARD_VALUE`, `REVERSE_VALUE`, `RECORD_STATE`) VALUES" +
            "(SEQ_CHECK_FILE_FIELD_ID.nextval, #{checkFileId}, '账户标识', '1', '1', NULL, NULL, '3', '账户标识', '1', '0', '20', '20', NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_FILE_FIELD_ID.nextval, #{checkFileId}, '区号(非C网时使用)', '2', '1', NULL, NULL, '3', '区号(非C网时使用)', '1', '20', '9', NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_FILE_FIELD_ID.nextval, #{checkFileId}, '电话号码', '3', '1', NULL, NULL, '3', '电话号码', '1', '29', '20', NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_FILE_FIELD_ID.nextval, #{checkFileId}, '电信付款流水(缴费流水)', '4', '1', NULL, NULL, '2', 'paymentID', '2', '67', '18', NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_FILE_FIELD_ID.nextval, #{checkFileId}, '银行工号', '5', '1', NULL, NULL, '3', 'staffID', '1', '103', '6', NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_FILE_FIELD_ID.nextval, #{checkFileId}, '交易金额', '6', '1', NULL, NULL, '1', 'amount', '2', '109', '12', NULL, NULL, NULL, NULL, NULL, '1')")
    Integer addCheckFileField(@Param("checkFileId") Integer checkFileId);

    @Insert("INSERT INTO `a_check_table` (`TABLE_ID`, `DATABASE_TYPE`, `ORACLE_SCHEME`, `MYSQL_URL`, `USER_NAME`, `USER_PASS`, `TABLE_NAME`, `TABLE_SPLIT_FLAG`, `SELECT_FIELD_COUNT`," +
            " `WHERE_FIELD_COUNT`, `FORWARD_REVERSE_FLAG`, `FORWARD_REVERSE_VALUE`, `RECORD_STATE`) VALUES (#{checkTableId}, '2', NULL, 'jdbc:mysql://137.0.253.26:8100/ACCT_TEST', 'bss_acct'," +
            " 'bss_acct123', 'a_staff_deal_detail', '3', '3', '2', '0', NULL, '1')")
    Integer addCheckTable(@Param("checkTableId") Integer checkTableId);

    @Insert("INSERT INTO `a_check_table_field` (`TABLE_FIELD_ID`, `TABLE_ID`, `FIELD_NAME`, `COMPARE_FLAG`, `COMPARE_NAME`, `FIELD_TYPE`, `FILTER_FLAG`, `FILTER_VALUE`, `FIELD_PRECISION`," +
            " `FIELD_SCALE`, `FIELD_TIMES_VALUE`, `FORWARD_VALUE`, `REVERSE_VALUE`, `RECORD_STATE`) VALUES" +
            "(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'DEAL_AMOUNT', '1', 'amount', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'payment_id', '2', 'paymentID', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'STAFF_ID', '0', 'STAFF_ID', '2', '1', #{staffId}, NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'deal_date', '0', 'deal_date', '3', '7', '%Y%M%D', NULL, NULL, NULL, NULL, NULL, '1')" +
            ",(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{checkTableId}, 'ACCT_ID', '3', 'ACCT_ID', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1')")
    Integer addCheckTableField(@Param("checkTableId") Integer checkTableId,@Param("staffId") String staffId);

    @Select("select common_region_id from common_region where region_name = concat(#{regionName},'市') limit 1")
    String getRegionID(@Param("regionName") String regionName);

    @Select("SELECT\n" +
            "\ta.busi_id,\n" +
            "\ta.busi_name,\n" +
            "\tc.TABLE_FIELD_ID AS acctIdTableFieldId,\n" +
            "\td.TABLE_FIELD_ID AS paymentIdTableFieldId \n" +
            "FROM\n" +
            "\ta_check_busi a\n" +
            "\tLEFT JOIN a_check_busi_data_rel b ON a.busi_id = b.busi_id \n" +
            "\tAND b.rela_type = 2 \n" +
            "\tAND b.data_type = 2\n" +
            "\tLEFT JOIN a_check_table_field c ON b.data_id = c.table_id \n" +
            "\tAND c.field_name = 'acct_id'\n" +
            "\tLEFT JOIN a_check_table_field d ON b.data_id = d.table_id \n" +
            "\tAND d.field_name = 'payment_id'\n" +
            "where a.BUSI_NAME = '场景三对账'")
    List<HashMap<String,Object>> getAddModList();

    @Select("select seq_a_check_mod.nextVal")
    String getModId();

    @Insert("insert into a_check_mod(MOD_ID, BUSI_ID, MOD_REMARK, RESULT_TYPE, FORWARD_REVERSE_TYPE, SERVICE_TYPE, SERVICE_NAME) values (#{modId}, #{busiID}, concat(#{bankName},'平帐源缺少，调用核心返销'), '2', '0',null, 'bankCommonReverse')")
    Integer addCheckMod(@Param("modId") String modId,@Param("busiID") String busiID,@Param("bankName") String bankName);

    @Insert("insert into a_check_mod_parameter(mod_parameter_id, mod_id, parameter_name, parameter_position, parameter_flag, parameter_value, rela_type, data_type, parameter_times_value) values " +
            "(seq_a_check_mod_parameter.nextVal, #{modId}, 'staffId', 1, 1, '996011077562', 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'paymentId', 2,2, #{paymentIdTableFieldId}, 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'serialType', 3, 1, '1', 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'reason', 4, 1, '对帐功能触发自动返销', 2, 2, null)" +
            ",(seq_a_check_mod_parameter.nextVal, #{modId}, 'acctId', 5, 2, #{acctIdTableFieldId}, 2, 2, null)")
    Integer addCheckModParam(@Param("modId") String modId,@Param("paymentIdTableFieldId") String paymentIdTableFieldId,@Param("acctIdTableFieldId") String acctIdTableFieldId);

    @Select("select b.STAFF_ID_NEW,d.MOD_PARAMETER_ID from a_check_busi a " +
            "join a_agent b on a.busi_id = b.vs_task_id " +
            "join a_check_mod c on a.busi_id = c.busi_id " +
            "join a_check_mod_parameter d on c.MOD_ID = d.MOD_ID and d.PARAMETER_NAME = 'staffId'")
    List<HashMap<String,Object>> getBankCheckStaffId();

    @Update("update a_check_mod_parameter set PARAMETER_VALUE = #{STAFF_ID_NEW} where MOD_PARAMETER_ID = #{MOD_PARAMETER_ID}")
    int updateBankCheckStaffId(@Param("MOD_PARAMETER_ID") String MOD_PARAMETER_ID,@Param("STAFF_ID_NEW") String STAFF_ID_NEW);

    @Select("select data_id from a_check_busi_data_rel where RELA_TYPE = 2 and DATA_TYPE = 2 and busi_id in(\n" +
            "select busi_id from a_check_busi where busi_id <> 7100)")
    List<String> getTableIds();

    @Insert("insert into a_check_table_field(table_field_id,table_id,field_name,compare_flag,compare_name,field_type,filter_flag,filter_value,record_state) " +
            "values(SEQ_CHECK_TABLE_FIELD_ID.nextval, #{tableId}, 'BALANCE_SOURCE_TYPE_ID', '0', 'BALANCE_SOURCE_TYPE_ID', '2',1,'1003','1')")
    int addFilterValue(@Param("tableId") String tableId);

    @Update("update a_check_table set where_field_count = where_field_count + 1 where table_id = #{tableId}")
    int addWhereCount(@Param("tableId") String tableId);
}
