package com.song.mapper.check;

import com.song.dto.CheckGoodsDto;
import com.song.dto.ManageGoodsDto;
import com.song.entity.check.CheckGods;
import com.song.mapper.BaseMapper;
import com.song.mapper.RDBatisDao;

import java.util.HashMap;
import java.util.List;

/**
 * 商品审核实体Dao
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:46:20
 */
@RDBatisDao
public interface CheckGodsMapper extends BaseMapper<CheckGods, Long> {


    List<CheckGoodsDto> findCheckGoodsDto(HashMap<String, Object> map);

    ManageGoodsDto findGoodsDto(Long id);

    List<ManageGoodsDto> findManageGoodsDto(HashMap<String, Object> map);
}
