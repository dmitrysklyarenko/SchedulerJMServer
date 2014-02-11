package org.schedulerjms.infrastructure.jms.receiver;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by dSklyarenko on 10.02.14.
 */
public class MessageReceiverImpl implements MessageReceiver {

    @Autowired
    private JmsTemplate jmsTemplate;

    public MessageReceiverImpl() {    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public JSONObject receiveMessage(String destinationName) throws JMSException {
        Message message = jmsTemplate.receive(destinationName);
        JSONObject jsonObject= null;
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            jsonObject = new JSONObject(text);

        }
        return jsonObject;
    }

}
