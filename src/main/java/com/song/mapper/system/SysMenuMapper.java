package com.song.mapper.system;

import com.song.entity.system.SysMenu;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

import java.util.List;

/**
 * 系统权限Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:54:09
 */
@RDBatisDao
public interface SysMenuMapper extends BaseMapper<SysMenu, Long> {


    List<SysMenu> findByAdminUserId(Long id);

    List<SysMenu> findAll();

    void delByUserId(Long id);
}
