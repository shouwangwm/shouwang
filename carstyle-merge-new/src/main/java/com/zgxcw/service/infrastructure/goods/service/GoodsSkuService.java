package com.zgxcw.service.infrastructure.goods.service;

import com.github.pagehelper.PageInfo;
import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;

import java.util.List;

/**
 * 商品SKU Created by ykr on 15/9/6
 */
public interface GoodsSkuService {

  /**
   * 分页获取商品SKU列表
   * 
   * @param pageNum :查询页数
   * @param pageSize :查询条数
   * @return 商品SKU列表
   */
  public PageInfo<GoodsSku> queryForPage(Integer pageNum, Integer pageSize);

  public List<CarModel> selectCarModels();
}
