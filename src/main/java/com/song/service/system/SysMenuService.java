package com.song.service.system;

import com.song.entity.system.SysMenu;
import com.song.entity.system.SysRole;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 系统权限Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:54:09
 */
public interface SysMenuService extends BaseService<SysMenu, Long> {

    List<SysMenu> findByParam(HashMap<String, Object> map);

    void addRole(SysMenu menu);

    SysMenu findByUserId(Long id);

    void update(SysMenu menu);

    void delByUserId(Long id);

    void findMenu(HashMap<String,Object> map);

}
