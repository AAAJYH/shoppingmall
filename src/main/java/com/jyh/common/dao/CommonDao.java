package com.jyh.common.dao;

import com.jyh.pojo.Category;
import com.jyh.pojo.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: jyh
 * @Date: 2019/5/18 12:55
 */

@Mapper
public interface CommonDao {

    /**
     * 查询全部种类
     * @return
     */
    @Select("select category_id categoryId, category_name categoryName, modify_time modifyTime, modify_admin_id modifyAdminId " +
            "from shoppingmall_category;")
    public List<Category> findCategoryAll();

    /**
     * 查询全部分类
     * @return
     */
    @Select("select classify_id classifyId, classify_name classifyName, classify_picture classifyPicture, " +
            "category_id categoryId, modify_time modifyTime, modify_admin_id modifyAdminId from shoppingmall_classify;")
    public List<Classify> findClassifyAll();

}
