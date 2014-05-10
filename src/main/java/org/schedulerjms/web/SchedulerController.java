package org.schedulerjms.web;

import org.quartz.SchedulerException;
import org.schedulerjms.model.PeriodicRule;
import org.schedulerjms.model.PointRule;
import org.schedulerjms.service.AppService;
import org.schedulerjms.springfactory.SpringFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dSklyarenko on 08.05.14.
 */

@Controller
public class SchedulerController {

    private AppService appService = (AppService) SpringFactory.getBean("appService");

    @RequestMapping(value="/rules/add/point", method = RequestMethod.POST)
    public @ResponseBody PointRule addPointRule (@RequestBody PointRule pointRule) throws Exception {
        pointRule.setUniqueId();
        appService.addPointRule(pointRule);
        return pointRule;
    }


    @RequestMapping(value="/rules/add/periodic", method = RequestMethod.POST)
    public @ResponseBody PeriodicRule addPeriodicRule (@RequestBody PeriodicRule periodicRule) throws SchedulerException {
        periodicRule.setUniqueId();
        appService.addPeriodicRule(periodicRule);
        return periodicRule;
    }

    @RequestMapping(value = "/rules/delete/{uniqueId}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteRule (@PathVariable String uniqueId) throws SchedulerException {
        appService.deleteRule(uniqueId);
        return uniqueId;
    }


}
