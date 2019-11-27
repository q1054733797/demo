package com.demo.springboot.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ImpBatchAdjustReq
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/17 9:26
 * @Version: 1.0
 */
@Data
public class ImpBatchAdjustReq implements Serializable {
    private static final long serialVersionUID = -7621094414299383181L;
    //调账信息
    private List<BatchAdjustInfo> adjustInfos;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
