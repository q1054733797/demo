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
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String email = jobDetail.getJobDataMap().getString("email");
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(date + "向邮箱" + email + "发送了一封邮件");
    }
}
