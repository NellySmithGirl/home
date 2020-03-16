package com.song.entity.manage;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商铺实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:50:44
 */
@Data
public class ManageShop implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺地址
     */
    private String addr;

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 注册时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
    private String username;

    /**
     * 联系电话
     */
    private String userMobile;

    /**
     * 审核人
     */
    private Integer userId;
    /**
     * 物品id
     */
    private Integer scopeId;

}