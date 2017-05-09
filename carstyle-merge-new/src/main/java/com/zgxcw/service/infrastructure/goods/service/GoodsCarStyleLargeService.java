package com.zgxcw.service.infrastructure.goods.service;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsCarStyleLarge;

import java.util.List;

/**
 * @Title: GoodsCarStyleLargeService.java
 * @Description: 商品支持大车车型接口
 */
public interface GoodsCarStyleLargeService {

  /**
   * 获取车型列表
   * 
   * @return 车型列表
   */
  List<CarModel> queryForList(String skuId, long snapshotNo);
  
}
