package com.song.service.impl.check;

import com.song.dto.CheckGoodsDto;
import com.song.dto.ManageGoodsDto;
import com.song.entity.check.CheckGods;
import com.song.mapper.BaseMapper;
import com.song.mapper.check.CheckGodsMapper;
import com.song.mapper.manage.ManageGoodsMapper;
import com.song.service.check.CheckGodsService;
import com.song.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 商品审核实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:46:20
 */
@Service("checkGodsService")
public class CheckGodsServiceImpl extends BaseServiceImpl<CheckGods, Long> implements CheckGodsService {
	
    private static final Logger logger = LoggerFactory.getLogger(CheckGodsServiceImpl.class);
   
    @Autowired
    private CheckGodsMapper checkGodsMapper;

    @Autowired
    private ManageGoodsMapper manageGoodsMapper;


	@Override
	public BaseMapper<CheckGods, Long> getMapper() {
		return checkGodsMapper;
	}

	@Override
	public List<CheckGods> findByParam(HashMap<String, Object> map) {
		return checkGodsMapper.listSelective(map);
	}

	@Override
	public List<CheckGoodsDto> findCheckGoodsDto(HashMap<String, Object> map) {
		return checkGodsMapper.findCheckGoodsDto(map);
	}

	@Override
	public ManageGoodsDto findGoodsDto(Long id) {
		return checkGodsMapper.findGoodsDto(id);
	}

	@Override
	public void update(ManageGoodsDto goodsDto) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("status",goodsDto.getStatus());
		map.put("remark",goodsDto.getRemark());
		map.put("id",goodsDto.getId());
		manageGoodsMapper.updateSelective(map);
		map.clear();
		map.put("createTime",new Date());
		//todo 审核完修改scopeId userId
		map.put("status",goodsDto.getStatus());
		map.put("remark",goodsDto.getRemark());
		map.put("id",goodsDto.getCheckId());
		checkGodsMapper.updateSelective(map);
	}
}