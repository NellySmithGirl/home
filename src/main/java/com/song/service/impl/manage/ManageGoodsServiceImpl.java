package com.song.service.impl.manage;

import com.song.dto.ManageGoodsDto;
import com.song.entity.check.CheckGods;
import com.song.entity.manage.ManageGoods;
import com.song.entity.manage.ManageScope;
import com.song.mapper.BaseMapper;
import com.song.mapper.check.CheckGodsMapper;
import com.song.mapper.manage.ManageGoodsMapper;
import com.song.mapper.manage.ManageScopeMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.manage.ManageGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 商品实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:58:38
 */
@Service("manageGoodsService")
public class ManageGoodsServiceImpl extends BaseServiceImpl<ManageGoods, Long> implements ManageGoodsService {
	
    private static final Logger logger = LoggerFactory.getLogger(ManageGoodsServiceImpl.class);
   
    @Autowired
    private ManageGoodsMapper manageGoodsMapper;

    @Autowired
    private ManageScopeMapper manageScopeMapper;
    @Autowired
    private CheckGodsMapper checkGodsMapper;

	@Override
	public BaseMapper<ManageGoods, Long> getMapper() {
		return manageGoodsMapper;
	}

	@Override
	public void delByUserId(Long id) {
		manageGoodsMapper.delByUserId(id);
	}

	@Override
	public List<ManageGoods> findByParam(HashMap<String, Object> map) {
		return manageGoodsMapper.listSelective(map);
	}

	@Override
	public void update(ManageGoods goods) {
		manageGoodsMapper.update(goods);
	}

	@Override
	public ManageGoods findByUserId(Long id) {
		return manageGoodsMapper.findByPrimary(id);
	}

	@Override
	public void addGoods(ManageGoods good) {
		good.setStatus("1");
		good.setRemark("待审核");
		good.setCreateTime(new Date());
		good.setUserId(1);
		manageGoodsMapper.save(good);
		CheckGods checkGods = new CheckGods();
		checkGods.setGoodsId(Integer.parseInt(good.getId().toString()));
		checkGods.setScopeId(good.getScopeId());
		checkGods.setRemark("待审核");
		checkGods.setStatus("1");
		checkGods.setUserId(1);
		checkGodsMapper.save(checkGods);
	}

	@Override
	public List<ManageScope> findScope() {
		HashMap<String, Object> map = new HashMap<>();
		return manageScopeMapper.listSelective(map);
	}

	@Override
	public List<ManageGoodsDto> findGoodsDto(HashMap<String, Object> map) {
		return checkGodsMapper.findManageGoodsDto(map);
	}
}