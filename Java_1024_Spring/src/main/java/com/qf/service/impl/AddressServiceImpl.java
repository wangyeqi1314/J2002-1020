package com.qf.service.impl;

import com.qf.dao.AddressDAO;
import com.qf.service.AddressService;

public class AddressServiceImpl implements AddressService {
    private String username;
    private AddressDAO dao;

    public AddressServiceImpl() {
        System.out.println("AddressServiceImpl构造方法被调用了");
    }

    public AddressServiceImpl(String username, AddressDAO dao) {
        this.username = username;
        this.dao = dao;
    }

    public void init() {
        System.out.println("这是一个AddressServiceImpl初始化方法");
    }

    public void destroy() {
        System.out.println("这是一个AddressServiceImpl销毁方法");
    }

    @Override
    public String toString() {
        return "AddressServiceImpl{" +
                "username='" + username + '\'' +
                ", dao=" + dao +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AddressDAO getDao() {
        return dao;
    }

    public void setDao(AddressDAO dao) {
        this.dao = dao;
    }
}
