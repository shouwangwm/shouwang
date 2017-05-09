package com.zgxcw.service.infrastructure.goods.dao;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsCarStyleLarge;

import java.util.List;

/**
 * 
 * @author wangcs
 * 
 */
public interface GoodsCarStyleLargeMapper {


  /**
   * 获取车型列表
   *
   * @param goodsCarStyle 车型
   * @return 车型列表
   */
  List<CarModel> selectForList(GoodsCarStyleLarge goodsCarStyle);

}
