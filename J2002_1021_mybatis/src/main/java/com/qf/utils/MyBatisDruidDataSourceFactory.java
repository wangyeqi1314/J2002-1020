package com.qf.utils;


import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyBatisDruidDataSourceFactory extends PooledDataSourceFactory {
    public MyBatisDruidDataSourceFactory() {
//        this.dataSource = new DruidDataSource();
    }
}