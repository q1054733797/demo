package com.demo.springboot;

import com.demo.springboot.annotation.TestAnnotation;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: Test02
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/24 14:24
 * @Version: 1.0
 */
@TestAnnotation(username = "admin",password = "123456",type = Test02.class)
public class Test02 {
    public static void main(String[] args){
        TestAnnotation annotation = Test02.class.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.username());
        System.out.println(annotation.password());
        System.out.println(annotation.type());
    }
}
