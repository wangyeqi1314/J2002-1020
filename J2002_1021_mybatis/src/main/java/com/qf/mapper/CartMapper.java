package com.qf.mapper;

import com.qf.domain.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    public List<Cart> queryByUid(String uid);

    // 结算商品前，将购物车里面的一些商品删除
    public int delete(@Param("ids") List<String> ids);
}
