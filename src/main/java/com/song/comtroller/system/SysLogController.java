package com.song.comtroller.system;

import com.song.service.system.SysLogService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 系统操作日志Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:02:51
 */
@Controller
public class SysLogController {

	@Resource
	private SysLogService sysLogService;

}
