package com.song.dto;

import lombok.Data;

@Data
public class ManageGoodsDto {
    /**
     * checkGoodsid
     */
    private Long checkId;

    /**
     * 详情
     */
    private String details;

    /**
     * 物品名称
     */
    private String scopeName;

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
     * 状态:1审核中2审核通过3审核不通过
     */
    private String status;

}
