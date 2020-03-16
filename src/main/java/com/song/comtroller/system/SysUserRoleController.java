package com.song.comtroller.system;

import com.song.service.system.SysUserRoleService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 系统用户角色Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:00:27
 */
@Controller
public class SysUserRoleController{

	@Resource
	private SysUserRoleService sysUserRoleService;

}
