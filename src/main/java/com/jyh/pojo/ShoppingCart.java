package com.jyh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: jyh
 * @Date: 2019/6/22 21:07
 * 购物车
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private int shoppingCartId;
    /** 商品名称 */
    private String commodityName;
    /** 商品价格 */
    private double commodityPrice;
    /** 商品数量 */
    private int commodityNum;
    /** 商品图片 */
    private String commodityPicture;
    /** 用户id */
    private int userId;

}
