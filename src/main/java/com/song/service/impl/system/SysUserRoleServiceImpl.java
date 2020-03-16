package com.song.service.impl.system;

import com.song.entity.system.SysUserRole;
import com.song.mapper.BaseMapper;
import com.song.mapper.system.SysUserRoleMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.system.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 系统用户角色ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:00:27
 * Copyright 杭州融都科技股份有限公司 cashloan All Rights Reserved
 * 官方网站：www.erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, Long> implements SysUserRoleService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);
   
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public BaseMapper<SysUserRole, Long> getMapper() {
		return sysUserRoleMapper;
	}
	
}