package com.demo.practice.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName: Test
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/13 14:12
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);
        Date date = new Date(timestamp.getTime());
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(date));
    }
}
