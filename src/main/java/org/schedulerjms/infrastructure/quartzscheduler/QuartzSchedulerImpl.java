package org.schedulerjms.infrastructure.quartzscheduler;

import org.json.JSONObject;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.quartz.JobBuilder.newJob;

/**
 * Created by dSklyarenko on 10.02.14.
 */
public class QuartzSchedulerImpl implements QuartzScheduler {

    @Autowired
    private SchedulerFactory schedulerFactory;

    public QuartzSchedulerImpl() { }

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
