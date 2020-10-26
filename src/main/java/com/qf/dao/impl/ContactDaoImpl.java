package com.qf.dao.impl;

import com.qf.dao.ContactDao;
import com.qf.domain.ContactInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ContactInfo> queryAll() {
        return null;
    }
}
