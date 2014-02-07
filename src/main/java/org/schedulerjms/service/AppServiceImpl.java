package org.schedulerjms.service;

import org.json.JSONObject;
import org.schedulerjms.infrastructure.domain.JSONMessage;
import org.schedulerjms.infrastructure.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public class AppServiceImpl implements AppService {

    @Autowired
    private MessageSender messageSender;

    public void sendMessage() {
        JSONMessage jsonMessage = new JSONMessage();
        jsonMessage.put("testkey", "testtext");
        messageSender.sendMessage("Qidea", jsonMessage);
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
}
