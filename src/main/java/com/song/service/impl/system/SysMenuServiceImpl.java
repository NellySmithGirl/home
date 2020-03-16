package com.song.service.impl.system;

import com.song.entity.system.SysMenu;
import com.song.entity.system.SysRole;
import com.song.mapper.BaseMapper;
import com.song.mapper.system.SysMenuMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.system.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * 系统权限ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:54:09
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, Long> implements SysMenuService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
   
    @Resource
    private SysMenuMapper sysMenuMapper;

	@Override
	public BaseMapper<SysMenu, Long> getMapper() {
		return sysMenuMapper;
	}

	@Override
	public List<SysMenu> findByParam(HashMap<String, Object> map) {
		return sysMenuMapper.listSelective(map);
	}

	@Override
	public void addRole(SysMenu menu) {
		sysMenuMapper.save(menu);
	}

	@Override
	public SysMenu findByUserId(Long id) {
		return sysMenuMapper.findByPrimary(id);
	}

	@Override
	public void update(SysMenu menu) {
		sysMenuMapper.update(menu);
	}

	@Override
	public void delByUserId(Long id) {
		sysMenuMapper.delByUserId(id);
	}

	@Override
	public void findMenu(HashMap<String, Object> map) {

	}
}