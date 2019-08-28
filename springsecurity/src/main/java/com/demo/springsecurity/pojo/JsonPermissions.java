package com.demo.springsecurity.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: JsonPermissions
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 9:12
 * @Version: 1.0
 */
@Data
public class JsonPermissions {
    private List<SimplePermission> permissions;

    @Data
    public static class SimplePermission{
        private String resourceId;
        private String resoreceName;
        private Map<String,String> privileges;
        private boolean abandon = false;
    }
}
