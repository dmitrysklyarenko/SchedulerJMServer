package org.schedulerjms.service;

import javax.jms.JMSException;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public interface AppService {

    public void sendMessage();

    public void receiveMessage() throws JMSException;

}
