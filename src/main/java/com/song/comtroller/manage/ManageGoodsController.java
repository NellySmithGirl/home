package com.song.comtroller.manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.dto.ManageGoodsDto;
import com.song.entity.manage.ManageGoods;
import com.song.entity.manage.ManageScope;
import com.song.entity.manage.ManageShop;
import com.song.service.check.CheckGodsService;
import com.song.service.manage.ManageGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 商品实体Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:58:38
 */
@Controller
@RequestMapping("/manageGoods")
public class ManageGoodsController {

	private static int pageNum = 0;
	private static int pageSize = 5;

	private HashMap<String, Object> map;

	@Autowired
	private ManageGoodsService manageGoodsService;

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
		List<ManageGoodsDto> goods = manageGoodsService.findGoodsDto(map);
		PageInfo<ManageGoodsDto> page = new PageInfo<>(goods);
		request.setAttribute("page",page);
		return "manage-goods-table";
	}

	@RequestMapping("/toInsert")
	public String toInsert(HttpServletRequest request) {
		List<ManageScope> scopes = manageGoodsService.findScope();
		request.setAttribute("scopes",scopes);
		return "manage-goods-insert";
	}

	/**
	 * 添加
	 * @param request
	 * @param good
	 * @return
	 */
	@RequestMapping("/insert")
	public String insertUser(HttpServletRequest request,ManageGoods good,MultipartFile photo){
		// 如果文件不为空，写入上传路径
		if(!photo.isEmpty()){
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/upload/");
			System.out.println("path = " + path);
			// 上传文件名
			String filename = photo.getOriginalFilename();
			File filepath = new File(path,filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			try {
				photo.transferTo(new File(path + File.separator + filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			good.setPicture(filename);
			manageGoodsService.addGoods(good);
			PageHelper.startPage(pageNum, pageSize);
			List<ManageGoodsDto> goods = manageGoodsService.findGoodsDto(map);
			PageInfo<ManageGoodsDto> page = new PageInfo<>(goods);
			request.setAttribute("page",page);
			return "manage-goods-table";
		}else{
			return "404";
		}

	}

	/**
	 * 查看
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toSelect")
	public String select(HttpServletRequest request,Long id){
		ManageGoods good = manageGoodsService.findByUserId(id);
		request.setAttribute("good",good);
		return "manage-goods-select";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request,Long id) {
		ManageGoods good = manageGoodsService.findByUserId(id);
		request.setAttribute("good",good);
		return "manage-goods-update";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request,ManageGoods good) {
		manageGoodsService.update(good);
		PageHelper.startPage(pageNum, pageSize);
		List<ManageGoodsDto> goods = manageGoodsService.findGoodsDto(map);
		PageInfo<ManageGoodsDto> page = new PageInfo<>(goods);
		request.setAttribute("page",page);
		return "manage-goods-table";
	}

	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request,Long id){
		manageGoodsService.delByUserId(id);
		PageHelper.startPage(pageNum, pageSize);
		List<ManageGoodsDto> goods = manageGoodsService.findGoodsDto(map);
		PageInfo<ManageGoodsDto> page = new PageInfo<>(goods);
		request.setAttribute("page",page);
		return "manage-goods-table";
	}
}
