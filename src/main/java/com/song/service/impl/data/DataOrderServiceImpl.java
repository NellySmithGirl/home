package com.song.service.impl.data;

import com.song.entity.data.DataOrder;
import com.song.mapper.BaseMapper;
import com.song.mapper.data.DataOrderMapper;
import com.song.service.data.DataOrderService;
import com.song.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * 订单实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:07:19
 */
@Service("dataOrderService")
public class DataOrderServiceImpl extends BaseServiceImpl<DataOrder, Long> implements DataOrderService {
	
    private static final Logger logger = LoggerFactory.getLogger(DataOrderServiceImpl.class);
   
    @Resource
    private DataOrderMapper dataOrderMapper;

	@Override
	public BaseMapper<DataOrder, Long> getMapper() {
		return dataOrderMapper;
	}

	@Override
	public List<DataOrder> findByParam(HashMap<String, Object> map) {
		return dataOrderMapper.listSelective(map);
	}
}