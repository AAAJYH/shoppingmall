package com.jyh.common.service.impl;

import com.jyh.common.dao.CommonDao;
import com.jyh.common.service.CommonService;
import com.jyh.pojo.Category;
import com.jyh.pojo.Classify;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jyh
 * @Date: 2019/5/18 12:58
 */

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource
    CommonDao commonDao;

    /**
     * 查询种类表全部信息
     * @return
     */
    @Override
    public List<Category> findCategoryAll() {
        return commonDao.findCategoryAll();
    }

    /**
     * 查询全部分类
     * @return
     */
    @Override
    public List<Classify> findClassifyAll() {
        return commonDao.findClassifyAll();
    }

}
