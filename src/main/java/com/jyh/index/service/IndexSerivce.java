package com.jyh.index.service;

import com.jyh.pojo.Classify;
import com.jyh.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/21 0:36
 */

@Service
public interface IndexSerivce {

    /**
     * 获取特色商品分类
     * @return
     */
    public List<Classify> getFeatureClassify();

    /**
     * 根据分类获取特色商品
     * @param classifyId
     * @return
     */
    public List<Map<String, Object>> getFeatureCommodityByClassify(int classifyId);

}
