package com.song.entity.manage;

import lombok.Data;

import java.io.Serializable;

/**
 * 商铺商品关联实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:04:56
 */
@Data
public class ManageShopGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺id
     */
    private Integer goodsId;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 商铺id
     */
    private Integer shopId;


}