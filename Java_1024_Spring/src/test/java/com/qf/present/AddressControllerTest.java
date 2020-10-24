package com.qf.present;

import com.qf.service.AddressService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressControllerTest {

    @Test
    public void testInit() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        AddressService addressService = context.getBean("addressService", AddressService.class);

        System.out.println(addressService);

        context.close();
    }

}
