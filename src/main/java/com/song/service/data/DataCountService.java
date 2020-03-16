package com.song.service.data;

import com.song.entity.data.DataCount;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 商品客流量统计实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:13:41
 */
public interface DataCountService extends BaseService<DataCount, Long> {

    List<DataCount> findByParam(HashMap<String, Object> map);
}
