package com.demo.springboot.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: BatchConferInfo
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/13 20:55
 * @Version: 1.0
 */
@Data
public class BatchConferInfo implements Serializable {
    private static final long serialVersionUID = -2712525337280433818L;
    private Long conferOaApplyID;
    //批次ID
    private String batchID;
    //工号编码
    private String staffCode;
    //用户号码
    private String accNbr;
    //余额使用对象
    private String objTypeId;
    //账目组
    private String itemGroupID;
    //余额类型
    private String balanceTypeId;
    //赠款金额
    private String amount;
    //月限额
    private String cycleUpper;
    //生效时间
    private String effDate;
    //失效时间
    private String expDate;
    //创建时间
    private String createDate;
    //状态
    private String state;
    //状态时间
    private String stateDate;
    //状态备注
    private String remark;
    //缴费流水
    private Long paymentID;
    //员工id
    private Long staffID;
    //赠款原因
    private String conferReason;
    //员工所在部门id
    private Long commRegionID;
    //用作分片建
    private String acctID;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
