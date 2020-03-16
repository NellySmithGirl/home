package com.song.comtroller.manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.entity.manage.ManageGoods;
import com.song.entity.manage.ManageScope;
import com.song.service.manage.ManageScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 经营范围管理实体Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:02:24
 */
@Controller
@RequestMapping("/manageScope")
public class ManageScopeController  {

	private static int pageNum = 0;
	private static int pageSize = 5;

	private HashMap<String, Object> map;

	@Autowired
	private ManageScopeService manageScopeService;

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
		List<ManageScope> scopes = manageScopeService.findByParam(map);
		PageInfo<ManageScope> page = new PageInfo<>(scopes);
		request.setAttribute("page",page);
		return "manage-scope-table";
	}

	@RequestMapping("/toInsert")
	public String toInsert() {
		return "manage-scope-insert";
	}

	/**
	 * 添加
	 * @param request
	 * @param scope
	 * @return
	 */
	@RequestMapping("/insert")
	public String insertUser(HttpServletRequest request,ManageScope scope){
		manageScopeService.addShop(scope);
		PageHelper.startPage(pageNum, pageSize);
		List<ManageScope> scopes = manageScopeService.findByParam(map);
		PageInfo<ManageScope> page = new PageInfo<>(scopes);
		request.setAttribute("page",page);
		return "manage-scope-table";
	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		ManageScope scope = manageScopeService.findByUserId(id);
		request.setAttribute("scope",scope);
		return "manage-scope-select";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request,Long id) {
		ManageScope scope = manageScopeService.findByUserId(id);
		request.setAttribute("scope",scope);
		return "manage-scope-update";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,ManageScope scope) {
		manageScopeService.update(scope);
		PageHelper.startPage(pageNum, pageSize);
		List<ManageScope> scopes = manageScopeService.findByParam(map);
		PageInfo<ManageScope> page = new PageInfo<>(scopes);
		request.setAttribute("page",page);
		return "manage-scope-table";
	}

	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request,Long id){
		manageScopeService.delByUserId(id);
		PageHelper.startPage(pageNum, pageSize);
		List<ManageScope> scopes = manageScopeService.findByParam(map);
		PageInfo<ManageScope> page = new PageInfo<>(scopes);
		request.setAttribute("page",page);
		return "manage-scope-table";
	}

}
