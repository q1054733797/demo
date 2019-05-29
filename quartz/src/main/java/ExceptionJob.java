import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName: ExcepetionJob
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 15:46
 * @Version: 1.0
 */
public class ExceptionJob implements Job {
    int i = 0;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        try {
            System.out.println(100/i);
        }catch (Exception e){
            JobExecutionException exception = new JobExecutionException(e);
//            System.out.println("发生异常，取消调度");
//            exception.setUnscheduleAllTriggers(true);
            System.out.println("发生异常，重新调度");
            i = 1;
            exception.setRefireImmediately(true);
            throw exception;
        }
    }
}
