package com.demo.springboot.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ImpBatchConferReq
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/13 21:02
 * @Version: 1.0
 */
@Data
public class ImpBatchConferReq implements Serializable {
    private static final long serialVersionUID = 3927781182136068922L;
    private List<BatchConferInfo> conferInfos;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
