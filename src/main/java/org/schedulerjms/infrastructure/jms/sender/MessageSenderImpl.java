package org.schedulerjms.infrastructure.jms.sender;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public class MessageSenderImpl implements MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public MessageSenderImpl() {}

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destinationName, final JSONObject jsonObject) {
        MessageCreator creator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(jsonObject.toString());
                return message;
            }
        };
        jmsTemplate.send(destinationName, creator);
    }
}
