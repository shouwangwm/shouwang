package com.zgxcw.service.infrastructure.goods.service.impl;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsCarStyleLarge;
import com.zgxcw.service.infrastructure.goods.dao.GoodsCarStyleLargeMapper;
import com.zgxcw.service.infrastructure.goods.service.GoodsCarStyleLargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: GoodsCarStyleServiceImpl.java
 * @Description: 商品支持的车型服务实现
 * @Author: lisd
 * @DateTime: 2015年9月4日 下午4:26:06
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
@Service
public class GoodsCarStyleLargeServiceImpl implements GoodsCarStyleLargeService {
  private Logger logger = LoggerFactory.getLogger(GoodsCarStyleLargeServiceImpl.class);

  @Resource
  private GoodsCarStyleLargeMapper goodsCarStyleLargeMapper;

  /**
   * 指定条件查询商品支持车型列表
   * 
   * @return List<GoodsCarStyleLargeBeanDto>:商品支持车型列表
   */
  @Override
  public List<CarModel> queryForList(String skuId, long snapshotNo){
    GoodsCarStyleLarge goodsCarStyle = new GoodsCarStyleLarge();
    goodsCarStyle.setGoodsSkuID(skuId);
    goodsCarStyle.setSnapshotNO(snapshotNo);
    List<CarModel> beanList = null;
    try {
      beanList = goodsCarStyleLargeMapper.selectForList(goodsCarStyle);
      // this.goodsCarStyleMapper.selectForList(bean);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("根据条件查询商品支持车型失败!");
    }
    return beanList;
  }
}
