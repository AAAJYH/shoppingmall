package com.jyh.index.dao;

import com.jyh.pojo.Classify;
import com.jyh.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/21 0:26
 * /front/index.html
 */

@Mapper
public interface IndexDao {

    /**
     * 获取特色商品分类（特色商品：4）
     * @return
     */
    @Select("select classify_id, classify_name, classify_picture, category_id, modify_time, modify_admin_id " +
            "from shoppingmall_classify " +
            "where classify_id in ( select classify_id from shoppingmall_commodity where data_dictionary_id = 4 )")
    public List<Classify> getFeatureClassify();

    /**
     * 根据分类获取特色商品（特色商品：4）
     * @param classifyId
     * @return
     */
    @Select("select commodity_id commodityId, cls.classify_name classifyName, commodity_name commodityName, " +
            "commodity_explaini commodityExplaini,original_price originalPrice, current_price currentPrice, " +
            "commodity_picture commodityPicture, commodity_inventory commodityInventory, data_dictionary_id dataDictionaryId, " +
            "cmd.classify_id classifyId, cmd.commodity_picture from shoppingmall_commodity cmd,shoppingmall_classify cls " +
            "where cmd.classify_id = cls.classify_id and data_dictionary_id = 4 and cmd.classify_id = #{classifyId} ")
    public List<Map<String, Object>> getFeatureCommodityByClassify(@Param("classifyId") int classifyId);

}
