package com.jyh.index.service.impl;

import com.jyh.index.dao.IndexDao;
import com.jyh.index.service.IndexSerivce;
import com.jyh.pojo.Classify;
import com.jyh.pojo.Commodity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/21 0:36
 */

@Service("indexSerivce")
public class IndexServiceImpl implements IndexSerivce {

    @Resource
    IndexDao indexDao;

    /**
     * 获取特色商品分类
     * @return
     */
    @Override
    public List<Classify> getFeatureClassify() {
        return indexDao.getFeatureClassify();
    }

    /**
     * 根据分类获取特色商品
     * @param classifyId
     * @return
     */
    @Override
    public List<Map<String, Object>> getFeatureCommodityByClassify(int classifyId) {

        List<Classify> classifyList = indexDao.getFeatureClassify();
        System.out.println("class："+ classifyId);
        /** 默认查询第一个分类（表示默认），否则根据classifyId查询 */
        if(classifyId != 0){
            return indexDao.getFeatureCommodityByClassify(classifyId);
        }else {
            return indexDao.getFeatureCommodityByClassify(classifyList.get(0).getClassifyId());
        }

    }
}
