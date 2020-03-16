package com.song.service.impl.manage;

import com.song.entity.manage.ManageScope;
import com.song.mapper.BaseMapper;
import com.song.mapper.manage.ManageScopeMapper;
import com.song.service.impl.BaseServiceImpl;
import com.song.service.manage.ManageScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * 经营范围管理实体ServiceImpl
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:02:24
 */
@Service("manageScopeService")
public class ManageScopeServiceImpl extends BaseServiceImpl<ManageScope, Long> implements ManageScopeService {
	
    private static final Logger logger = LoggerFactory.getLogger(ManageScopeServiceImpl.class);
   
    @Resource
    private ManageScopeMapper manageScopeMapper;

	@Override
	public BaseMapper<ManageScope, Long> getMapper() {
		return manageScopeMapper;
	}

	@Override
	public List<ManageScope> findByParam(HashMap<String, Object> map) {
		return manageScopeMapper.listSelective(map);
	}

	@Override
	public void delByUserId(Long id) {
		manageScopeMapper.delByUserId(id);
	}

	@Override
	public void update(ManageScope scope) {
		manageScopeMapper.update(scope);
	}

	@Override
	public ManageScope findByUserId(Long id) {
		return manageScopeMapper.findByPrimary(id);
	}

	@Override
	public void addShop(ManageScope scope) {
		manageScopeMapper.save(scope);
	}
}