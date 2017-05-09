package com.zgxcw.service.infrastructure.goods.dao;

import java.util.List;

import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;

/**
 * 商品SKU Created by ykr on 15/9/6
 */
public interface GoodsSkuMapper {

  /**
   * 添加商品SKU
   * 
   * @param record：商品SKU
   * @return 主键
   */
  int insert(GoodsSku record);

  /**
   * 删除商品SKU
   * 
   * @param goodsSku ：商品SKU
   * @return 受影响行数
   */
  int deleteByPrimaryKey(GoodsSku goodsSku);

  /**
   * 业务上删除商品SKU，通过商品标识和店铺标识设置商品SKU的删除状态为删除或永久性删除
   * 
   * @param goodsSku 商品SKU
   * @return 受影响行数
   */
  int deleteOnBusiness(GoodsSku goodsSku);

  /**
   * 修改商品SKU
   * 
   * @param record：商品SKU
   * @return 受影响行数
   */
  int update(GoodsSku record);

  /**
   * 获取商品SKU
   * 
   * @param goodsSku :商品SKU标识
   * @return 商品SKU
   */
  GoodsSku selectByPrimaryKey(GoodsSku goodsSku);

  /**
   * 获取商品SKU列表
   * 
   * @return 商品SKU列表
   */
  List<GoodsSku> selectAll();

  /**
   * 获取商品SKU列表
   * 
   * @param goodsSku:商品SKU
   * @return 商品SKU列表
   */
  List<GoodsSku> selectForList(GoodsSku goodsSku);
  /**
   * 获取商品sku的最大版本号
   * @param goodsSku：商品sku
   * @return 最大版本号
   */
  int selectMaxSnapshotNO(GoodsSku goodsSku);
//  /**
//   * 更新商品SKU表、库存表、SKU可选项表、SKU商品价格表、SKU商品图片表 这5张表中的删除状态
//   * 
//   * @param record 商品SKU属性以及受影响行数
//   * @return 商品SKU属性以及受影响行数
//   */
//  Map<String, Object> updateSkuDeletionStatus(Map<String, Object> map);
  
  /**
   * 删除商品SKU，非物理删除，通过goodsSkuID、快照号 更新删除状态 
   * @param goodsSku 商品SKU
   * @return
   * @throws ServiceException    
   * int   更新行数
   */
  int deleteGoodsSku(GoodsSku goodsSku);
  
  /**
   * 批量更新商品
   * @param list 商品SKU列表
   * @return    
   * int 更新行数
   */
  int updateForBatch(List<GoodsSku> list);

  /**
   * 统计商品数量
   * @param goodsSkuQueryDto
   * @return
   */
  int selectCount(GoodsSku goodsSku);
}
