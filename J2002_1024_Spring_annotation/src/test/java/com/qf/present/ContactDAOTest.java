package com.qf.present;

import com.qf.dao.ContactDAO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactDAOTest {
    @Test
    public void testDAO() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ContactDAO contactDAO = context.getBean("contactDAO", ContactDAO.class);

        ContactDAO contactDAO2 = context.getBean("contactDAO", ContactDAO.class);

        context.close();
    }
}
