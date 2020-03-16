package com.song.mapper.manage;

import com.song.entity.manage.ManageGoods;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

/**
 * 商品实体Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:58:38
 */
@RDBatisDao
public interface ManageGoodsMapper extends BaseMapper<ManageGoods, Long> {


    void delByUserId(Long id);
}
