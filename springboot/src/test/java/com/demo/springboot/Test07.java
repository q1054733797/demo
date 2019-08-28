package com.demo.springboot;

import com.demo.springboot.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @ClassName: Test07
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/8 15:34
 * @Version: 1.0
 */
@Slf4j
public class Test07{
    private static char isOk;

    public static void main(String[] args){
        for(int i=0;i<20;i++){
            System.out.println("i=" + i);
        }
        System.out.println(123);
    }
}
