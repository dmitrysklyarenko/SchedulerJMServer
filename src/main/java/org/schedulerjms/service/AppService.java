package org.schedulerjms.service;

import org.quartz.SchedulerException;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public interface AppService {

    public void addPointRule(PointRule pointRule) throws Exception;

    public void addPeriodicRule(PeriodicRule periodicRule) throws SchedulerException;

    public void deleteRule(String uniqueId) throws SchedulerException;
}
