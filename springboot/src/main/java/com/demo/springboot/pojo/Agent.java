package com.demo.springboot.pojo;

import lombok.Data;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Agent
 * @date : Create in 2019/10/19 16:23
 */
@Data
public class Agent {
    private String AGENT_CODE;
    private String AGENT_NAME;
    private String BSS_ORG_ID;
    private String BEGIN_TIME;
    private String END_TIME;
    private String LAST_VS_DATE;
    private String FTP_HOST;
    private String FTP_USER;
    private String FTP_PASSWORD;
    private String FTP_DEC_DIR;
    private String PRINT_FLAG;
    private String STAFF_ID_NEW;
    private String FTP_PUT_DIR;
    private String vs_task_id;
    private String vs_file_name;
    private String STAFF_ID_OLD;
}
