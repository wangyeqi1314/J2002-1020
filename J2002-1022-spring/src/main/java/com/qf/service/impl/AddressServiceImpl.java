package com.qf.service.impl;

import com.qf.service.AddressService;

public class AddressServiceImpl implements AddressService {

    public AddressServiceImpl(){
        System.out.println("UserServiceImpl 构造方法被调用");
    }

    public void init(){
        System.out.println("这是一个UserServiceImpl初始化方法");
    }

    public void destroy(){
        System.out.println("这是一个UserServiceImpl销毁方法");
    }
}
