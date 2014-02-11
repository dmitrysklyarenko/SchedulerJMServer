package org.schedulerjms.infrastructure.jms.sender;

import org.json.JSONObject;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public interface MessageSender {

    public void sendMessage(String destinationName, JSONObject jsonObject);

}
