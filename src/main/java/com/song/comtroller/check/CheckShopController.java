package com.song.comtroller.check;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.dto.CheckShopDto;
import com.song.dto.ManageShopDto;
import com.song.entity.check.CheckShop;
import com.song.entity.manage.ManageGoods;
import com.song.service.check.CheckShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 商铺审核实体Controller
 *
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:15:47
 */
@Controller
@RequestMapping("/checkShop")
public class CheckShopController{

	private static int pageNum = 0;
	private static int pageSize = 5;

	private HashMap<String, Object> map;

	@Autowired
	private CheckShopService checkShopService;

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
		List<CheckShopDto> counts = checkShopService.findCheckShopDto(map);
		PageInfo<CheckShopDto> page = new PageInfo<>(counts);
		request.setAttribute("page",page);
		return "check-shop-table";
	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		ManageShopDto shop = checkShopService.findShopDto(id);
		request.setAttribute("shop",shop);
		return "check-shop-option";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,ManageShopDto shopDto) {
		checkShopService.update(shopDto);
		PageHelper.startPage(pageNum, pageSize);
		List<CheckShopDto> shopDtos = checkShopService.findCheckShopDto(map);
		PageInfo<CheckShopDto> page = new PageInfo<>(shopDtos);
		request.setAttribute("page",page);
		return "check-shop-table";
	}
}
