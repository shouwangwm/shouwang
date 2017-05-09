package com.test.service.springdemo;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
/**
 * 消息生产者
 * @author: weiming
 * @date: 2017年2月22日
 */
@Component
public class ProducerServiceImpl implements ProducerService {
 
    private JmsTemplate jmsTemplate;
    
    /**
     * 发送消息
     * @data	2017年2月22日
     * @author	weiming
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message) {
        if(destination == null){
            destination = jmsTemplate.getDefaultDestination();
        }
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    } 

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    } 

    @Resource
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
 
}
