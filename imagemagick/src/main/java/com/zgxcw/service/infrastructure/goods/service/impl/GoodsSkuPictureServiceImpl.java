package com.zgxcw.service.infrastructure.goods.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgxcw.service.infrastructure.goods.bean.GoodsSkuPicture;
import com.zgxcw.service.infrastructure.goods.dao.GoodsSkuPictureMapper;
import com.zgxcw.service.infrastructure.goods.dto.request.create.GoodsSkuPictureCreateDto;
import com.zgxcw.service.infrastructure.goods.dto.request.modify.GoodsSkuPictureModifyDto;
import com.zgxcw.service.infrastructure.goods.dto.request.query.GoodsSkuPictureQueryDto;
import com.zgxcw.service.infrastructure.goods.dto.response.GoodsSkuPictureBeanDto;
import com.zgxcw.service.infrastructure.goods.service.GoodsSkuPictureService;
import com.zgxcw.service.infrastructure.goods.utils.Assert;
import com.zgxcw.service.infrastructure.goods.utils.BizStatusConstant.DeletionStatus;
import com.zgxcw.service.infrastructure.goods.utils.PageInfoBaseDto;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;
import com.zgxcw.service.infrastructure.goods.utils.ServiceException;

/**
 * @Title: GoodsSkuPictureServiceImpl
 * @Description: 商品图片
 * @Author: wangcs
 * @DateTime:2015年9月15日下午12:54:03
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public class GoodsSkuPictureServiceImpl implements GoodsSkuPictureService {
  private Logger logger = LoggerFactory.getLogger(GoodsSkuPictureServiceImpl.class);
  private GoodsSkuPictureMapper goodsSkuPictureMapper;

  public void setGoodsSkuPictureMapper(GoodsSkuPictureMapper goodsSkuPictureMapper) {
    this.goodsSkuPictureMapper = goodsSkuPictureMapper;
  }

  /**
   * 添加商品SKU图片
   * 
   * @param goodsSkuPictureCreateDto：商品SKU图片
   * @return 主键
   */
  @Override
  public String create(GoodsSkuPictureCreateDto goodsSkuPictureCreateDto) throws ServiceException {
    if (goodsSkuPictureCreateDto == null) {
      throw new ServiceException("没有找到商品图片");
    }
    if (goodsSkuPictureCreateDto.getGoodsSkuID() == null
        || goodsSkuPictureCreateDto.getGoodsSkuID().trim() == "") {
      throw new ServiceException("没有找到商品图片的商品SKUID");
    }
    if (goodsSkuPictureCreateDto.getPictureType() == null) {
      throw new ServiceException("没有找到商品图片的类型pictureType");
    }
    GoodsSkuPicture bean = new GoodsSkuPicture();
    BeanUtils.copyProperties(goodsSkuPictureCreateDto, bean);
    bean.setSkuPicID(new RandomGUID().toString());
    bean.setCreateTime(System.currentTimeMillis());
    try {
      this.goodsSkuPictureMapper.insert(bean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("创建商品图片失败！");
    }
    return bean.getSkuPicID();
  }

  /**
   * 删除商品SKU图片
   * 
   * @param id：商品SKU图片标识
   * @return 受影响行数
   */
  @Override
  public int remove(String id) throws ServiceException {
    if (id == null || id.trim() == "") {
      throw new ServiceException("没有找到商品SKU图片ID");
    }
    try {
      return goodsSkuPictureMapper.deleteByPrimaryKey(id);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("删除商品SKU图片失败！");
    }
  }

  /**
   * 修改商品SKU图片
   * 
   * @param goodsSkuPictureModifyDto：商品SKU图片
   * @return 受影响行数
   */
  @Override
  public int modify(GoodsSkuPictureModifyDto goodsSkuPictureModifyDto) throws ServiceException {
    if (goodsSkuPictureModifyDto == null) {
      throw new ServiceException("没有找到商品SKU图片");
    }
    if (goodsSkuPictureModifyDto.getSkuPicID() == null
        || goodsSkuPictureModifyDto.getSkuPicID().trim() == "") {
      throw new ServiceException("没有找到商品图片的skuPicID");
    }
    GoodsSkuPicture bean = new GoodsSkuPicture();
    BeanUtils.copyProperties(goodsSkuPictureModifyDto, bean);
    bean.setUpdateTime(System.currentTimeMillis());
    try {
      return goodsSkuPictureMapper.update(bean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("修改商品SKU图片失败！");
    }
  }

  /**
   * 获取商品SKU图片
   * 
   * @param id：商品SKU图片标识
   * @return 商品SKU图片
   */
  @Override
  public GoodsSkuPictureBeanDto get(String id) {
    if (id == null || id.trim() == "") {
      throw new ServiceException("没有找到商品SKU图片ID");
    }
    GoodsSkuPicture bean = null;
    try {
      bean = this.goodsSkuPictureMapper.selectByPrimaryKey(id);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("获取商品SKU图片失败！");
    }
    if (bean == null){
      return null;
    }
    GoodsSkuPictureBeanDto beanDto = new GoodsSkuPictureBeanDto();
    BeanUtils.copyProperties(bean, beanDto);
    return beanDto;
  }

  /**
   * 获取商品SKU图片列表
   * 
   * @return 商品SKU图片列表
   */
  @Override
  public List<GoodsSkuPictureBeanDto> queryAll() throws ServiceException {
    List<GoodsSkuPicture> beanList = null;
    try {
      beanList = this.goodsSkuPictureMapper.selectAll();
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("获取商品SKU图片列表失败！");
    }
    List<GoodsSkuPictureBeanDto> dtoList = new ArrayList<GoodsSkuPictureBeanDto>();
    GoodsSkuPictureBeanDto dto;
    for (GoodsSkuPicture beanTemp : beanList) {
      dto = new GoodsSkuPictureBeanDto();
      if (beanTemp != null) {
        BeanUtils.copyProperties(beanTemp, dto);
        dtoList.add(dto);
      }
    }
    return dtoList;
  }

  /**
   * 获取商品SKU图片列表
   * 
   * @param goodsSkuPictureQueryDto：商品SKU图片
   * @return 商品SKU图片列表
   */
  @Override
  public List<GoodsSkuPictureBeanDto> queryForList(GoodsSkuPictureQueryDto goodsSkuPictureQueryDto)
      throws ServiceException {
    GoodsSkuPicture bean = new GoodsSkuPicture();
    if (goodsSkuPictureQueryDto != null) {
      BeanUtils.copyProperties(goodsSkuPictureQueryDto, bean);
    }
    List<GoodsSkuPicture> beanList = null;
    try {
      beanList = this.goodsSkuPictureMapper.selectForList(bean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("获取商品SKU图片列表失败！");
    }
    List<GoodsSkuPictureBeanDto> dtoList = new ArrayList<GoodsSkuPictureBeanDto>();
    GoodsSkuPictureBeanDto dto;
    for (GoodsSkuPicture beanTemp : beanList) {
      dto = new GoodsSkuPictureBeanDto();
      if (beanTemp != null) {
        BeanUtils.copyProperties(beanTemp, dto);
        dtoList.add(dto);
      }
    }
    return dtoList;
  }

  /**
   * 分页获取商品SKU图片列表
   * 
   * @param pageNum :查询页数
   * @param pageSize :查询条数
   * @param goodSkuPictureQueryDto :商品SKU图片
   * @return 商品SKU图片列表
   */
  @Override
  public PageInfoBaseDto<GoodsSkuPictureBeanDto> queryForPage(Integer pageNum, Integer pageSize,
      GoodsSkuPictureQueryDto goodsSkuPictureQueryDto) throws ServiceException {
    if (pageNum < 1 || pageSize < 1) {
      throw new ServiceException("查询页数和查询条数必须大于0");
    }
    GoodsSkuPicture bean = new GoodsSkuPicture();
    if (goodsSkuPictureQueryDto != null) {
      BeanUtils.copyProperties(goodsSkuPictureQueryDto, bean);
    }

    List<GoodsSkuPicture> beanList = null;
    // 开始查询
    try {
      PageHelper.startPage(pageNum, pageSize);
      beanList = this.goodsSkuPictureMapper.selectForList(bean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("获取商品SKU图片列表失败！");
    }

    PageInfo<GoodsSkuPicture> pageInfo = new PageInfo<GoodsSkuPicture>(beanList);
    List<GoodsSkuPictureBeanDto> dtoList = new ArrayList<GoodsSkuPictureBeanDto>();
    GoodsSkuPictureBeanDto dto;
    for (GoodsSkuPicture beanTemp : beanList) {
      dto = new GoodsSkuPictureBeanDto();
      if (beanTemp != null) {
        BeanUtils.copyProperties(beanTemp, dto);
        dtoList.add(dto);
      }
    }
    PageInfoBaseDto<GoodsSkuPictureBeanDto> pageInfoBeanDto =
        new PageInfoBaseDto<GoodsSkuPictureBeanDto>();
    
    BeanUtils.copyProperties(pageInfo, pageInfoBeanDto);
    pageInfoBeanDto.setList(dtoList);
    return pageInfoBeanDto;
  }
  
  /**
   * 批量添加商品图片
   * 
   * @param goodsSkuOptionCreateDtos：商品图片列表
   * @return
   */
  @Override
  public void insertForBatch(Collection<GoodsSkuPictureCreateDto> goodsSkuPictureCreateDtos)
      throws ServiceException {
    
      GoodsSkuPicture bean;
      List<GoodsSkuPicture> beanList = new ArrayList<GoodsSkuPicture>();
      if(!Assert.isEmptyCollection(goodsSkuPictureCreateDtos)){
        for(GoodsSkuPictureCreateDto goodsSkuPictureCreateDto : goodsSkuPictureCreateDtos){
            bean = new GoodsSkuPicture();
            BeanUtils.copyProperties(goodsSkuPictureCreateDto, bean);
            bean.setSkuPicID(new RandomGUID().toString());
            bean.setCreateTime(System.currentTimeMillis());
            /** 删除状态初始：0为正常 */
            bean.setDeletionStatus(DeletionStatus.NORMAL.getCode());
            beanList.add(bean);
        }
      }
      if(!Assert.isEmptyCollection(beanList)){
        try {
          goodsSkuPictureMapper.insertForBatch(beanList);
        } catch (Exception e) {
          logger.error(e.getMessage());
          throw new ServiceException("批量添加商品图片失败！");
        }
      }
      
  }
  /**
   * TODO：多条件删除图片
   * @Author 王朋飞 
   * @see com.zgxcw.service.infrastructure.goods.service.GoodsSkuPictureService#delete(com.zgxcw.service.infrastructure.goods.dto.request.create.GoodsSkuPictureCreateDto)
   */
  @Override
  public void delete(GoodsSkuPictureCreateDto goodsSkuPictureCreateDto)throws ServiceException {
    if (goodsSkuPictureCreateDto == null) {
      throw new ServiceException("多条件删除图片时，没有找到商品SKU图片");
    }
    GoodsSkuPicture bean = new GoodsSkuPicture();
    BeanUtils.copyProperties(goodsSkuPictureCreateDto, bean);
    bean.setUpdateTime(System.currentTimeMillis());
    try {
       goodsSkuPictureMapper.delete(bean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw new ServiceException("多条件删除商品SKU图片失败！");
    }
  }
}
