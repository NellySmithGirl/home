package com.song.entity.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品客流量统计实体实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:13:41
 */
@Data
public class DataCount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每日客流量
     */
    private Integer count;

    /**
     * 日期
     */
    private String date;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 主键Id
     */
    private Long id;



}