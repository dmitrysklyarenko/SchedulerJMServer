package org.schedulerjms.infrastructure.jms.receiver;

import org.json.JSONObject;

import javax.jms.JMSException;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public interface MessageReceiver {

    public JSONObject receiveMessage(String destinationName) throws JMSException;

}
