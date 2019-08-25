package com.jyh.register.service;

import com.jyh.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author: jyh
 * @Date: 2019/6/27 16:47
 */

@Service
public interface RegisterService {

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    public User getUserByUserName(@Param("userName") String userName);

}
