package org.schedulerjms.infrastructure.quartzscheduler.jobscheduler;

import org.json.JSONObject;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.quartz.JobBuilder.newJob;

/**
 * Created by dSklyarenko on 10.02.14.
 */
public class JobSchedulerImpl implements JobScheduler {

    @Autowired
    private SchedulerFactory schedulerFactory;

    public JobSchedulerImpl() { }

    public void setSchedulerFactory(SchedulerFactory schedulerFactory) {
        this.schedulerFactory = schedulerFactory;
    }

    public void addPointJob(JSONObject jsonObject){

    }

    public void addPeriodicJob(JSONObject jsonObject) {

    }

    public void deleteJob(JSONObject jsonObject) {

    }


}
