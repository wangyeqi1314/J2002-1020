package com.qf.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.qf.dao.DAOConfig;
import com.qf.service.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.qf")
@Import({DAOConfig.class, ServiceConfig.class})
@PropertySource("druid.properties")
public class SpringConfig {

    @Value("${(driverClassName)}")
    private String driver;

    @Value("${(url)}")
    private String url;

    @Value("${(username)}")
    private String username;

    @Value("${(password)}")
    private String password;

    @Bean
    public DataSource dataSource() {
        // 返回一个Object，Spring会把这个object放到容器当中管理
        // xml - class
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
