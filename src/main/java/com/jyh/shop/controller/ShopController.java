package com.jyh.shop.controller;

import com.github.pagehelper.PageInfo;
import com.jyh.pojo.Commodity;
import com.jyh.shop.service.ShopService;
import com.jyh.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:20
 */

@Controller
@RequestMapping("/ShopController/")
public class ShopController {

    Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    ShopService commodityService;

    /**
     * 根据分类id查询商品
     * @param classifyId
     * @param
     * @param pageNum
     * @return
     */
    @RequestMapping("shop")
    public ModelAndView shop(Integer classifyId, int pageNum, int pageSize, String sortType) {
        PageInfo<Map<String, Object>> commodityPageInfo = commodityService.getCommodityByClassifyId(classifyId, pageSize, pageNum, sortType);
        ModelAndView modelAndView = new ModelAndView("front/shop_grid+list_3col.html");
        modelAndView.addObject("commodityPageInfo", commodityPageInfo);
        modelAndView.addObject("classifyId", classifyId);
        logger.info("分类商品："+ commodityPageInfo);
        return modelAndView;
    }

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    @RequestMapping("getCommodityByCommodityId")
    @ResponseBody
    public Commodity getCommodityByCommodityId(Integer commodityId) {
        return commodityService.getCommodityByCommodityId(commodityId);
    }

}
