package com.demo.springboot.enmu;

/**
 * @ClassName: TestEnum
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/23 10:17
 * @Version: 1.0
 */
public enum TestEnum {
    SUCCESS("1","成功"),FAILED("2", "失败");

    TestEnum(String value, String desc) {
        this.name = value;
        this.desc = desc;
    }

    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
