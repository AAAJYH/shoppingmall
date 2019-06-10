package com.jyh.shopdetail.service;

import com.github.pagehelper.PageInfo;
import com.jyh.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:17
 */

@Service
public interface ShopDetailService {

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    public Map<String, Object> getCommodityByCommodityId(Integer commodityId);

}
