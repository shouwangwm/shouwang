package com.zgxcw.service.infrastructure.goods.service;

import java.util.Collection;
import java.util.List;

import com.zgxcw.service.infrastructure.goods.dto.request.create.GoodsSkuPictureCreateDto;
import com.zgxcw.service.infrastructure.goods.dto.request.modify.GoodsSkuPictureModifyDto;
import com.zgxcw.service.infrastructure.goods.dto.request.query.GoodsSkuPictureQueryDto;
import com.zgxcw.service.infrastructure.goods.dto.response.GoodsSkuPictureBeanDto;
import com.zgxcw.service.infrastructure.goods.utils.PageInfoBaseDto;
import com.zgxcw.service.infrastructure.goods.utils.ServiceException;

/**
 * @Title: GoodsSkuPictureService
 * @Description: 商品图片
 * @Author: wangcs
 * @DateTime:2015年9月15日下午12:44:24
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public interface GoodsSkuPictureService {

  /**
   * 添加商品图片
   * 
   * @param goodsSkuCreateDto：商品图片
   * @return 主键
   */
  String create(GoodsSkuPictureCreateDto goodsSkuPictureCreateDto)throws ServiceException;

  /**
   * 删除商品图片
   * 
   * @param goodsSkuID：商品图片
   * @return 受影响行数
   */
  int remove(String goodsSkuPictureID)throws ServiceException;

  /**
   * 修改商品图片
   * 
   * @param goodsSkuModifyDto：商品图片
   * @return 受影响行数
   */
  int modify(GoodsSkuPictureModifyDto goodsSkuPictureModifyDto)throws ServiceException;

  /**
   * 获取商品图片
   * 
   * @param goodsSkuID：商品图片标识
   * @return 商品图片
   */
  GoodsSkuPictureBeanDto get(String goodsSkuPictureID)throws ServiceException;



  /**
   * 获取商品图片列表
   * 
   * @return 商品图片列表
   */
  List<GoodsSkuPictureBeanDto> queryAll()throws ServiceException;

  /**
   * 获取商品图片列表
   * 
   * @param goodsSkuQueryDto：商品图片
   * @return 商品图片列表
   */
  List<GoodsSkuPictureBeanDto> queryForList(GoodsSkuPictureQueryDto goodsSkuPictureQueryDto)throws ServiceException;

  /**
   * 分页获取商品图片列表
   * 
   * @param pageNum :查询页数
   * @param pageSize :查询条数
   * @param goodsSkuQueryDto :商品图片
   * @return 商品图片列表
   */
  PageInfoBaseDto<GoodsSkuPictureBeanDto> queryForPage(Integer pageNum, Integer pageSize,
      GoodsSkuPictureQueryDto goodsSkuPictureQueryDto)throws ServiceException;
  
  /**
   * 批量添加商品图片
   * 
   * @param goodsSkuOptionCreateDtos：商品图片列表
   * @return
   */
  void insertForBatch(Collection<GoodsSkuPictureCreateDto> goodsSkuPictureCreateDtos)
      throws ServiceException;
  /**
   * @Author：王朋飞
   * @Description:多条件删除图片 
   * @return:void
   * @param:Collection<GoodsSkuPictureCreateDto>
   * @Date:2015-10-21 下午7:05:07
   */
  void delete(GoodsSkuPictureCreateDto goodsSkuPictureCreateDto) throws ServiceException;
}
