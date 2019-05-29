import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: TestFanoutProducer
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 10:58
 * @Version: 1.0
 */
public class TestFanoutProducer {
    //生命交换机名称
    public final static String EXCHANGE_NAME = "exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        //检查服务器是否启动
        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置地址
        factory.setHost("localhost");
        //获取连接
        Connection connection = factory.newConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //设置通道的交换机名称，交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = null;
        for(int i=0;i<50;i++){
            message = "message" + i;
            //发送消息
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
