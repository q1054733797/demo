package com.demo.springboot;

import com.demo.springboot.enmu.TestEnum;

/**
 * @ClassName: Test04
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/23 10:24
 * @Version: 1.0
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println(TestEnum.SUCCESS.getDesc());
        TestEnum[] values = TestEnum.values();
        for (TestEnum value : values) {
            System.out.println(value.getDesc());
        }
        System.out.println(TestEnum.valueOf("SUCCESS").getName());
    }
}
