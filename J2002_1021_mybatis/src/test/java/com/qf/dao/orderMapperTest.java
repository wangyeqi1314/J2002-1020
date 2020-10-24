package com.qf.dao;

import com.qf.domain.Cart;
import com.qf.domain.Order;
import com.qf.mapper.OrderMapper;
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

public class orderMapperTest {
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

    @Test
    public void testQueryByUid() {
        List<Order> orders = mapper.queryByUid("1");
        System.out.println(orders);
    }

    @Test
    public void testInsert() {
        Order order = new Order();
        order.setTotalAmount("16000");
        order.setState("1");
        order.setCreationTime("2020-10-21");
        order.setUid("1");

        int insert = mapper.insert(order);
        System.out.println(insert);
    }

    @Test
    public void testDelete() {
        int delete = mapper.delete(5 );
        System.out.println(delete);
    }

    @Test
    public void testUpdate() {
        List<Order> orders = mapper.queryByUid("1");
        Order order = orders.get(0);
        order.setState("2");

        int update = mapper.update(order);
        System.out.println(update);
    }

}
