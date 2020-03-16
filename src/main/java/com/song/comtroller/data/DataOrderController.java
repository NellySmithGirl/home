package com.song.comtroller.data;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.entity.data.DataCount;
import com.song.entity.data.DataOrder;
import com.song.service.data.DataOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 订单实体Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:07:19
 */
@Controller
@RequestMapping("/dataMonth")
public class DataOrderController {

	@Autowired
	private DataOrderService dataOrderService;

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
		List<DataOrder> counts = dataOrderService.findByParam(map);
		PageInfo<DataOrder> page = new PageInfo<>(counts);
		request.setAttribute("page",page);
		return "data-order-table";
	}
}
