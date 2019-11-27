package com.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.mapper.AgentMapper;
import com.demo.springboot.mapper.BankMapper;
import com.demo.springboot.mapper.CheckMapper;
import com.demo.springboot.pojo.Agent;
import com.demo.springboot.pojo.Bank;
import org.apache.commons.lang3.StringUtils;
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
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : AgentDeploy
 * @date : Create in 2019/10/19 16:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AgentDeploy {
    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private AgentMapper agentMapper;

    @Test
    public void test01(){
        //查询银行名称
        List<Bank> bankNames = bankMapper.getBankNames();
        System.out.println("银行数-->" + bankNames.size());
        //通过银行名称查出旧staffID
        String bankStaffId = null;
        Agent agentInfo = null;
        for (Bank bank : bankNames) {
//            bankStaffId  = agentMapper.getBankStaffId(bankName);
//            if(StringUtils.isBlank(bankStaffId)){
//                throw new RuntimeException("无法通过银行名称找到工号");
//            }
//            System.out.println(bankName + "-->" + bankStaffId);
            //根据银行名找出数据
            agentInfo = agentMapper.getAgentInfo(bank.getBankName());
            if(agentInfo != null){
                agentInfo.setVs_task_id(bank.getBankID());
                agentInfo.setVs_file_name(agentInfo.getAGENT_CODE() + "T%Y%M%DV");
                //插入新a_agent表
//            System.out.println(JSON.toJSONString(agentInfo));
                bankMapper.addAgent(agentInfo);
            }
        }

    }

    @Test
    public void updateCheckFile(){
        List<Agent> agentInfos = bankMapper.getAgentInfos();
        String fileId = null;
        for (Agent agentInfo : agentInfos) {
            fileId = bankMapper.getFileId(agentInfo.getAGENT_NAME());
            System.out.println(fileId);
            agentInfo.setVs_task_id(fileId);
            bankMapper.updateBank(agentInfo);
        }
    }

    @Test
    public void addAgent(){
        List<Bank> banks = bankMapper.getBankNames();
        Agent agentInfo = null;
        for (Bank bank : banks) {
            agentInfo = agentMapper.getAgentInfo(bank.getBankName());
            agentInfo.setVs_task_id(bank.getBankID());
            agentInfo.setVs_file_name(agentInfo.getAGENT_CODE() + "T%Y%M%DV");
            agentInfo.setSTAFF_ID_NEW("1");
            bankMapper.addAgent(agentInfo);
        }

    }

    @Test
    public void updateStaffIdNew() throws IOException {
        File file = new File("F:/3.0系统银行对账名单.xlsx");
        InputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        Row row = null;
        String staffId = null;
        String staffCode = null;
        String newStaffId = null;
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        for(int i = 1;i < physicalNumberOfRows;i++){
            row = sheet.getRow(i);
            if(!row.getZeroHeight()){
                staffId = decimalFormat.format(row.getCell(2).getNumericCellValue());
                try {
                    staffCode = row.getCell(3).getStringCellValue();
                } catch (Exception e) {
                    staffCode = decimalFormat.format(row.getCell(2).getNumericCellValue());
                }
                newStaffId = bankMapper.getNewStaffId(staffCode);
                if(StringUtils.isNotBlank(newStaffId)){
                    bankMapper.updateNewStaffId(staffId,newStaffId);
                }
            }
        }
    }
}
