package com.qf.mapper;

import com.qf.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    /**
     * 条件查询
     * @param minPrice 最小价格
     * @param maxPrice 最大价格
     * @return 满足条件的结果
     */
    public List<Product> search(
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice);

//    public default void method(@Param("word") String word,
//                               @Param("minPrice") Integer minPrice,
//                               @Param("maxPrice") Integer maxPrice) {
//        StringBuilder builder = new StringBuilder();
//
//        builder.append("SELECT * FROM tb_product");
//
//        // 至少有1个不为null
//        if (word != null || minPrice != null || maxPrice != null) {
//            builder.append(" WHERE ");
//        }
//
//        if (word != null) {
//            builder.append("name LIKE %" + word + "% AND");
//        }
//    }
}
