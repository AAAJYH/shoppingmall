package com.jyh.shop.dao;

import com.jyh.pojo.Commodity;
import com.jyh.utils.Constant;
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
public interface ShopDao {

    /**
     * 根据分类id查询商品
     * @param classifyId
     * @param sortType
     * @return
     */
    @Select("<script>" +
            "SELECT commodity_id commodityId, commodity_name commodityName, commodity_explaini commodityExplaini, " +
            "original_price originalPrice, current_price currentPrice, commodity_picture commodityPicture, " +
            "commodity_inventory commodityInventory, data_dictionary_id dataDictionaryId, classify.classify_name classifyName " +
            "FROM `shoppingmall_commodity` commodity, shoppingmall_classify classify " +
            "WHERE commodity.classify_id = classify.classify_id and data_dictionary_id = 4 " +
            "<if test='classifyId != null and classifyId != \"\" '> and commodity.classify_id =#{classifyId} </if>" +
            "<if test='sortType !=null and sortType != \"\" '>order by current_price #{sortType}</if>" +
            "</script>")
    public List<Map<String, Object>> getCommodityByClassifyId(@Param("classifyId") Integer classifyId, @Param("sortType") String sortType);

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    @Select("select * from shoppingmall_commodity where commodity_id = #{commodityId}")
    public Commodity getCommodityByCommodityId(@Param("commodityId") Integer commodityId);



}
