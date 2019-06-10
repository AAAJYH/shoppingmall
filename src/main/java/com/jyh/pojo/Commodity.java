package com.jyh.pojo;

import lombok.Data;

/**
 * @Author: jyh
 * @Date: 2019/5/19 12:58
 * 商品表
 */

@Data
public class Commodity {

    /** 标识id */
    private int commodityId;

    /** 商品名称 */
    private String commodityName;

    /** 商品说明 */
    private String commodityExplaini;

    /** 原价 */
    private double originalPrice;

    /** 现价 */
    private double currentPrice;

    /** 商品图片 */
    private String commodityPicture;

    /** 商品库存 */
    private int commodityInventory;

    /** 商品状态 */
    private int commodityState;

    /** 所属分类，外键 */
    private int classifyId;

    /** 修改时间 */
    private Long modifyTime;

    /** 修改人员，外键 */
    private int modifyAdminId;

}
