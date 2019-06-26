package com.jyh.shopcart.controller;

import com.alibaba.fastjson.JSON;
import com.jyh.pojo.ShoppingCart;
import com.jyh.shopcart.service.ShopCartService;
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
import java.util.Iterator;
import java.util.List;

/**
 * @Author: jyh
 * @Date: 2019/6/23 11:49
 */

@RestController
@RequestMapping("/ShopCartController/")
public class ShopCartController {

    Logger logger = LoggerFactory.getLogger(ShopCartController.class);

    @Autowired
    ShopCartService shopCartService;

    /**
     * 获取购物车集合
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("getShoppingCartList")
    public List<ShoppingCart> getShoppingCartList(HttpServletRequest request) throws UnsupportedEncodingException {
        if(request.getSession().getAttribute("user") != null) {
            /** 去数据库查询购物车集合 */
        }else {
            /** 去Cookie中获取购物车集合 */
            if(request.getCookies() != null) {
                Cookie[] cookies = request.getCookies();
                for (Cookie c: cookies) {
                    System.out.println(c.getName());
                    if(c.getName().equals("shoppingCartList")) {
                        List<ShoppingCart> shoppingCartList = JSON.parseArray(URLDecoder.decode(c.getValue(), "utf-8"), ShoppingCart.class);
                        logger.info(shoppingCartList.toString());
                        return shoppingCartList;
                    }
                }
            }

        }
        return null;
    }

    @RequestMapping("deleteShoppingCart")
    public int deleteShoppingCart(Integer shoppingCartId, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        try{
            if (request.getSession().getAttribute("user") != null) {
                logger.info("已登录");
                /** 去数据库根据id删除购物车信息 */
            }else {
                logger.info("未登录");
                /** 根据commodityId删除购物车信息 */
                if(request.getCookies() != null) {
                    Cookie[] cookies = request.getCookies();

                    /** 遍历cookie，匹配购物车cookie */
                    for (Cookie c : cookies) {
                        if (c.getName().equals("shoppingCartList")) {
                            List<ShoppingCart> shoppingCartList = JSON.parseArray(URLDecoder.decode(c.getValue(), "utf-8"), ShoppingCart.class);

                            /** 遍历购物车集合，删除指定购物车信息 */
                            Iterator<ShoppingCart> shoppingCartIterator = shoppingCartList.iterator();
                            logger.info("购物车删除之前："+ shoppingCartIterator.toString());
                            while(shoppingCartIterator.hasNext()) {
                                if (shoppingCartIterator.next().getShoppingCartId() == shoppingCartId) {
                                    shoppingCartIterator.remove();

                                    /** 重新保存购物车cookie */
                                    String jsonStr = URLEncoder.encode(JSON.toJSONString(shoppingCartList), "utf-8");
                                    Cookie cookie = new Cookie("shoppingCartList", jsonStr);
                                    cookie.setPath("/");
                                    cookie.setMaxAge(60*60*24*7);
                                    response.addCookie(cookie);
                                    logger.info("购物车删除后："+ shoppingCartIterator.toString());

                                    return 1;
                                }
                            }

                        }
                    }

                }

            }
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

}
