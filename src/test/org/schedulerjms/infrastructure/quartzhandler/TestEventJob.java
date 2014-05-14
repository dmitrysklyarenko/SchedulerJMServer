package org.schedulerjms.infrastructure.quartzhandler;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.quartz.JobExecutionContext;
import org.quartz.impl.JobExecutionContextImpl;
import org.schedulerjms.infrastructure.jms.sender.MessageSenderImpl;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by dSklyarenko on 14.05.14.
 */
public class TestEventJob {

    @Test
    public void testExecute() {

    }

}
