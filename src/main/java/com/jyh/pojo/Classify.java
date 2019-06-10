package com.jyh.pojo;

import lombok.Data;

/**
 * @Author: jyh
 * @Date: 2019/5/18 15:00
 * 分类表
 */

@Data
public class Classify {

    /** 标识id */
    private int classifyId;

    /** 分类名称 */
    private String classifyName;

    /** 分类图片 */
    private String classifyPicture;

    /** 种类id，外键 */
    private int categoryId;

    /** 修改时间 */
    private Long modifyTime;

    /**修改管理员id，外键*/
    private int modifyAdminId;

}
