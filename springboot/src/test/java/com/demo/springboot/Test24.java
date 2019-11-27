package com.demo.springboot;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test24
 * @date : Create in 2019/10/5 11:08
 */
@Slf4j
public class Test24 {

    public static void main(String[] args) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("137.0.24.21", 21);
        ftpClient.login("bank", "bank123");
//        File file = new File("F:/test.txt");
//        OutputStream outputStream = new FileOutputStream(file);
//        System.out.println(ftpClient.retrieveFile("/bankn/N0531T20191022V", outputStream));
        FTPFile[] ftpFiles = ftpClient.listFiles();
        for (FTPFile ftpFile : ftpFiles) {
            System.out.println(ftpFile.toFormattedString());
            System.out.println(ftpFile.getName());
        }
    }
}
