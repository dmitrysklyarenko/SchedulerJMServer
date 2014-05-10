package org.schedulerjms.infrastructure.quartzhandler;

import org.quartz.SchedulerException;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public interface QuartzHandler {

    public void createPointJob(PointRule pointRule) throws Exception;

    public void createPeriodicJob(PeriodicRule periodicRule) throws SchedulerException;

    public void deleteJob(String uniqueId) throws SchedulerException;
}
