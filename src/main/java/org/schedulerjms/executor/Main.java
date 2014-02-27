package org.schedulerjms.executor;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.schedulerjms.model.Rule;
import org.schedulerjms.service.AppService;
import org.schedulerjms.springfactory.SpringFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by dSklyarenko on 24.02.14.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        AppService service = (AppService) SpringFactory.getBean("appService");
        //Rule rule = new Rule("pointCategory", 1);
        //Rule rule1 = new Rule("periodicCategory", 2);
        //service.addPointRule(rule, new Date((long)1393517850*1000), "destinationTest");
        //service.addPeriodicRule(rule1, new Date((long)1393517970*1000), 2, "periodicDestination");
        //service.deleteRule(rule1);
    }

}
