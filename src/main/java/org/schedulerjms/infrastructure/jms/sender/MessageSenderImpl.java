package org.schedulerjms.infrastructure.jms.sender;

import org.json.JSONObject;
import org.schedulerjms.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by dSklyarenko on 26.02.14.
 */
public class MessageSenderImpl implements MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destinationName, final JSONObject jsonObject) {
        System.out.println(destinationName);
        MessageCreator creator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(jsonObject.toString());
                return message;
            }
        };

        jmsTemplate.send(destinationName, creator);
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

}
