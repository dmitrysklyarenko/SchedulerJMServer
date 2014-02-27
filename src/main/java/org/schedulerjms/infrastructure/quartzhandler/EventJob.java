package org.schedulerjms.infrastructure.quartzhandler;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;
import org.quartz.*;
import org.schedulerjms.infrastructure.jms.sender.MessageSender;
import org.schedulerjms.infrastructure.jms.sender.MessageSenderImpl;
import org.schedulerjms.springfactory.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class EventJob implements Job {

//    @Autowired
//    @Qualifier("messageSender")
    //   private ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
    // private JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory);

    private MessageSender messageSender;// = new MessageSenderImpl();

    public EventJob() {
        messageSender = (MessageSender) SpringFactory.getBean("messageSender");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String category = dataMap.getString("category");
        int ID = dataMap.getInt("ID");
        String destinationName = dataMap.getString("destinationName");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", category);
        jsonObject.put("ID", ID);
        System.out.println(destinationName);

        messageSender.sendMessage(destinationName, jsonObject);
    }

}
