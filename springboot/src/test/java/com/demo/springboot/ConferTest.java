package com.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.pojo.BatchConferInfo;
import com.demo.springboot.pojo.ImpBatchAdjustReq;
import com.demo.springboot.pojo.ImpBatchConferReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
 * @ClassName : ConferTest
 * @date : Create in 2019/11/21 10:19
 */
@Slf4j
public class ConferTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/confer.xlsx");
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        ImpBatchConferReq req = new ImpBatchConferReq();
        List<BatchConferInfo> batchConferInfos = new ArrayList<>();
        req.setConferInfos(batchConferInfos);
        BatchConferInfo batchConferInfo = null;
        String batchId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        for(int i = 1;i < physicalNumberOfRows;i++){
            row = sheet.getRow(i);
            if(!row.getZeroHeight()){
                batchConferInfo = new BatchConferInfo();
                batchConferInfo.setBatchID(batchId);
                batchConferInfo.setStaffCode("13393");
                batchConferInfo.setAccNbr(decimalFormat.format(row.getCell(0).getNumericCellValue()));
                batchConferInfo.setAmount(decimalFormat.format(row.getCell(1).getNumericCellValue()));
                batchConferInfo.setBalanceTypeId(decimalFormat.format(row.getCell(2).getNumericCellValue()));
                batchConferInfo.setItemGroupID(decimalFormat.format(row.getCell(3).getNumericCellValue()));
                batchConferInfo.setObjTypeId(decimalFormat.format(row.getCell(4).getNumericCellValue()));
                batchConferInfo.setEffDate(row.getCell(6).getStringCellValue());
                batchConferInfo.setExpDate(row.getCell(7).getStringCellValue());
                batchConferInfos.add(batchConferInfo);
            }
        }
        log.info("需要调账的条数" + batchConferInfos.size());
        log.info(JSON.toJSONString(req));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://137.0.245.146:8191/billsrv/local/acctOA/impBatchConfer";
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(req), "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        log.info("响应类型:" + response.getStatusLine());
        log.info("响应长度:" + entity.getContentLength());
        log.info("响应内容:" + EntityUtils.toString(entity));
    }
}
