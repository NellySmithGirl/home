package com.song.comtroller.check;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.dto.CheckGoodsDto;
import com.song.dto.CheckShopDto;
import com.song.dto.ManageGoodsDto;
import com.song.dto.ManageShopDto;
import com.song.entity.check.CheckGods;
import com.song.entity.check.CheckShop;
import com.song.service.check.CheckGodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 商品审核实体Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:46:20
 */
@Controller
@RequestMapping("/checkGoods")
public class CheckGodsController {

	private static int pageNum = 0;
	private static int pageSize = 5;

	private HashMap<String, Object> map;

	@Autowired
	private CheckGodsService checkGodsService;

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
		List<CheckGoodsDto> counts = checkGodsService.findCheckGoodsDto(map);
		PageInfo<CheckGoodsDto> page = new PageInfo<>(counts);
		request.setAttribute("page",page);
		return "check-goods-table";
	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		ManageGoodsDto good = checkGodsService.findGoodsDto(id);
		request.setAttribute("good",good);
		return "check-goods-option";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,ManageGoodsDto goodsDto) {
		checkGodsService.update(goodsDto);
		PageHelper.startPage(pageNum, pageSize);
		List<CheckGoodsDto> shopDtos = checkGodsService.findCheckGoodsDto(map);
		PageInfo<CheckGoodsDto> page = new PageInfo<>(shopDtos);
		request.setAttribute("page",page);
		return "check-goods-table";
	}
}
