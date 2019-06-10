package com.jyh.shopdetail.service.impl;

import com.jyh.pojo.Commodity;
import com.jyh.shop.dao.ShopDao;
import com.jyh.shopdetail.dao.ShopDetailDao;
import com.jyh.shopdetail.service.ShopDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:18
 */

@Service("shopDetailService")
public class ShopDetailServiceImpl implements ShopDetailService {

    @Resource
    ShopDetailDao shopDetailDao;

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    @Override
    public Map<String, Object> getCommodityByCommodityId(Integer commodityId) {
        return shopDetailDao.getCommodityByCommodityId(commodityId);
    }
}
