package com.song.comtroller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.entity.system.SysMenu;
import com.song.entity.system.SysRole;
import com.song.service.system.SysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 系统权限Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 17:54:09
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

	private static int pageNum = 0;
	private static int pageSize = 5;

	private HashMap<String, Object> map;

	@Resource
	private SysMenuService sysMenuService;

	@RequestMapping("/toInsert")
	public String toInsert() {
		return "sys-menu-insert";
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
		List<SysMenu> menus = sysMenuService.findByParam(map);
		PageInfo<SysMenu> page = new PageInfo<>(menus);
		request.setAttribute("page",page);
		return "sys-menu-table";
	}


	/**
	 * 添加
	 * @param request
	 * @param menu
	 * @return
	 */
	@RequestMapping("/insert")
	public String insertUser(HttpServletRequest request,SysMenu menu){
		sysMenuService.addRole(menu);
		PageHelper.startPage(pageNum, pageSize);
		List<SysMenu> menus = sysMenuService.findByParam(map);
		PageInfo<SysMenu> page = new PageInfo<>(menus);
		request.setAttribute("page",page);
		return "sys-menu-table";
	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		SysMenu menu = sysMenuService.findByUserId(id);
		request.setAttribute("menu",menu);
		return "sys-menu-select";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request,Long id) {
		SysMenu menu = sysMenuService.findByUserId(id);
		request.setAttribute("menu",menu);
		return "sys-menu-update";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,SysMenu menu) {
		sysMenuService.update(menu);
		PageHelper.startPage(pageNum, pageSize);
		List<SysMenu> menus = sysMenuService.findByParam(map);
		PageInfo<SysMenu> page = new PageInfo<>(menus);
		request.setAttribute("page",page);
		return "sys-menu-table";
	}

	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request,Long id){
		sysMenuService.delByUserId(id);
		PageHelper.startPage(pageNum, pageSize);
		List<SysMenu> menus = sysMenuService.findByParam(map);
		PageInfo<SysMenu> page = new PageInfo<>(menus);
		request.setAttribute("page",page);
		return "sys-menu-table";
	}

	/**
	 * 动态查询菜单
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/showMenu")
	public String showMenu(HttpServletRequest request,Long id){

//		sysMenuService.findMenu();
		
//		sysMenuService.findMenuByJurHave(String storeId,String[] strJurHave);
		
//		List<primarySystemMenu> listMenu = null;
//		listJuri = pJurisdictionService.findStoreMenuByStoreId( pAdminUser.getStoreId() );
//		//根据登录用户身份 判断权限菜单及访问路径
//		for (int i = 0; i < listJuri.size(); i++) {
//			if (   String.valueOf( pAdminUser.getStatus() ).equals(listJuri.get(i).getJurName()) ) {
//				String[] JurHave = listJuri.get(i).getJurHave().split(",");
//				//权限列表菜单
//				listMenu = pSystemMenuService.findMenuByJurHave(pAdminUser.getStoreId(),JurHave);
//			}
//		}
//		modelMap.addAttribute("listMenu", listMenu);
		return "sys-menu-table";
	}

//	@Override
//	public List<primarySystemMenu> findMenuByJurHave(String storeId,String[] strJurHave) {
//		Specification<primarySystemMenu> spec = JuriUtils.toPredicateValue(strJurHave);
//		List<primarySystemMenu> listMenu = pSystemMenuRepository.findAll(spec);
//		//Java实现递归 创建树形结构
//		List<primarySystemMenu> treesList = primarySystemMenuServiceImpl.buildByRecursive(listMenu);
//		return treesList;
//	}
//
//	/**
//	 * 使用递归方法建树
//	 * @param listMenu
//	 * @return
//	 */
//	public static List<primarySystemMenu> buildByRecursive(List<primarySystemMenu> listMenu) {
//		List<primarySystemMenu> trees = new ArrayList<primarySystemMenu>();
//		for (primarySystemMenu treeNode : listMenu) {
//			if ( 0 == treeNode.getPid() ) {
//				trees.add(findChildren(treeNode,listMenu));
//			}
//		}
//		return trees;
//	}
//
//	/**
//	 * 递归查找子节点
//	 * @param listMenu
//	 * @return
//	 */
//	public static primarySystemMenu findChildren(primarySystemMenu treeNode,List<primarySystemMenu> listMenu) {
//		for (primarySystemMenu it : listMenu) {
//			if(treeNode.getId() ==  it.getPid() ) {
//				if (treeNode.getList() == null) {
//					treeNode.setList(new ArrayList<primarySystemMenu>());
//				}
//				treeNode.getList().add(findChildren(it,listMenu));
//			}
//		}
//		return treeNode;
//	}
	
}
