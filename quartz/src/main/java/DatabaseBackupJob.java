import org.quartz.*;

/**
 * @ClassName: DatabaseBackupJob
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 15:40
 * @Version: 1.0
 */
@DisallowConcurrentExecution
public class DatabaseBackupJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String database = jobDetail.getJobDataMap().getString("database");
        System.out.printf("%s数据库备份要10秒\n",database);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
