package com.zgxcw.service.infrastructure.goods.dao;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsCarStyle;

import java.util.List;

/**
 * 
 * @author lsf
 * 
 */
public interface GoodsCarStyleMapper {


  /**
   * 获取车型列表
   * 
   * @param goodsCarStyle：车型
   * @return 车型列表
   */
  List<CarModel> selectForList(GoodsCarStyle goodsCarStyle);

  List<String> queryBusinessAttr(String goodsSkuId);
  
}
