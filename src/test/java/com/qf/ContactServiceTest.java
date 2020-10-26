package com.qf;

import com.qf.config.SpringConfig;
import com.qf.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ContactServiceTest {

    @Resource
    private ContactService contactService;

    @Test
    public void testInit() {
        System.out.println(contactService);
    }
}
