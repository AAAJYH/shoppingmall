package com.jyh.shop.service;

import com.github.pagehelper.PageInfo;
import com.jyh.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:17
 */

@Service
public interface ShopService {

    /**
     * 根据分类id查询商品
     * @param classifyId
     * @param pageSize
     * @param pageNum
     * @param sortType
     * @return
     */
    public PageInfo<Map<String, Object>> getCommodityByClassifyId(Integer classifyId, int pageSize, int pageNum, String sortType);

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    public Commodity getCommodityByCommodityId(Integer commodityId);

}
