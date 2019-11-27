package com.demo.springboot;

import com.demo.springboot.pojo.BatchConferInfo;
import com.demo.springboot.pojo.ImpBatchConferReq;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test26
 * @date : Create in 2019/11/8 0:40
 */
public class Test26 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/无标题.xlsx");
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        StringBuilder stringBuilder = new StringBuilder();
        String acctId,acctItemTypeId,amount,billingCycleId;
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        for(int i = 1;i < physicalNumberOfRows;i++){
            row = sheet.getRow(i);
            if(!row.getZeroHeight()){
                acctId = decimalFormat.format(row.getCell(2).getNumericCellValue());
                acctItemTypeId = decimalFormat.format(row.getCell(7).getNumericCellValue());
                amount = decimalFormat.format(row.getCell(10).getNumericCellValue());
                //amount = String.valueOf();
                amount = decimalFormat.format(Double.valueOf("-" + amount) / 100);
                billingCycleId = decimalFormat.format(row.getCell(6).getNumericCellValue());
                stringBuilder.append(StringUtils.joinWith(",",acctId,acctItemTypeId,amount,billingCycleId) + "\r\n");
            }
        }
        file = new File("F:/调账.txt");
        FileUtils.writeStringToFile(file, stringBuilder.toString(), "UTF-8");
    }
}
