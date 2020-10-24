package com.qf.service.impl;

import com.qf.dao.UserDAO;
import com.qf.service.UserService;

// 支持两种方式的设置:
// 有参构造
// 调用setter方法
public class UserServiceImpl implements UserService {
    private String username;
    private UserDAO dao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl 构造方法被调用");
    }

    public UserServiceImpl(String username, UserDAO dao) {
        this.username = username;
        this.dao = dao;
    }

    public void init() {
        System.out.println("这是一个UserServiceImpl初始化方法");
    }

    public void destroy() {
        System.out.println("这是一个UserServiceImpl销毁方法");
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "username='" + username + '\'' +
                ", dao=" + dao +
                '}';
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
