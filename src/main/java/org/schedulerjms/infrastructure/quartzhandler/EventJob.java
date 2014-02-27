package org.schedulerjms.infrastructure.quartzhandler;

import org.json.JSONObject;
import org.quartz.*;
import org.schedulerjms.infrastructure.jms.sender.MessageSender;
import org.schedulerjms.springfactory.*;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class EventJob implements Job {

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
