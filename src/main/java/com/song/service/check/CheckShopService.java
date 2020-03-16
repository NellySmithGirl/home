package com.song.service.check;

import com.song.dto.CheckShopDto;
import com.song.dto.ManageShopDto;
import com.song.entity.check.CheckShop;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 商铺审核实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:15:47
 */
public interface CheckShopService extends BaseService<CheckShop, Long> {

    List<CheckShop> findByParam(HashMap<String, Object> map);

    CheckShop findByUserId(Long id);

    ManageShopDto findShopDto(Long id);

    void update(ManageShopDto shopDto);

    List<CheckShopDto> findCheckShopDto(HashMap<String, Object> map);
}
