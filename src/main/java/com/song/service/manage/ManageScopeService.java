package com.song.service.manage;

import com.song.entity.manage.ManageScope;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 经营范围管理实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:02:24
 */
public interface ManageScopeService extends BaseService<ManageScope, Long> {

    List<ManageScope> findByParam(HashMap<String, Object> map);

    void delByUserId(Long id);

    void update(ManageScope scope);

    ManageScope findByUserId(Long id);

    void addShop(ManageScope scope);
}
