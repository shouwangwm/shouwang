package com.zgxcw.service.infrastructure.goods.dao;

import java.util.List;

import com.zgxcw.service.infrastructure.goods.bean.GoodsSkuPicture;

/**
 * @Title: GoodsSkuPictureMapper
 * @Description: 商品图片
 * @Author: wangcs
 * @DateTime:2015年9月15日上午11:56:05
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public interface GoodsSkuPictureMapper {
  /**
   * 插入商品图片
   * @param record 商品图片
   * @return 主键
   */
  int insert(GoodsSkuPicture record);

  /**
   * 删除商品图片
   * @param skuPicID 商品图片id
   * @return 受影响行数
   */
  int deleteByPrimaryKey(String skuPicID);

  /**
   * 修改商品图片
   * @param record 商品图片
   * @return 受影响行数
   */
  int update(GoodsSkuPicture record);
  /**
   * 获取商品SKU图片
   * 
   * @param goodsSkuID:商品SKU标识
   * @return 商品SKU
   */
  GoodsSkuPicture selectByPrimaryKey(String skuPicID);

  /**
   * 获取商品SKU图片列表
   * 
   * @return 商品SKU图片列表
   */
  List<GoodsSkuPicture> selectAll();

  /**
   * 获取商品SKU图片列表
   * 
   * @param goodsSku:商品SKU图片
   * @return 商品SKU列表
   */
  List<GoodsSkuPicture> selectForList(GoodsSkuPicture goodsSkuPicture);
  
  /**
   * 批量添加商品SKU图片
   * 
   * @param goodsSkuOptions：商品SKU图片列表
   * @return
   */
  void insertForBatch(List<GoodsSkuPicture> goodsSkuPictures);
  /**
   * @Author：王朋飞
   * @Description: 
   * @return:void
   * @param:GoodsSkuPicture
   * @Date:2015-10-21 下午7:08:20
   */
  void delete(GoodsSkuPicture goodsSkuPicture);
}
