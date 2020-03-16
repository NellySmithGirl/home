package com.song.service.manage;

import com.song.dto.ManageGoodsDto;
import com.song.entity.manage.ManageGoods;
import com.song.entity.manage.ManageScope;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 商品实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 00:58:38
 */
public interface ManageGoodsService extends BaseService<ManageGoods, Long> {

    void delByUserId(Long id);

    List<ManageGoods> findByParam(HashMap<String, Object> map);

    void update(ManageGoods shop);

    ManageGoods findByUserId(Long id);

    void addGoods(ManageGoods good);

    List<ManageScope> findScope();

    List<ManageGoodsDto> findGoodsDto(HashMap<String, Object> map);
}
