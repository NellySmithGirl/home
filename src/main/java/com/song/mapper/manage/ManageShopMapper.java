package com.song.mapper.manage;

import com.song.entity.manage.ManageShop;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

/**
 * 商铺实体Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:50:44
 */
@RDBatisDao
public interface ManageShopMapper extends BaseMapper<ManageShop, Long> {


    void delByUserId(Long id);
}
