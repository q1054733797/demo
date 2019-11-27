package com.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.mapper.BankMapper;
import com.demo.springboot.mapper.CheckMapper;
import com.demo.springboot.pojo.Agent;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : BankCheckDeploy
 * @date : Create in 2019/9/19 16:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BankCheckDeploy {
    @Autowired
    private CheckMapper checkMapper;

    @Autowired
    private BankMapper bankMapper;

    @Test
    public void importByTxt() throws IOException {
        //银行代码  工号 名称
        File file = new File("F:/银行.txt");
        Reader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"));
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.lines().forEach(line -> {
            String[] split = line.split(",");
            //addBusi(split[0],split[1]);
        });
    }

    @Test
    public void readExcel() throws IOException {
        File file = new File("F:/3.0系统银行对账名单.xlsx");
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        String bankName = null;
        String staffId = null;
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        for(int i = 1;i < physicalNumberOfRows;i++){
            row = sheet.getRow(i);
            if(!row.getZeroHeight()){
                bankName = row.getCell(1).getStringCellValue();
                staffId = decimalFormat.format(row.getCell(2).getNumericCellValue());
                System.out.println(staffId);
                importByExcel(staffId,bankName);
            }
        }
    }

    @Test
    public void addMod(){
        //获取需要添加平账信息列表
        List<HashMap<String, Object>> addModList = checkMapper.getAddModList();
        for (HashMap<String, Object> map : addModList) {
            //获取平账序列
            String modId = checkMapper.getModId();
            //添加平账信息
            checkMapper.addCheckMod(modId,map.get("busi_id").toString(), map.get("busi_name").toString());
            //添加平账信息参数
            checkMapper.addCheckModParam(modId, map.get("paymentIdTableFieldId").toString(), map.get("acctIdTableFieldId").toString());
        }
    }

    @Test
    public void updateStaffId(){
        List<Agent> agentInfos = bankMapper.getAgentInfos();
        for (Agent agentInfo : agentInfos) {
            bankMapper.updateStaffId(agentInfo);
        }
    }

    @Test
    public void setNewStaffId() throws IOException {
        List<Agent> newStaffIdisOnw = bankMapper.getNewStaffIdisOnw();
        HashMap<String, String> staffIdCodeMap = getStaffIdCodeMap();
        String staffCode = null;
        String newStaffId = null;
        for (Agent agent : newStaffIdisOnw) {
            staffCode = staffIdCodeMap.get(agent.getSTAFF_ID_OLD());
            newStaffId = bankMapper.getNewStaffId(staffCode);
            bankMapper.updateNewStaffId(agent.getSTAFF_ID_OLD(), newStaffId);
        }
    }

    @Test
    public void updateBankCheckStaffId(){
        List<HashMap<String, Object>> bankCheckStaffId = checkMapper.getBankCheckStaffId();
        for (HashMap<String, Object> map : bankCheckStaffId) {
            checkMapper.updateBankCheckStaffId(map.get("MOD_PARAMETER_ID").toString(), map.get("STAFF_ID_NEW").toString());
        }
    }

    @Test
    public void addFilterValue(){
        List<String> tableIds = checkMapper.getTableIds();
        log.info("size-->" + tableIds.size());
        for (String tableId : tableIds) {
            checkMapper.addWhereCount(tableId);
        }
    }

    public HashMap<String,String> getStaffIdCodeMap() throws IOException {
        File file = new File("F:/3.0系统银行对账名单.xlsx");
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        String staffId = null;
        String staffCode = null;
        HashMap<String,String> map = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        for(int i = 1;i < physicalNumberOfRows;i++){
            row = sheet.getRow(i);
            if(!row.getZeroHeight()){
                try {
                    staffId = row.getCell(2).getStringCellValue();
                } catch (Exception e) {
                    staffId = decimalFormat.format(row.getCell(2).getNumericCellValue());
                }
                try {
                    staffCode = row.getCell(3).getStringCellValue();
                } catch (Exception e) {
                    staffCode = decimalFormat.format(row.getCell(3).getNumericCellValue());
                }
                map.put(staffId, staffCode);
            }
        }
        return map;
    }

    public void importByExcel(String staffId,String bankName){
        //截取regionName
        String regionName = bankName.substring(0,2);
        //通过regionName获取regionID
        String regionID = checkMapper.getRegionID(regionName);
        //重组bankName
        //bankName = regionName + "_" + bankName;
        //导入
        addBusi(bankName,regionID,staffId);
    }

    private void addBusi(String bankName,String regionId,String staffId){
        Integer checkBusiId = checkMapper.getCheckBusiId();
        checkMapper.addCheckBusi(checkBusiId, bankName, regionId);
        Integer checkFileId = checkMapper.getCheckFileId();
        checkMapper.addCheckBusiDataRel(checkBusiId, checkFileId,1,1);
        checkMapper.addCheckFile(checkFileId);
        checkMapper.addCheckFileField(checkFileId);
        Integer checkTableId = checkMapper.getCheckTableId();
        checkMapper.addCheckBusiDataRel(checkBusiId, checkTableId,2,2);
        checkMapper.addCheckTable(checkTableId);
        checkMapper.addCheckTableField(checkTableId,staffId);
    }
}
