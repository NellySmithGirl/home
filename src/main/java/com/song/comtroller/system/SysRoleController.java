package com.song.comtroller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.entity.system.SysRole;
import com.song.entity.system.SysUser;
import com.song.service.system.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 系统角色Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:49:59
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

	private static int pageNum = 0;
	private static int pageSize = 5;

	private HashMap<String, Object> map;

	@Autowired
	private SysRoleService sysRoleService;


	@RequestMapping("/toInsert")
	public String toInsert() {
		return "sys-role-insert";
	}

	/**
	 * 表格分页
	 * @param request
	 * @param map
	 * @param start
	 * @param size
	 * @return
	 */
	@RequestMapping("/table")
	public String table(HttpServletRequest request, HashMap<String,Object> map,
						@RequestParam(value = "start", defaultValue = "0") int start,
						@RequestParam(value = "size", defaultValue = "5") int size) {

		PageHelper.startPage(start, size);
		List<SysRole> users = sysRoleService.findByParam(map);
		PageInfo<SysRole> page = new PageInfo<>(users);
		request.setAttribute("page",page);
		return "sys-role-table";
	}


	/**
	 * 添加
	 * @param request
	 * @param role
	 * @return
	 */
	@RequestMapping("/insert")
	public String insertUser(HttpServletRequest request,SysRole role){
		sysRoleService.addRole(role);
		PageHelper.startPage(pageNum, pageSize);
		List<SysRole> roles = sysRoleService.findByParam(map);
		PageInfo<SysRole> page = new PageInfo<>(roles);
		request.setAttribute("page",page);
		return "sys-role-table";
	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		SysRole role = sysRoleService.findByUserId(id);
		request.setAttribute("role",role);
		return "sys-role-select";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request,Long id) {
		SysRole role = sysRoleService.findByUserId(id);
		request.setAttribute("role",role);
		return "sys-role-update";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,SysRole role) {
		sysRoleService.update(role);
		PageHelper.startPage(pageNum, pageSize);
		List<SysRole> users = sysRoleService.findByParam(map);
		PageInfo<SysRole> page = new PageInfo<>(users);
		request.setAttribute("page",page);
		return "sys-role-table";
	}

	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request,Long id){
		sysRoleService.delByUserId(id);
		PageHelper.startPage(pageNum, pageSize);
		List<SysRole> roles = sysRoleService.findByParam(map);
		PageInfo<SysRole> page = new PageInfo<>(roles);
		request.setAttribute("page",page);
		return "sys-role-table";
	}
}
