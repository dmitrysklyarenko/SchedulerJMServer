package org.schedulerjms.service;

import org.quartz.SchedulerException;
import org.schedulerjms.infrastructure.quartzhandler.QuartzHandler;
import org.schedulerjms.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class AppServiceImpl implements AppService {

    @Autowired
    private QuartzHandler quartzHandler;

    @Override
    public void addPointRule(Rule rule, Date startDate, String destinationName) throws Exception {
        quartzHandler.createPointJob(rule, startDate, destinationName);
    }

    @Override
    public void addPeriodicRule(Rule rule, Date startDate, int period, String destinationName) throws SchedulerException {
        quartzHandler.createPeriodicJob(rule, startDate, period, destinationName);
    }

    @Override
    public void deleteRule(Rule rule) throws SchedulerException {
        quartzHandler.deleteJob(rule);
    }

    public void setQuartzHandler(QuartzHandler quartzHandler) {
        this.quartzHandler = quartzHandler;
    }
}
