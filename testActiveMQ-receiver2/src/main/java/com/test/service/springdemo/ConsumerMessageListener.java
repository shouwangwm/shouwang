package com.test.service.springdemo;
 
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 消息监听器，接收消息
 * @author: weiming
 * @date: 2017年2月22日
 */
public class ConsumerMessageListener implements MessageListener {
 
    public void onMessage(Message message) {
        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
        TextMessage tm = (TextMessage) message;
        try {
        	 System.out.println(getClass().getName() + "---------消息消费---------");
             System.out.println("消息内容:\t" + tm.getText());
             System.out.println("消息ID:\t" + tm.getJMSMessageID());
             System.out.println("消息Destination:\t" + tm.getJMSDestination());
             System.out.println("---------更多信息---------");
             System.out.println(tm.toString());
             System.out.println("-------------------------");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
 
}