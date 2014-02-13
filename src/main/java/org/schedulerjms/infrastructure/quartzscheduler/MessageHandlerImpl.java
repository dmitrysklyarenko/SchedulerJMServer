package org.schedulerjms.infrastructure.quartzscheduler;

import org.json.JSONObject;
import org.schedulerjms.infrastructure.quartzscheduler.jobscheduler.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dSklyarenko on 13.02.14.
 */
public class MessageHandlerImpl implements MessageHandler {

    @Autowired
    JobScheduler jobScheduler;

    public void handleMessage(JSONObject jsonObject) {
        String command = jsonObject.getString("command");
        String jobType = jsonObject.getString("jobType");

        if(command.equals("add") && jobType.equals("point")) {
            jobScheduler.addPointJob(jsonObject);
        }

        if(command.equals("add") && jobType.equals("periodic")) {
            jobScheduler.addPeriodicJob(jsonObject);
        }

        if(command.equals("delete")) {
            jobScheduler.deleteJob(jsonObject);
        }
    }

}
