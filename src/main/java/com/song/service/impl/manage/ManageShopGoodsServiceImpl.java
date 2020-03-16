package com.song.service.impl.manage;

import com.song.entity.manage.ManageShopGoods;
import com.song.mapper.BaseMapper;
import com.song.mapper.manage.ManageShopGoodsMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.manage.ManageShopGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 商铺商品关联实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:04:56
 */
@Service("manageShopGoodsService")
public class ManageShopGoodsServiceImpl extends BaseServiceImpl<ManageShopGoods, Long> implements ManageShopGoodsService {
	
    private static final Logger logger = LoggerFactory.getLogger(ManageShopGoodsServiceImpl.class);
   
    @Resource
    private ManageShopGoodsMapper manageShopGoodsMapper;

	@Override
	public BaseMapper<ManageShopGoods, Long> getMapper() {
		return manageShopGoodsMapper;
	}
	
}