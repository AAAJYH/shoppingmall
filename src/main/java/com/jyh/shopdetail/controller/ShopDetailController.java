package com.jyh.shopdetail.controller;

import com.alibaba.fastjson.JSON;
import com.jyh.pojo.ShoppingCart;
import com.jyh.shopdetail.service.ShopDetailService;
import com.jyh.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * 添加购物车
     * @param commodityId
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("addCard")
    public int addCard(Integer commodityId, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        try{
            /** 查询商品详情，封装购物车对象 */
            Map<String, Object> commodity = shopDetailService.getCommodityByCommodityId(commodityId);
            ShoppingCart shoppingCart = new ShoppingCart((int)commodity.get("commodityId"), commodity.get("commodityName").toString(),
                    (double) commodity.get("currentPrice"), 1,
                    commodity.get("commodityPicture").toString().split(",")[0], 1);

            /** 已登录直接存入数据库，否则商品id存进cookie */
            if(request.getSession().getAttribute("user") != null) {
                logger.info("已登录");

                /** 设置购物车对象的userId，然后添加到数据库中 */
            }else {
                logger.info("未登录");

                /** Cookie中是否存在购物车cookie */
                List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
                if(request.getCookies() != null) {
                    Cookie[] cookies = request.getCookies();
                    for (Cookie c : cookies) {
                        if(c.getName().equals("shoppingCartList")) {
                            /** URLDecoder.decode对字符串进行解码 */
                            shoppingCartList = JSON.parseArray(URLDecoder.decode(c.getValue(),"utf-8"), ShoppingCart.class);
                        }
                    }
                }

                /** 购物车cookie存在相同的商品，修改数量 */
                boolean isExistsCommodity = false;
                for (ShoppingCart sc:shoppingCartList) {
                    /** 购物车Cookie存在相同商品，修改数量 */
                    if(sc.getCommodityName().equals(shoppingCart.getCommodityName())) {
                        sc.setCommodityNum(sc.getCommodityNum()+1);
                        response.addCookie(CookieUtils.addCookie(JSON.toJSONString(shoppingCartList)));
                        isExistsCommodity = true;
                        break;
                    }
                }

                /** 购物车cookie不存在相同的商品，新增商品 */
                if(!isExistsCommodity) {
                    shoppingCartList.add(shoppingCart);
                    response.addCookie(CookieUtils.addCookie(JSON.toJSONString(shoppingCartList)));
                }

            }
        }catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

}
