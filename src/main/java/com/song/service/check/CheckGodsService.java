package com.song.service.check;

import com.song.dto.CheckGoodsDto;
import com.song.dto.ManageGoodsDto;
import com.song.entity.check.CheckGods;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 商品审核实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:46:20
 */
public interface CheckGodsService extends BaseService<CheckGods, Long> {

    List<CheckGods> findByParam(HashMap<String, Object> map);

    List<CheckGoodsDto> findCheckGoodsDto(HashMap<String, Object> map);

    ManageGoodsDto findGoodsDto(Long id);

    void update(ManageGoodsDto goodsDto);
}
