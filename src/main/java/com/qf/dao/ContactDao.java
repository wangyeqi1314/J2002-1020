package com.qf.dao;

import com.qf.domain.ContactInfo;

import java.util.List;

public interface ContactDao {
    public List<ContactInfo> queryAll();
}
