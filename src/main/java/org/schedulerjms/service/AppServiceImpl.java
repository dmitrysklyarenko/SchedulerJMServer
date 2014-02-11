package org.schedulerjms.service;

import org.json.JSONObject;
import org.schedulerjms.infrastructure.jms.receiver.MessageReceiver;
import org.schedulerjms.infrastructure.jms.sender.MessageSender;
import org.schedulerjms.infrastructure.json.JSONObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import java.util.Date;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public class AppServiceImpl implements AppService {

    @Autowired
    private MessageReceiver messageReceiver;
    @Autowired
    private MessageSender messageSender;


    public void sendMessage() {
        System.out.println("SENDING MESSAGE");
        JSONObjectFactory jsonObjectFactory = new JSONObjectFactory();
        JSONObject jsonObject = jsonObjectFactory.addPeriodicJob("category2", 2, new Date(343333333));
        messageSender.sendMessage("QQQ1", jsonObject);
        System.out.println(jsonObject);
    }

    public void receiveMessage() throws JMSException {
        System.out.println("RECEIVING MESSAGE");
        JSONObject jsonObject = messageReceiver.receiveMessage("QQQ1");
        System.out.println(jsonObject);

    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void setMessageReceiver(MessageReceiver messageReceiver) {this.messageReceiver = messageReceiver;}
}
