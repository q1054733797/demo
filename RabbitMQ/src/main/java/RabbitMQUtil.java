import cn.hutool.core.util.NetUtil;

import javax.swing.*;

/**
 * @ClassName: RabbitMQUtil
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 9:53
 * @Version: 1.0
 */
public class RabbitMQUtil {
    public static void main(String[] args) {
        checkServer();
    }

    public static void checkServer(){
        if(NetUtil.isUsableLocalPort(15672)){
            JOptionPane.showMessageDialog(null, "服务器未启动");
            System.exit(1);
        }
    }
}
