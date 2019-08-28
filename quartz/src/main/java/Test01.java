import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @ClassName: Test01
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/5 16:17
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("触发器", "触发器1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(10)
                        .withRepeatCount(10))
                .build();
        JobDetail jobDetail = JobBuilder.newJob(MailJob.class)
                .withIdentity("邮箱任务", "邮箱任务组1")
                .usingJobData("email", "1054733797@qq.com")
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
