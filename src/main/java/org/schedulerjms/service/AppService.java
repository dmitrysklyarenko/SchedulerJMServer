package org.schedulerjms.service;

import org.quartz.SchedulerException;
import org.schedulerjms.model.Rule;

import java.util.Date;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public interface AppService {

    public void addPointRule(Rule rule, Date startDate, String destinationName) throws Exception;

    public void addPeriodicRule(Rule rule, Date startDate, int period, String destinationName) throws SchedulerException;

    public void deleteRule(Rule rule) throws SchedulerException;
}
