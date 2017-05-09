package com.zgxcw.service.infrastructure.goods.dao;

import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;

import java.util.List;

/**
 * 商品SKU Created by ykr on 15/9/6
 */
public interface GoodsSkuMapper {


  /**
   * 获取商品SKU列表
   * 
   * @param goodsSku:商品SKU
   * @return 商品SKU列表
   */
  List<GoodsSku> selectForList(GoodsSku goodsSku);
}
