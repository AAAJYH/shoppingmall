package com.jyh.common.controller;

import com.jyh.common.service.CommonService;
import com.jyh.pojo.Category;
import com.jyh.pojo.Classify;
import com.jyh.pojo.Commodity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jyh
 * @Date: 2019/5/18 13:16
 */

@Controller
@RequestMapping("/CommonController/")
public class CommonController {

    @Resource
    CommonService commonService;

    /**
     * 查询种类表全部信息
     * @return
     */
    @RequestMapping("findCategoryAll")
    @ResponseBody
    public List<Category> findCategoryAll() {
        return commonService.findCategoryAll();
    }

    /**
     * 查询全部分类
     * @return
     */
    @RequestMapping("findClassifyAll")
    @ResponseBody
    public List<Classify> findClassifyAll() {
        return commonService.findClassifyAll();
    }



}
