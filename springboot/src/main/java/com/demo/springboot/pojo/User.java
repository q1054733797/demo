package com.demo.springboot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/14 14:37
 * @Version: 1.0
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String realName;
}
