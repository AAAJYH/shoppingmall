package com.jyh.register.dao;

import com.jyh.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: jyh
 * @Date: 2019/6/27 16:47
 */

@Mapper
public interface RegisterDao {

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    @Select("SELECT user_id userId, user_name userName FROM `shoppingmall_user` WHERE user_name = #{userName}")
    public User getUserByUserName(@Param("userName") String userName);

}
