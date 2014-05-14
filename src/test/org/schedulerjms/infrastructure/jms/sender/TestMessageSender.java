package org.schedulerjms.infrastructure.jms.sender;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by dSklyarenko on 14.05.14.
 */
public class TestMessageSender {

    @Test
    public void testSendMessage() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory);
        MessageSenderImpl messageSender = new MessageSenderImpl();
        messageSender.setJmsTemplate(jmsTemplate);
        JSONObject jsonObject = new JSONObject().put("keyA", "valueA");
        messageSender.sendMessage("testQueue", jsonObject);
        TextMessage textMessage = (TextMessage) jmsTemplate.receive("testQueue");
        String value = textMessage.getText();
        assertTrue(value.equals(jsonObject.toString()));
    }
}
