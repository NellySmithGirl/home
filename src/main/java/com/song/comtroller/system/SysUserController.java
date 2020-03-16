package com.song.comtroller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.entity.system.SysUser;
import com.song.service.system.SysUserService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 系统用户Controller
 *
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:36:32
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController{

	private static int pageNum = 0;
	private static int pageSize = 5;

	@Autowired
	private SysUserService sysUserService;

	private HashMap<String, Object> map;

	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}

	@RequestMapping("/login")
	public String login() {
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}


	@RequestMapping("/toInsert")
	public String toInsert() {
		return "sys-user-insert";
	}


	@RequestMapping("/register")
	public String register(HttpServletRequest request, SysUser user, String confirPassword) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("loginName",user.getLoginName());
		List<SysUser> users = sysUserService.findByParam(map);
		if (!users.isEmpty()){
			request.setAttribute("error","该用户已存在!");
			return "register";

		}
		if (!user.getPassword().equals(confirPassword)){
			request.setAttribute("error","两次密码不一致!");
			return "register";
		}
		sysUserService.addUser(user);
		return "index";
	}


	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request,Long id) {
		SysUser user = sysUserService.findByUserId(id);
		request.setAttribute("user",user);
		return "sys-user-update";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,SysUser user) {
		sysUserService.update(user);
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> users = sysUserService.findByParam(map);
		PageInfo<SysUser> page = new PageInfo<>(users);
		request.setAttribute("page",page);
		return "sys-user-table";
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
		List<SysUser> users = sysUserService.findByParam(map);
		PageInfo<SysUser> page = new PageInfo<>(users);
		request.setAttribute("page",page);
		return "sys-user-table";
	}

	/**
	 * 添加
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/insert")
	public String insertUser(HttpServletRequest request,SysUser user){
		sysUserService.addUser(user);
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> users = sysUserService.findByParam(map);
		PageInfo<SysUser> page = new PageInfo<>(users);
		request.setAttribute("page",page);
		return "sys-user-table";
	}

	/**
	 * 登录
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/sign" )
	public String sign(HttpServletRequest request,SysUser user){
		String sign = sysUserService.sign(user);
		request.setAttribute("error",sign);
		if (sign.equals("登录成功!")){

			request.setAttribute("loginName",user.getLoginName());
			return "home";
		}
		return "index";
	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		SysUser user = sysUserService.findByUserId(id);
		request.setAttribute("user",user);
		return "sys-user-select";
	}

	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request,Long id){
		sysUserService.delByUserId(id);
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> users = sysUserService.findByParam(map);
		PageInfo<SysUser> page = new PageInfo<>(users);
		request.setAttribute("page",page);
		return "sys-user-table";
	}


	/**
	 * 查看个人账号信息
	 * @param request
	 * @param loginName
	 * @return
	 */
	@RequestMapping("/showAccount")
	public String showAccount(HttpServletRequest request,String loginName){
		HashMap<String, Object> map = new HashMap<>();
		map.put("loginName",loginName);
		List<SysUser> users = sysUserService.findByParam(map);
		request.setAttribute("user",users.get(0));
		return "sys-account-select";
	}

	@RequestMapping("/toUpdateAccount")
	public String toUpdateAccount(HttpServletRequest request,String loginName){
		request.setAttribute("loginName",loginName);
		return "sys-account-update";
	}

	/**
	 * 修改个人账号信息
	 * @param request
	 * @param loginName
	 * @param oldPassword
	 * @param newPassword1
	 * @param newPassword2
	 * @return
	 */
	@RequestMapping("/updateAccount")
	public String updateAccount(HttpServletRequest request,String loginName,String oldPassword,String newPassword1,String newPassword2){
		String s = sysUserService.updateAccount(loginName, oldPassword, newPassword1, newPassword2);
		request.setAttribute("error",s);
		return "sys-account-update";
	}

	/**
	 * 注销账号
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		return "index";
	}

}
