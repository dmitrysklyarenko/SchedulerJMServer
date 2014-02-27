package org.schedulerjms.infrastructure.quartzhandler;

import org.quartz.SchedulerException;
import org.schedulerjms.model.Rule;

import java.util.Date;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public interface QuartzHandler {

    public void createPointJob(Rule rule, Date startDate, String destinationName) throws Exception;

    public void createPeriodicJob(Rule rule, Date startDate, int period, String destinationName) throws SchedulerException;

    public void deleteJob(Rule rule) throws SchedulerException;
}
