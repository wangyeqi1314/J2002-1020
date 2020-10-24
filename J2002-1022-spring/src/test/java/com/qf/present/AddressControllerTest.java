package com.qf.present;

import com.qf.service.AddressService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressControllerTest {

    @Test
    public void testConstructor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 方案1: 返回的是Object类型，然后强转
//        AddressService addressService = (AddressService) context.getBean("addressService");

        // 方案2: 在getBean的时候，就告诉bean工厂，这是一个什么类型
        AddressService addressService = context.getBean("addressService", AddressService.class);

        AddressService addressService1 = context.getBean("addressService", AddressService.class);

        System.out.println(addressService);

        context.close();
    }

    public void testCreateMyDataSource() {

    }

}
