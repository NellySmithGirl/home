package com.song.entity.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:07:19
 */
@Data
public class DataOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购买数量
     */
    private Integer buyCount;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 经营物品id
     */
    private Integer scopeId;

    /**
     * 购买用户id
     */
    private Integer userId;


}