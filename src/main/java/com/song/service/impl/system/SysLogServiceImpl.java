package com.song.service.impl.system;

import com.song.entity.system.SysLog;
import com.song.mapper.BaseMapper;
import com.song.mapper.system.SysLogMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.system.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 系统操作日志ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:02:51
 */
@Service("sysLogService")
public class SysLogServiceImpl extends BaseServiceImpl<SysLog, Long> implements SysLogService {
	
    private static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);
   
    @Resource
    private SysLogMapper sysLogMapper;

	@Override
	public BaseMapper<SysLog, Long> getMapper() {
		return sysLogMapper;
	}
	
}