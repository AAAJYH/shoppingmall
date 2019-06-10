package com.jyh.pojo;

import lombok.Data;

/**
 * @Author: jyh
 * @Date: 2019/5/21 0:30
 * 数据字典
 */

@Data
public class DataDictionary {

    /** 标识id */
    private int dataDictionaryId;

    /**
     * 数据字典类型：
     *      2：上架
     *      3：下架
     *      4：特色商品
     */
    private String dataDictionaryType;

    /** 内容 */
    private String dataDictionaryContent;

    /** 说明 */
    private String dataDictionaryExplain;

    /** 父id，自引用 */
    private int parentDataDictionaryId;

    /** 修改时间 */
    private Long modifyTime;

    /** 修改人员，外键 */
    private int modifyAdminId;

}
