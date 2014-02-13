package org.schedulerjms.infrastructure.quartzscheduler.jobscheduler;

import org.json.JSONObject;
import org.quartz.SchedulerException;

/**
 * Created by dSklyarenko on 10.02.14.
 */
public interface JobScheduler {

    public void addPointJob(JSONObject jsonObject);

    public void addPeriodicJob(JSONObject jsonObject);

    public void deleteJob(JSONObject jsonObject);

}
