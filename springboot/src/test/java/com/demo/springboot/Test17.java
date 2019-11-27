package com.demo.springboot;

import cn.hutool.crypto.digest.DigestUtil;
import com.demo.springboot.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test17
 * @date : Create in 2019/9/26 21:35
 */
@Slf4j
public class Test17 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("F:/银行-代码.txt");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream,"GBK");
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.lines().forEach(line -> {
            String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens(line, ",");
            log.debug(strings[0] + "--" + strings[1]);
        });
    }
}
