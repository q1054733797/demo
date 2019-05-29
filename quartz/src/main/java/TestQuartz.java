import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @ClassName: TestQuartz
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 15:03
 * @Version: 1.0
 */
public class TestQuartz {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        try {
            test01();
        }catch (Exception e){
            System.out.println("检测到异常");
            resumeJobFromDatabase();
        }
    }

    public static void resumeJobFromDatabase() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        // 等待200秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(200000);
        scheduler.shutdown(true);
    }

    public static void test02() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //Date startTime = DateBuilder.nextGivenSecondDate(null, 8);
        Date startTime = DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND);
        JobDetail job = newJob(MailJob.class)
                .withIdentity("mailJob", "mailGroup")
                .build();
        job.getJobDataMap().put("email", "1054733797@qq.com");
        job.getJobDataMap().put("name", "张鸿凯");
        SimpleTrigger trigger = (SimpleTrigger)newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(startTime)
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

    public static void test01() throws SchedulerException, InterruptedException {
        int i = 0;
        int b = 100/i;
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(10))
                .build();
        JobDetail job = newJob(MailJob.class)
                .withIdentity("mailjob1", "mailgroup1")
                .build();
        job.getJobDataMap().put("email", "1054733797@qq.com");
        job.getJobDataMap().put("name", "张鸿凯");
        scheduler.scheduleJob(job,trigger);
        scheduler.start();
        Thread.sleep(20000);
        scheduler.shutdown(true);
    }
}
