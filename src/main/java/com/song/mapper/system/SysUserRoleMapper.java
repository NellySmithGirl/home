package com.song.mapper.system;

import com.song.entity.system.SysUserRole;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

/**
 * 系统用户角色Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:00:27
 */
@RDBatisDao
public interface SysUserRoleMapper extends BaseMapper<SysUserRole, Long> {


    SysUserRole findByUserId(Long userId);
}
