package com.qf.dao;

import com.qf.domain.Cart;
import com.qf.mapper.CartMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CartMapperTest {
    private SqlSession sqlSession;
    private CartMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(CartMapper.class);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }

    @Test
    public void testQueryByUid() {
        List<Cart> carts = mapper.queryByUid("1");

        System.out.println(carts);
    }
    public void testDelete(){

    }


}
