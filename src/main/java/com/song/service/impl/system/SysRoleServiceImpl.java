package com.song.service.impl.system;

import com.song.entity.system.SysRole;
import com.song.mapper.BaseMapper;
import com.song.mapper.system.SysRoleMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.system.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * 系统角色ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:49:59
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, Long> implements SysRoleService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);
   
    @Resource
    private SysRoleMapper sysRoleMapper;

	@Override
	public BaseMapper<SysRole, Long> getMapper() {
		return sysRoleMapper;
	}

	@Override
	public List<SysRole> findByParam(HashMap<String, Object> map) {
		return sysRoleMapper.listSelective(map);
	}

	@Override
	public void addRole(SysRole role) {
		sysRoleMapper.save(role);
	}

	@Override
	public SysRole findByUserId(Long id) {
		return sysRoleMapper.findByPrimary(id);
	}

	@Override
	public void update(SysRole role) {
		sysRoleMapper.update(role);
	}

	@Override
	public void delByUserId(Long id) {
		sysRoleMapper.delByUserId(id);
	}
}