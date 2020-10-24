package com.qf.dao;

import com.qf.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class CategoryMapperTest {
    private SqlSession sqlSession;
    private OrderMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }


}
