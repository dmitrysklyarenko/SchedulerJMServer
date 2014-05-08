package org.schedulerjms.web;

import org.quartz.SchedulerException;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;
import org.schedulerjms.model.Rule;
import org.schedulerjms.service.AppService;
import org.schedulerjms.springfactory.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dSklyarenko on 08.05.14.
 */

@Controller
public class SchedulerController {

    private AppService appService = (AppService) SpringFactory.getBean("appService");

    @RequestMapping(value="/rules/add/point", method = RequestMethod.POST)
    public @ResponseBody PointRule addPointRule (@RequestBody PointRule pointRule) throws Exception {
        Rule rule = new Rule(pointRule.getCategory(), pointRule.getID());
        appService.addPointRule(rule, pointRule.getStartDate(), pointRule.getDestinationName());
        return pointRule;
    }


    @RequestMapping(value="/rules/add/periodic", method = RequestMethod.POST)
    public @ResponseBody PeriodicRule addPeriodicRule (@RequestBody PeriodicRule periodicRule) throws SchedulerException {
        Rule rule = new Rule(periodicRule.getCategory(), periodicRule.getID());
        appService.addPeriodicRule(rule, periodicRule.getStartDate(),  periodicRule.getPeriod(), periodicRule.getDestinationName());
        return periodicRule;
    }

    @RequestMapping(value = "/rules/delete", method = RequestMethod.DELETE)
    public @ResponseBody Rule deleteRule (@RequestBody Rule rule) throws SchedulerException {
        appService.deleteRule(rule);
        return rule;
    }

}
