package org.schedulerjms.springfactory;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dSklyarenko on 27.02.14.
 */
public class SpringFactory {

    private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static Object getBean(String beanName) {
        Object object = context.getBean(beanName);
        return object;
    }
}
