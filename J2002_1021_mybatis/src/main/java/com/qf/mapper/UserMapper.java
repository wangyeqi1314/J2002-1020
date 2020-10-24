package com.qf.mapper;

import com.qf.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 在Mapper接收的参数有多个时，参数绑定会失败
    // 如果有多个，那么通过@Param注解进行指定
    public User queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
