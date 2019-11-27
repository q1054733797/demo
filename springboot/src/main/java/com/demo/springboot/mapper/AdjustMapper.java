package com.demo.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.demo.springboot.pojo.BatchAdjustInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : AdjustMapper
 * @date : Create in 2019/11/9 14:31
 */
@Mapper
@Repository
@DS("gathacctdb")
//@DS("acctDB")
public interface AdjustMapper {
    @Select("SELECT\n" +
            "	acct_id as acctID," +
            "   serv_id as servID," +
            "   acct_item_type_id as acctItemTypeID," +
            "   sum(charge) AS amount," +
            "   '1' as adjustReason," +
            "   '0' as adjustType," +
            "   201910 as billingCycle," +
            "   'YL009' as staffCode," +
            "   to_char(sysdate,'yyyymmddhh24miss') as batchID \n" +
            "FROM\n" +
            "	xxh_bil_yj.tiaozhang_20191113_3 \n" +
            "WHERE\n" +
            "	serv_id <> 314026604094 \n" +
            "GROUP BY\n" +
            "	serv_id,\n" +
            "	acct_id,\n" +
            "	acct_item_type_id \n" +
            "HAVING\n" +
            "   sum( charge ) > 0")
    List<BatchAdjustInfo> getAdjustInfos();
}
