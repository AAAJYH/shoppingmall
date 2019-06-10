package com.jyh.pojo;

import lombok.Data;

/**
 * @Author: jyh
 * @Date: 2019/5/18 12:44
 * 种类表
 */

@Data
public class Category {

    /** 标识id */
    private int categoryId;

    /** 种类名称 */
    private String categoryName;

    /** 修改时间 */
    private Long modifyTime;

    /** 修改管理员id，外键 */
    private int  modifyAdminId;

}
