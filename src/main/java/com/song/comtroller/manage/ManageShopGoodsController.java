package com.song.comtroller.manage;

import com.song.service.manage.ManageShopGoodsService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 商铺商品关联实体Controller
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-18 01:04:56
 */
@Controller
public class ManageShopGoodsController {

	@Resource
	private ManageShopGoodsService manageShopGoodsService;

}
