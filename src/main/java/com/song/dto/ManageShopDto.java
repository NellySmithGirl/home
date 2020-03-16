package com.song.dto;

import lombok.Data;

@Data
public class ManageShopDto {

    /**
     * checkshopid
     */
    private Long checkId;

    /**
     * 商铺地址
     */
    private String addr;

    /**
     * 营业执照
     */
    private String businessLicense;


    /**
     * 主键Id
     */
    private Long id;

    /**
     * 注册时间
     */
    private String registTime;

    /**
     * 审核备注
     */
    private String remark;

    /**
     * 商铺名
     */
    private String shopName;

    /**
     * 状态:1审核中2审核通过3审核不通过
     */
    private String status;

    /**
     * 负责人
     */
    private String userName;

    /**
     * 联系电话
     */
    private String userMobile;

}
