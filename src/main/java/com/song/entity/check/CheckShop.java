package com.song.entity.check;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商铺审核实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:15:47
 */
@Data
public class CheckShop implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审核时间
     */
    private String createTime;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 原因
     */
    private String remark;

    /**
     * 经营物品id
     */
    private Integer scopeId;

    /**
     * 商铺id
     */
    private Integer shopId;

    /**
     * 审核状态 1通过 2不通过 3 审核中
     */
    private String status;

    /**
     * 审核人
     */
    private Integer userId;

}