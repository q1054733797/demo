package com.demo.springboot;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test25
 * @date : Create in 2019/10/30 17:30
 */
@Slf4j
public class Test25 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/无标题.xlsx");
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        String servId = null;
        String acctItemTypeId = null;
        String charge = "4.5";
        String billingCycleId = "11910";
        List<String> lines = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        for(int i = 0;i < physicalNumberOfRows;i++){
            row = sheet.getRow(i);
            if(!row.getZeroHeight()){
                servId = decimalFormat.format(row.getCell(0).getNumericCellValue());
                acctItemTypeId = decimalFormat.format(row.getCell(1).getNumericCellValue());
                //charge = decimalFormat.format(row.getCell(2).getNumericCellValue());
                //lines.add(StringUtils.joinWith());
                lines.add(StringUtils.joinWith(",",servId,acctItemTypeId,charge,billingCycleId));
            }
        }
        System.out.println(lines.size());
        File targetFile = new File("F:/调账.txt");
        FileUtils.writeLines(targetFile, "UTF-8", lines, "\r\n", true);
    }
}
