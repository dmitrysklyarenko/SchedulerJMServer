package org.schedulerjms.infrastructure.sender;

import org.json.JSONObject;
import org.schedulerjms.infrastructure.domain.JSONMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

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

    public void sendMessage(String destinationName, final JSONMessage jsonMessage) {
        MessageCreator creator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage();
                message.setObject(jsonMessage);
                return message;
            }
        };
        jmsTemplate.send(destinationName, creator);
    }


}
