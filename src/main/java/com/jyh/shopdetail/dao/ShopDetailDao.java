package com.jyh.shopdetail.dao;

import com.jyh.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:09
 *
 */

@Mapper
public interface ShopDetailDao {

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    @Select("select commodity_id commodityId, commodity_name commodityName, commodity_explaini commodityExplaini, " +
            "original_price originalPrice, current_price currentPrice, commodity_picture commodityPicture, " +
            "classify.classify_name classifyName from shoppingmall_commodity commodity, shoppingmall_classify classify " +
            "WHERE commodity.classify_id = classify.classify_id and commodity.commodity_id = #{commodityId} ")
    public Map<String, Object> getCommodityByCommodityId(@Param("commodityId") Integer commodityId);



}
