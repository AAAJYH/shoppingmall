package com.jyh.shopdetail.controller;

import com.github.pagehelper.PageInfo;
import com.jyh.pojo.Commodity;
import com.jyh.shop.service.ShopService;
import com.jyh.shopdetail.service.ShopDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:20
 */

@RestController
@RequestMapping("/shopDetailController/")
public class ShopDetailController {

    private Logger logger = LoggerFactory.getLogger(ShopDetailController.class);

    @Autowired
    ShopDetailService shopDetailService;

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    @RequestMapping("getCommodityByCommodityId")
    public Map<String, Object> getCommodityByCommodityId(Integer commodityId) {
        Map<String, Object> commodityMap = shopDetailService.getCommodityByCommodityId(commodityId);
        logger.info("commodityMap："+ commodityMap);
        return commodityMap;
    }

}
