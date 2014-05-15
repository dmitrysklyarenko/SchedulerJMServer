package org.schedulerjms.web;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.quartz.SchedulerException;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;
import org.schedulerjms.service.AppService;
import org.schedulerjms.service.AppServiceImpl;
import static org.junit.Assert.*;



/**
 * Created by dSklyarenko on 15.05.14.
 */
public class TestSchedulerController {

    @Test
    public void testAddPointRule() throws Exception {
        AppService appService = Mockito.mock(AppServiceImpl.class);
        PointRule pointRule = new PointRule();
        pointRule.setCategory("pointCategory");
        pointRule.setID(1);
        pointRule.setStartDate(3456789);
        pointRule.setDestinationName("testQueue");
        SchedulerController schedulerController = new SchedulerController();
        schedulerController.setAppService(appService);
        PointRule pointRuleResult = schedulerController.addPointRule(pointRule);
        PointRule pointRuleExpected = new PointRule();
        pointRuleExpected.setCategory("pointCategory");
        pointRuleExpected.setID(1);
        pointRuleExpected.setStartDate(3456789);
        pointRuleExpected.setDestinationName("testQueue");
        pointRuleExpected.setUniqueId();
        assertTrue(pointRuleExpected.equals(pointRuleResult));
    }

    @Test
    public void testAddPeriodicRule() throws Exception {
        AppService appService = Mockito.mock(AppServiceImpl.class);
        PeriodicRule periodicRule = new PeriodicRule();
        periodicRule.setCategory("periodicCategory");
        periodicRule.setID(1);
        periodicRule.setStartDate(3456789);
        periodicRule.setDestinationName("testQueue");
        SchedulerController schedulerController = new SchedulerController();
        schedulerController.setAppService(appService);
        PeriodicRule periodicRuleResult = schedulerController.addPeriodicRule(periodicRule);
        PeriodicRule periodicRuleExpected = new PeriodicRule();
        periodicRuleExpected.setCategory("periodicCategory");
        periodicRuleExpected.setID(1);
        periodicRuleExpected.setStartDate(3456789);
        periodicRuleExpected.setDestinationName("testQueue");
        periodicRuleExpected.setUniqueId();
        assertTrue(periodicRuleExpected.equals(periodicRuleResult));
    }

    @Test
    public void testDeleteRule() throws SchedulerException {
        AppService appService = Mockito.mock(AppServiceImpl.class);
        String expected = "testCategory";
        SchedulerController schedulerController = new SchedulerController();
        schedulerController.setAppService(appService);
        String actual = schedulerController.deleteRule(expected);
        assertTrue(expected.equals(actual));
    }
}
