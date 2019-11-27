package com.demo.springboot.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: BatchAdjustInfo
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/16 21:53
 * @Version: 1.0
 */
@Data
public class BatchAdjustInfo implements Serializable {
    private static final long serialVersionUID = -655584921374502073L;
    //主键列使用序列SEQ_ADJUST_OA_APPLY
    private Long adjustOaApplyID;
    //批次号
    private Long batchID;
    //用户ID
    private Long servID;
    //账户ID
    private Long acctID;
    //账目项
    private Long acctItemTypeID;
    //调账金额,正数为调增,负数为调减
    private Long amount;
    //账期
    private Long billingCycle;
    //创建时间
    private String createDate;
    //状态:-1作废0初始1校验失败2校验通过3调账失败4调账成功
    private Long state;
    //状态时间
    private String stateDate;
    //状态说明,状态为失败时记录原因
    private String remark;
    //员工工号
    private String staffCode;
    //员工ID
    private Long staffID;
    //员工所在部门ID
    private Long commRegionID;
    //分片键,本表使用BATCH_ID
    private Long routeID;
    //调账类型
    private String adjustType;
    //调账原因
    private String adjustReason;
    //账户名称
    private String acctName;
    //接入号
    private String accNbr;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
