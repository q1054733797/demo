import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MailJob
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 15:10
 * @Version: 1.0
 */
public class MailJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail = jobExecutionContext.getJobDetail();
        String email = detail.getJobDataMap().getString("email");
        String name = detail.getJobDataMap().getString("name");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.printf("给%s的邮件地址%s发送了一封邮件，当前时间是%s\n",name,email,sdf.format(new Date()));
    }
}
