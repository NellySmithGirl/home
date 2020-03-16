package com.song.mapper.system;

import com.song.entity.system.SysUser;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

/**
 * 系统用户Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:36:32
 */
@RDBatisDao
public interface SysUserMapper extends BaseMapper<SysUser, Long> {

    Integer delByUserId(Long id);
}
