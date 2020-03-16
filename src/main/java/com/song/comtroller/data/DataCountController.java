package com.song.comtroller.data;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.entity.data.DataCount;
import com.song.service.data.DataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 商品客流量统计实体Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:13:41
 */
@Controller
@RequestMapping("/dataCount")
public class DataCountController {

	@Autowired
	private DataCountService dataCountService;

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
		List<DataCount> counts = dataCountService.findByParam(map);
		PageInfo<DataCount> page = new PageInfo<>(counts);
		request.setAttribute("page",page);
		return "data-count-table";
	}
}
