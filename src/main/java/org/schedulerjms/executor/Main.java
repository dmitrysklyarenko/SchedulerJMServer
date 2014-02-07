package org.schedulerjms.executor;

import org.schedulerjms.service.AppService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dSklyarenko on 06.02.14.
 */
public class Main {

    public static void main(String args[]) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AppService service = (AppService) context.getBean("appService");
        service.sendMessage();
    }

}
