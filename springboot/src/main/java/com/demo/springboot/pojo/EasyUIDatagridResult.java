package com.demo.springboot.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: EasyUIDatagridResult
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/14 15:10
 * @Version: 1.0
 */
@Data
public class EasyUIDatagridResult<T> implements Serializable {
    private Integer total;
    private List<T> rows;
}
