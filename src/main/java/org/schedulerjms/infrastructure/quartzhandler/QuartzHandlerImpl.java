package org.schedulerjms.infrastructure.quartzhandler;


import org.quartz.*;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;
import org.springframework.beans.factory.annotation.Autowired;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class QuartzHandlerImpl implements QuartzHandler {

    @Autowired
    private SchedulerFactory schedulerFactory;

    @Override
    public void createPointJob(PointRule pointRule) throws Exception {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = newJob(EventJob.class)
                .withIdentity(pointRule.getUniqueId())
                .usingJobData("category", pointRule.getCategory())
                .usingJobData("ID", pointRule.getID())
                .usingJobData("destinationName", pointRule.getDestinationName())
                .build();
        Trigger trigger = newTrigger()
                .withIdentity(pointRule.getUniqueId())
                .startAt(pointRule.getStartDate())
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void createPeriodicJob(PeriodicRule periodicRule) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = newJob(EventJob.class)
                .withIdentity(periodicRule.getUniqueId())
                .usingJobData("category", periodicRule.getCategory())
                .usingJobData("ID", periodicRule.getID())
                .usingJobData("destinationName", periodicRule.getDestinationName())
                .build();
        Trigger trigger = newTrigger()
                .withIdentity(periodicRule.getUniqueId())
                .startAt(periodicRule.getStartDate())
                .withSchedule(simpleSchedule().withIntervalInSeconds(periodicRule.getPeriod()).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void deleteJob(String uniqueId) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.unscheduleJob(TriggerKey.triggerKey(uniqueId));
        scheduler.deleteJob(JobKey.jobKey(uniqueId));
    }

    public void setSchedulerFactory(SchedulerFactory schedulerFactory) {
        this.schedulerFactory = schedulerFactory;
    }
}
