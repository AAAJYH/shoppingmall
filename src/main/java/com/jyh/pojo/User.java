package com.jyh.pojo;

import lombok.Data;

/**
 * @Author: jyh
 * @Date: 2019/6/27 16:35
 */

@Data
public class User {

    private int userId;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String userPassword;
    /**  修改时间 */
    private Long modifyTime;
    /** 修改管理员id */
    private int modifyAdminId;

}
