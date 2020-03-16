package com.song.entity.manage;

import lombok.Data;

import java.io.Serializable;

/**
 * 经营范围管理实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:02:24
 */
@Data
public class ManageScope implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 商品类型名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预留(商品类型,如 家具,文具)
     */
    private String type;


}