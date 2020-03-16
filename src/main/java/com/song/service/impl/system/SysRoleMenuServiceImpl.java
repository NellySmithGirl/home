package com.song.service.impl.system;

import com.song.entity.system.SysRoleMenu;
import com.song.mapper.BaseMapper;
import com.song.mapper.system.SysRoleMenuMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.system.SysRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 系统用户组ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:07:42
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu, Long> implements SysRoleMenuService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysRoleMenuServiceImpl.class);
   
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public BaseMapper<SysRoleMenu, Long> getMapper() {
		return sysRoleMenuMapper;
	}
	
}