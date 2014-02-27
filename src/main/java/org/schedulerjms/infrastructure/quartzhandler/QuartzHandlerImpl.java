package org.schedulerjms.infrastructure.quartzhandler;


import org.quartz.*;
import org.schedulerjms.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

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
    public void createPointJob(Rule rule, Date startDate, String destinationName) throws Exception {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = newJob(EventJob.class)
                .withIdentity(rule.getCategory() + rule.getID())
                .usingJobData("category", rule.getCategory())
                .usingJobData("ID", rule.getID())
                .usingJobData("destinationName", destinationName)
                .build();
        Trigger trigger = newTrigger()
                .withIdentity(rule.getCategory() + rule.getID())
                .startAt(startDate)
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void createPeriodicJob(Rule rule, Date startDate, int period, String destinationName) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        JobDetail jobDetail = newJob(EventJob.class)
                .withIdentity(rule.getCategory() + rule.getID())
                .usingJobData("category", rule.getCategory())
                .usingJobData("ID", rule.getID())
                .usingJobData("destinationName", destinationName)
                .build();
        Trigger trigger = newTrigger()
                .withIdentity(rule.getCategory() + rule.getID())
                .startAt(startDate)
                .withSchedule(simpleSchedule().withIntervalInSeconds(period).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void deleteJob(Rule rule) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.unscheduleJob(TriggerKey.triggerKey(rule.getCategory() + rule.getID()));
        scheduler.deleteJob(JobKey.jobKey(rule.getCategory() + rule.getID()));
    }

    public void setSchedulerFactory(SchedulerFactory schedulerFactory) {
        this.schedulerFactory = schedulerFactory;
    }
}
