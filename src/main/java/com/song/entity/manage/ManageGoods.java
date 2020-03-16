package com.song.entity.manage;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:58:38
 */
@Data
public class ManageGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 详情
     */
    private String details;

    /**
     * 物品id
     */
    private Integer scopeId;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 图片
     */
    private String picture;

    /**
     * 价格
     */
    private Double price;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核人
     */
    private Integer userId;

    /**
     * 状态:1审核中2审核通过3审核不通过
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

}