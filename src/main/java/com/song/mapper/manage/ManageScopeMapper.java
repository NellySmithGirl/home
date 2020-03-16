package com.song.mapper.manage;

import com.song.entity.manage.ManageScope;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

/**
 * 经营范围管理实体Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:02:24
 */
@RDBatisDao
public interface ManageScopeMapper extends BaseMapper<ManageScope, Long> {


    void delByUserId(Long id);
}
