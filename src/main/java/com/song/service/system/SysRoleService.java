package com.song.service.system;

import com.song.entity.system.SysRole;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 系统角色Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:49:59
 */
public interface SysRoleService extends BaseService<SysRole, Long> {

    List<SysRole> findByParam(HashMap<String, Object> map);

    void addRole(SysRole role);

    SysRole findByUserId(Long id);

    void update(SysRole role);

    void delByUserId(Long id);
}
