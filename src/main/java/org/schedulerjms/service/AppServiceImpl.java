package org.schedulerjms.service;

import org.quartz.SchedulerException;
import org.schedulerjms.infrastructure.quartzhandler.QuartzHandler;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class AppServiceImpl implements AppService {

    @Autowired
    private QuartzHandler quartzHandler;

    @Override
    public void addPointRule(PointRule pointRule) throws Exception {
        quartzHandler.createPointJob(pointRule);
    }

    @Override
    public void addPeriodicRule(PeriodicRule periodicRule) throws SchedulerException {
        quartzHandler.createPeriodicJob(periodicRule);
    }

    @Override
    public void deleteRule(String uniqueId) throws SchedulerException {
        quartzHandler.deleteJob(uniqueId);
    }

    public void setQuartzHandler(QuartzHandler quartzHandler) {
        this.quartzHandler = quartzHandler;
    }
}
