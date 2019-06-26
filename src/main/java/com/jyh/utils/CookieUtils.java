package com.jyh.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: jyh
 * @Date: 2019/6/26 9:32
 */
public class CookieUtils {

    /**
     * 添加Cookie
     * @param jsonStr
     * @return
     * @throws UnsupportedEncodingException
     */
    public static Cookie addCookie(String jsonStr) throws UnsupportedEncodingException {
        /** Cookie中不允许出现符号如 , : "  所以使用URLEncoder.encode对字符串进行转码 */
        Cookie cookie = new Cookie("shoppingCartList", URLEncoder.encode(jsonStr, "utf-8"));
        /** 有效时长7天 */
        cookie.setMaxAge(60*60*24*7);
        /** 所有路径都能访问次cookie */
        cookie.setPath("/");
        return cookie;
    }

}
