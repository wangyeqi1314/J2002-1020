package com.qf.present;

import com.qf.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserControllerTest {
    @Test
    public void testInit() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);

        context.close();
    }
}
