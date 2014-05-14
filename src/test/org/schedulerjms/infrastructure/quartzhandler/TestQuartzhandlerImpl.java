package org.schedulerjms.infrastructure.quartzhandler;

import org.junit.Ignore;
import org.junit.Test;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import static org.junit.Assert.*;

import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;

/**
 * Created by dSklyarenko on 14.05.14.
 */
public class TestQuartzhandlerImpl {

    @Test
    public void testCreatePointJob() throws Exception {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        QuartzHandlerImpl quartzHandler = new QuartzHandlerImpl();
        quartzHandler.setSchedulerFactory(stdSchedulerFactory);
        PointRule pointRule = new PointRule();
        pointRule.setCategory("testCategoryPoint");
        pointRule.setID(1);
        pointRule.setStartDate(4098765456l);
        pointRule.setDestinationName("testQueue");
        pointRule.setUniqueId();
        quartzHandler.createPointJob(pointRule);
        boolean ifExist = stdSchedulerFactory.getScheduler().checkExists(new JobKey("testCategoryPoint1"));
        assertTrue(ifExist);
    }

    @Test
    public void testCreatePeriodicJob() throws Exception {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        QuartzHandlerImpl quartzHandler = new QuartzHandlerImpl();
        quartzHandler.setSchedulerFactory(stdSchedulerFactory);
        PeriodicRule periodicRule = new PeriodicRule();
        periodicRule.setCategory("testCategoryPeriodic");
        periodicRule.setID(11);
        periodicRule.setStartDate(459065456l);
        periodicRule.setPeriod(1);
        periodicRule.setDestinationName("testQueue");
        periodicRule.setUniqueId();
        quartzHandler.createPeriodicJob(periodicRule);
        boolean ifExist = stdSchedulerFactory.getScheduler().checkExists(new JobKey("testCategoryPeriodic11"));
        assertTrue(ifExist);
    }

    @Test
    public void testDeleteJob() throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        QuartzHandlerImpl quartzHandler = new QuartzHandlerImpl();
        quartzHandler.setSchedulerFactory(stdSchedulerFactory);
        PeriodicRule periodicRule = new PeriodicRule();
        periodicRule.setCategory("testCategoryPeriodic");
        periodicRule.setID(1);
        periodicRule.setStartDate(459098765456l);
        periodicRule.setPeriod(11);
        periodicRule.setDestinationName("testQueue");
        periodicRule.setUniqueId();
        quartzHandler.createPeriodicJob(periodicRule);
        quartzHandler.deleteJob("testCategoryDelete1");
        boolean ifExist = stdSchedulerFactory.getScheduler().checkExists(new JobKey("testCategoryDelete1"));
        assertFalse(ifExist);
    }
}
