package com.song.mapper.system;

import com.song.entity.system.SysRole;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

/**
 * 系统角色Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:49:59
 */
@RDBatisDao
public interface SysRoleMapper extends BaseMapper<SysRole, Long> {


    void delByUserId(Long id);
}
