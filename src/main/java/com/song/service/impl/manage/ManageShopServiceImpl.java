package com.song.service.impl.manage;

import com.song.entity.check.CheckShop;
import com.song.entity.manage.ManageShop;
import com.song.mapper.BaseMapper;
import com.song.mapper.check.CheckShopMapper;
import com.song.mapper.manage.ManageScopeMapper;
import com.song.mapper.manage.ManageShopMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.manage.ManageShopService;
import com.song.util.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 商铺实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:50:44
 */
@Service("manageShopService")
public class ManageShopServiceImpl extends BaseServiceImpl<ManageShop, Long> implements ManageShopService {
	
    private static final Logger logger = LoggerFactory.getLogger(ManageShopServiceImpl.class);
   
    @Autowired
    private ManageShopMapper manageShopMapper;
    @Autowired
    private CheckShopMapper checkShopMapper;

	@Override
	public BaseMapper<ManageShop, Long> getMapper() {
		return manageShopMapper;
	}

	@Override
	public List<ManageShop> findByParam(HashMap<String, Object> map) {
		return manageShopMapper.listSelective(map);
	}

	@Override
	public void addShop(ManageShop shop) {
		shop.setStatus("1");
		shop.setRemark("待审核");
		shop.setCreateTime(new Date());
		shop.setUserId(1);
		manageShopMapper.save(shop);
		CheckShop checkShop = new CheckShop();
		checkShop.setShopId(Integer.parseInt(shop.getId().toString()));
		checkShop.setRemark("待审核");
		checkShop.setStatus("1");
		checkShop.setScopeId(shop.getScopeId());
		checkShop.setUserId(1);
		checkShopMapper.save(checkShop);
	}

	@Override
	public void delByUserId(Long id) {
		manageShopMapper.delByUserId(id);
	}

	@Override
	public void update(ManageShop shop) {
		manageShopMapper.update(shop);
	}

	@Override
	public ManageShop findByUserId(Long id) {
		return manageShopMapper.findByPrimary(id);
	}
}