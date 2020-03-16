package com.song.service.impl.check;

import com.song.dto.CheckShopDto;
import com.song.dto.ManageShopDto;
import com.song.entity.check.CheckShop;
import com.song.entity.manage.ManageShop;
import com.song.mapper.BaseMapper;
import com.song.mapper.check.CheckShopMapper;
import com.song.mapper.manage.ManageShopMapper;
import com.song.service.check.CheckShopService;
import com.song.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 商铺审核实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:15:47
 */
@Service("checkShopService")
public class CheckShopServiceImpl extends BaseServiceImpl<CheckShop, Long> implements CheckShopService {
	
    private static final Logger logger = LoggerFactory.getLogger(CheckShopServiceImpl.class);
   
    @Autowired
    private CheckShopMapper checkShopMapper;
    @Autowired
    private ManageShopMapper manageShopMapper;

	@Override
	public BaseMapper<CheckShop, Long> getMapper() {
		return checkShopMapper;
	}

	@Override
	public List<CheckShop> findByParam(HashMap<String, Object> map) {
		return checkShopMapper.listSelective(map);
	}

	@Override
	public CheckShop findByUserId(Long id) {
		return checkShopMapper.findByPrimary(id);
	}

	@Override
	public ManageShopDto findShopDto(Long id) {
		return checkShopMapper.findShopDto(id);
	}

	@Override
	@Transactional
	public void update(ManageShopDto shopDto) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("shopName",shopDto.getShopName());
		ManageShop shop = manageShopMapper.findSelective(map);
		map.clear();
		map.put("id",shopDto.getCheckId());
		map.put("status",shopDto.getStatus());
		map.put("remark",shopDto.getRemark());
		map.put("createTime",new Date());
		checkShopMapper.updateSelective(map);
		map.clear();
		map.put("id",shop.getId());
		//todo 审核完scopeId userId
//		map.put("scopeId",shopDto);
//		map.put("userId",shopDto.get)
		map.put("status",shopDto.getStatus());
		map.put("remark",shopDto.getRemark());
		manageShopMapper.updateSelective(map);
	}

	@Override
	public List<CheckShopDto> findCheckShopDto(HashMap<String, Object> map) {
		return checkShopMapper.findCheckShopDto(map);
	}
}