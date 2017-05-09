package com.zgxcw.service.infrastructure.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;
import com.zgxcw.service.infrastructure.goods.dao.CarStyleMapper;
import com.zgxcw.service.infrastructure.goods.dao.GoodsSkuMapper;
import com.zgxcw.service.infrastructure.goods.service.GoodsSkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品SKU服务实现 Created by ykr on 15/8/27
 */
@Service
public class GoodsSkuServiceImpl implements GoodsSkuService {
  private Logger logger = LoggerFactory.getLogger(GoodsSkuServiceImpl.class);

  @Resource
  private GoodsSkuMapper goodsSkuMapper;

  @Resource
  private CarStyleMapper carStyleMapper;


  /**
   * 分页获取商品SKU列表
   * 
   * @param pageNum :查询页数
   * @param pageSize :查询条数
   * @return 商品SKU列表
   */
  @Override
  public PageInfo<GoodsSku> queryForPage(Integer pageNum, Integer pageSize) {
    if (pageNum < 1 || pageSize < 1) {
      throw new RuntimeException("查询页数和查询条数必须大于0");
    }
    GoodsSku bean = new GoodsSku();

    List<GoodsSku> beanList = null;
    // 开始查询
    try {
      PageHelper.startPage(pageNum, pageSize);
      beanList = this.goodsSkuMapper.selectForList(bean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new RuntimeException("获取商品SKU列表失败！");
    }

    PageInfo<GoodsSku> pageInfo = new PageInfo<GoodsSku>(beanList);
    return pageInfo;
  }


  @Override
  public List<CarModel> selectCarModels() {
    return carStyleMapper.selectCarStyle();
  }

}
