package org.schedulerjms.infrastructure.sender;

import org.json.JSONObject;
import org.schedulerjms.infrastructure.domain.JSONMessage;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public interface MessageSender {

    public void sendMessage(String destinationName, JSONMessage jsonMessage);

}
