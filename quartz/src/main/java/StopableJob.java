import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * @ClassName: StopableJob
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 15:54
 * @Version: 1.0
 */
public class StopableJob implements InterruptableJob {
    boolean stop = false;
    public void interrupt() throws UnableToInterruptJobException {
        stop = true;
        System.out.println("任务被叫停");
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        while (true){
            if(stop){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("持续工作中");
        }
    }
}
