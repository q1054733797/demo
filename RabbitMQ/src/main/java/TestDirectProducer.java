import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: TestDirectPorducer
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 11:39
 * @Version: 1.0
 */
public class TestDirectProducer {
    //声明队列名称
    public final static String QUEUE_NAME = "queue_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil.checkServer();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String message = null;
        for(int i=0;i<50;i++){
            message = "message" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
