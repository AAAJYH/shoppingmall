package com.jyh.index.controller;

import com.jyh.index.service.IndexSerivce;
import com.jyh.pojo.Classify;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/18 13:16
 */

@RestController
@RequestMapping("/IndexController/")
public class IndexController {

    @Resource
    IndexSerivce indexSerivce;

    /**
     * 获取特色商品分类
     * @return
     */
    @RequestMapping("getFeatureClassify")
    public List<Classify> getFeatureClassify() {
        return indexSerivce.getFeatureClassify();
    }

    /**
     * 根据分类获取特色商品
     * @param classifyId
     * @return
     */
    @RequestMapping("getFeatureCommodityByClassify")
    public List<Map<String, Object>> getFeatureCommodityByClassify(int classifyId) {
        return indexSerivce.getFeatureCommodityByClassify(classifyId);
    }

}
