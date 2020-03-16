package com.song.entity.check;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品审核实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:46:20
 */
@Data
public class CheckGods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 审核时间
     */
    private Date createTime;

    /**
     * 商品id
     */
    private Integer goodsId;

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
     * 审核状态 1通过 2不通过 3 审核中
     */
    private String status;

    /**
     * 审核人
     */
    private Integer userId;

}