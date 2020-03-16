package com.song.service.data;

import com.song.entity.data.DataOrder;
import com.song.service.BaseService;

import java.util.HashMap;
import java.util.List;

/**
 * 订单实体Service
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:07:19
 */
public interface DataOrderService extends BaseService<DataOrder, Long> {

    List<DataOrder> findByParam(HashMap<String, Object> map);
}
