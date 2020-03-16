package com.song.mapper.check;

import com.song.dto.CheckShopDto;
import com.song.dto.ManageShopDto;
import com.song.entity.check.CheckShop;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

import java.util.HashMap;
import java.util.List;

/**
 * 商铺审核实体Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:15:47
 */
@RDBatisDao
public interface CheckShopMapper extends BaseMapper<CheckShop, Long> {


    ManageShopDto findShopDto(Long id);

    List<CheckShopDto> findCheckShopDto(HashMap<String, Object> map);
}
