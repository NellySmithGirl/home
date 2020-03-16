package com.song.dto;

import lombok.Data;

@Data
public class CheckShopDto {

    /**
     * 主键Id
     */
    private Long id;



    /**
     * 商铺名
     */
    private String shopName;

    /**
     * 商品类型名称
     */
    private String name;

    /**
     * 审核人
     */
    private String username;

    /**
     * 状态:1审核中2审核通过3审核不通过
     */
    private String status;

    /**
     * 审核备注
     */
    private String remark;

    /**
     * 审核时间
     */
    private String createTime;

}
