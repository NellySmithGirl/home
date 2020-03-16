package com.song.service.impl.data;

import com.song.entity.data.DataCount;
import com.song.mapper.BaseMapper;
import com.song.mapper.data.DataCountMapper;
import com.song.service.data.DataCountService;
import com.song.service.impl.BaseServiceImpl;
import com.song.util.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 商品客流量统计实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:13:41
 */
@Service("dataCountService")
public class DataCountServiceImpl extends BaseServiceImpl<DataCount, Long> implements DataCountService {
	
    private static final Logger logger = LoggerFactory.getLogger(DataCountServiceImpl.class);
   
    @Resource
    private DataCountMapper dataCountMapper;

	@Override
	public BaseMapper<DataCount, Long> getMapper() {
		return dataCountMapper;
	}

	@Override
	public List<DataCount> findByParam(HashMap<String, Object> map) {
		return dataCountMapper.listSelective(map);
	}
}