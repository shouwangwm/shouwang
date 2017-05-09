package com.zgxcw.service.infrastructure.goods.dao;

import java.util.List;
import java.util.Map;

import com.zgxcw.service.infrastructure.goods.dto.response.GoodsSkuPictureBeanDto;
import com.zgxcw.service.infrastructure.goods.utils.ServiceException;

/**
 * @Title: GoodsAllViewMapper
 * @Description: 商品相关的试图dao
 * @Author: 赵永平
 * @DateTime: 2015年9月19日 下午6:10:03
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public interface GoodsAllViewMapper {
	
  /**
   * 获取所有商品图片的主图(用于修改图片水印)
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  public List<GoodsSkuPictureBeanDto> getAllMainPic(Map<String,Object> map)throws ServiceException;
  /**
   * 通过主图ID获取各种像素的图片(用于修改图片水印)
   * @param parasMap
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  public List<GoodsSkuPictureBeanDto> getAllPicByMainId(Map<String,Object> parasMap)throws ServiceException;
  /**
   * 通过图片ID更新tfs上图片
   * @param parasMap
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  public int updateSkuPic(Map<String,Object> parasMap)throws ServiceException;
  
  /**
   * 获取总条数
   * weiming
   * @return    
   * Long
   */
  public Long getCount();
}
