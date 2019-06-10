package com.jyh.common.service;

import com.jyh.pojo.Category;
import com.jyh.pojo.Classify;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jyh
 * @Date: 2019/5/18 12:58
 */

@Service
public interface CommonService {

    /**
     * 查询种类表全部信息
     * @return
     */
    public List<Category> findCategoryAll();

    /**
     * 查询全部分类
     * @return
     */
    public List<Classify> findClassifyAll();

}
