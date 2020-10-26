package com.qf.service.impl;

import com.qf.dao.ContactDao;
import com.qf.domain.ContactInfo;
import com.qf.service.ContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Resource(name = "contactDao")
    private ContactDao dao;

    @Override
    public List<ContactInfo> queryAll() {
        return dao.queryAll();
    }
}
