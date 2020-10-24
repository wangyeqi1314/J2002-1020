package com.qf.present;

import com.qf.domain.Contact;
import com.qf.service.ContactService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ContactServiceTest {
    @Test
    public void testService() {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ContactService contactService = context.getBean("contactService", ContactService.class);

        List<Contact> contacts = contactService.queryAll(1, 10);

        System.out.println(contacts);

        context.close();
    }
}
