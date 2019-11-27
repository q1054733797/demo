package com.demo.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.demo.springboot.pojo.Agent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : AgentMapper
 * @date : Create in 2019/10/19 16:06
 */
@Mapper
@Repository
@DS("ls_comm")
public interface AgentMapper {
    @Select("select staff_id from acct.a_agent where agent_name = #{bankName}")
    String getBankStaffId(@Param("bankName") String bankName);

    @Select("select a.*,staff_id as STAFF_ID_OLD from acct.a_agent a where agent_name = #{bankName}")
    Agent getAgentInfo(@Param("bankName") String bankName);
}
