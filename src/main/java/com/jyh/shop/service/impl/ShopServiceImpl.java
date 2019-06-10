package com.jyh.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyh.pojo.Commodity;
import com.jyh.shop.dao.ShopDao;
import com.jyh.shop.service.ShopService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/5/19 13:18
 */

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    ShopDao commodityDao;

   /**
     * 根据分类id查询商品
     * @param classifyId 分类id
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> getCommodityByClassifyId(Integer classifyId, int pageSize, int pageNum, String sortType) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> commodityList = commodityDao.getCommodityByClassifyId(classifyId, sortType);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(commodityList);
        return pageInfo;
    }

    /**
     * 根据商品id查询商品
     * @param commodityId
     * @return
     */
    @Override
    public Commodity getCommodityByCommodityId(Integer commodityId) {
        return commodityDao.getCommodityByCommodityId(commodityId);
    }
}
