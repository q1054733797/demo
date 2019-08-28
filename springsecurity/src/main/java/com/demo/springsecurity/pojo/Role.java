package com.demo.springsecurity.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: Role
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 9:16
 * @Version: 1.0
 */
@Data
public class Role {
    private String id;
    private Long createTime = System.currentTimeMillis();
    private Boolean isRemoved = false;
    private String name;
    private String nickName;
    private String description;
    private Boolean builtIn =false;
    private Boolean banned = false;
    private String proposer;
    private List<JsonPermissions.SimplePermission> permissions;

    public void setName(String name) {
        if(name.indexOf("ROLE_") != 1){
            this.name = "ROLE_" + name;
        }else{
            this.name = name;
        }
    }
}
