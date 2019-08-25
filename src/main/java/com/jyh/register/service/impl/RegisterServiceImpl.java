package com.jyh.register.service.impl;

import com.jyh.pojo.User;
import com.jyh.register.dao.RegisterDao;
import com.jyh.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: jyh
 * @Date: 2019/6/27 16:50
 */

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Resource
    RegisterDao registerDao;

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return null;
    }
}
