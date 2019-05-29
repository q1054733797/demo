import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: TestFanoutCustomer
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 10:59
 * @Version: 1.0
 */
public class TestFanoutCustomer {
    //声明交换机名称
    public final static String EXCHANGE_NAME = "exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        //检查服务器是否开启
        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置地址
        factory.setHost("localhost");
        //获取连接
        Connection connection = factory.newConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //为通道设置交换机名称，交换机类别
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //获取临时队列
        String queueName = channel.queueDeclare().getQueue();
        //通道绑定队列
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        //接收消息
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        };
        //回复机制，表示收到信息
        channel.basicConsume(queueName, true, consumer);
    }
}
