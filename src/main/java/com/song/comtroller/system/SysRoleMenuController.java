package com.song.comtroller.system;

import com.song.service.system.SysRoleMenuService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 系统用户组Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:07:42
 */
@Controller
public class SysRoleMenuController {

	@Resource
	private SysRoleMenuService sysRoleMenuService;

}
