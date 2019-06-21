package com.demo.springdata.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * @ClassName: ScheduledTask
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/6 16:08
 * @Version: 1.0
 */
@Component
public class ScheduledTask {
    private int i = 0;

    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        System.out.println("定时任务运行第" + i + "次运行,时间是:" +
                DateFormat.getDateTimeInstance().format(new Date()));
        i++;
    }
}
