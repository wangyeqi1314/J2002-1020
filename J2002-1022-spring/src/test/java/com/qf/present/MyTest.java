package com.qf.present;

import com.qf.service.impl.UserServiceImpl;
import com.qf.siyoude.DataSource;
import com.qf.siyoude.DataSourceFactory;
import org.junit.Test;

public class MyTest {

    @Test
    public void testMy(){

        UserServiceImpl userService = new UserServiceImpl();
    }

    @Test
    public void testStaticFactory(){
        DataSource staticDataSource = DataSourceFactory.createStaticDataSource();


    }
}
