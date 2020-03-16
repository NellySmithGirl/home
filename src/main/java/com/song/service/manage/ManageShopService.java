package com.song.service.manage;

import com.song.entity.manage.ManageShop;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 商铺实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:50:44
 */
public interface ManageShopService extends BaseService<ManageShop, Long> {

    List<ManageShop> findByParam(HashMap<String, Object> map);

    void addShop(ManageShop shop);

    void delByUserId(Long id);

    void update(ManageShop shop);

    ManageShop findByUserId(Long id);
}
