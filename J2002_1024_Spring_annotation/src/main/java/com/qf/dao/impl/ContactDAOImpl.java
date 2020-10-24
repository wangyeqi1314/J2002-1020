package com.qf.dao.impl;

import com.qf.dao.ContactDAO;
import com.qf.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/**
 * Component: 直译: 组件。翻译: 这个类会由spring进行管理，所以这个类的对象就变成了Spring所维护的组件了
 * Controller
 * 表示层
 * Service
 * 业务层
 * Repository
 * 整合层-资源层
 *
 * 客户层 - [表示层 - 业务层 - 整合层] - 资源层/持久层
 *
 * 以上三种注解，内部的作用与Component一毛一样
 * 程序在看代码的过程中，能够直观地区分到底是哪一层
 */
@Component("contactDAO")
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    // jdbcTemplate是DAO的成员变量名
    // 如果变量名和spring-bean的id一致的话，那么就可以自动注入进来
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemp;

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemp2;

    // 描述
    // Value支持SpringEL
    // Expression Language
    @Value("通讯录整合层")
    private String brief;


    // 初始化方法
    // 先创建(construct)再(post)初始化
    @PostConstruct
    public void init() {
        System.out.println("ContactDAOImpl初始化方法");
    }

    @PreDestroy
    // 先(pre)执行再销毁(destroy)
    public void destroy() {
        System.out.println("ContactDAOImpl销毁方法");
    }

    @Override
    public List<Contact> queryAll() {
        List<Contact> result = null;
        try {
            String sql = "SELECT * FROM contact_info WHERE del=0";

            result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Contact> queryAll(int pageOffset, int pageSize) {
        List<Contact> result = null;
        try {
            String sql = "SELECT * FROM contact_info WHERE del=0 LIMIT ?,?";

            result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class), pageOffset, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int queryCount() {
        int result = 0;
        try {
            String sql = "SELECT COUNT(*) FROM contact_info WHERE del=0";

            result = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteById(String contactId) {
        int result = 0;
        try {
            String sql = "UPDATE contact_info SET del=1 WHERE id=?";
            result = jdbcTemplate.update(sql, contactId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Contact queryById(String contactId) {
        String sql = "SELECT * FROM contact_info WHERE id=? AND del=0";

        // query是查多个，返回List，推荐使用
        // queryForObject是查1个，返回javabean。如果通过sql语句，一条都查不到的话，那么会抛异常
        List<Contact> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class), contactId);

        if (query.size() == 1) {
            return query.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int update(Contact contact) {
        String sql = "UPDATE contact_info SET name=?, gender=?, birthday=?, birthplace=?, mobile=?, email=? WHERE id=?";

        return jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
    }

    @Override
    public int add(Contact contact) {
        String sql = "INSERT INTO contact_info(`name`, `gender`, `birthday`, `birthplace`, `mobile`, `email`) VALUES(?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail());
    }
}
