package com.zgxcw.service.infrastructure.goods.service;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsCarStyle;

import java.util.List;

/**
 * @Title: GoodsCarStyleService.java
 * @Description: 商品支持车型接口
 */
public interface GoodsCarStyleService {


  /**
   * 获取车型列表
   * 
   * @return 车型列表
   */
  List<CarModel> queryForList(String skuId, long snapshotNo);


  /**
   * 查询是否为全品牌通用
   * @param skuId
   * @return
     */
  boolean isCommon(String skuId);
  
}
