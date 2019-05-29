import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: TestTopicProducer
 * @Author: zhanghongkai
 * @Date: Create in 2019/5/29 11:20
 * @Version: 1.0
 */
public class TestTopicProducer {
    public final static String EXCHANGE_NAME = "exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQUtil.checkServer();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String[] routings = new String[]{"usa.news","china.news","usa.weather","china.weather"};
        String[] messages = new String[]{"美国新闻","中国新闻","美国天气","中国天气"};
        for(int i=0;i<4;i++){
            channel.basicPublish(EXCHANGE_NAME, routings[i], null, messages[i].getBytes());
        }
        channel.close();
        connection.close();
    }
}
