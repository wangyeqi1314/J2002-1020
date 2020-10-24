package com.qf.present;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    public void testStaticFactoryBean() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        Object dataSource = ac.getBean("dataSource");

        System.out.println(dataSource);
    }

    @Test
    public void testFactoryBean() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Object dataSource = ac.getBean("dataSourceObject");

        System.out.println(dataSource);
    }
}
