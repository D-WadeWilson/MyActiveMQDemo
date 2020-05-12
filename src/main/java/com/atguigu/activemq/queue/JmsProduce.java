package com.atguigu.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    //  linux 上部署的activemq 的 IP 地址 + activemq 的端口号，如果用自己的需要改动
    public static final String ACTIVEMQ_URL = "tcp://192.168.17.3:61616";
    // public static final String ACTIVEMQ_URL = "nio://192.168.17.3:61608";
    public static final String QUEUE_NAME = "jdbc01";
    public static void main(String[] args) throws JMSException {
        //1 创建连接工场，按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2 通过连接工厂，获得连接Connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3 创建会话session
        //两个参数，第一个叫事务/第二个叫签收
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //4 创建目的地（具体是队列还是主题topic）
        Queue queue  = session.createQueue(QUEUE_NAME);
        //5 创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //6 通过使用messageProducer生产3条消息发送到MQ的队列里面

    }
}
