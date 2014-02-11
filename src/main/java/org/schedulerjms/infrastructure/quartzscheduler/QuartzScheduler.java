package org.schedulerjms.infrastructure.quartzscheduler;

import org.json.JSONObject;
import org.quartz.SchedulerException;

/**
 * Created by dSklyarenko on 10.02.14.
 */
public interface QuartzScheduler {

    public void addPointJob(JSONObject jsonObject);

    public void addPeriodicJob(JSONObject jsonObject);

    public void deleteJob(JSONObject jsonObject);

}
