import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: TestDirectCustomer
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 11:40
 * @Version: 1.0
 */
public class TestDirectCustomer {
    //声明队列名称
    public final static String QUEUE_NAME = "queue_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil.checkServer();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明要关注的队列
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
