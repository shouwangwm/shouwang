/**   
 * @Title: ImageServiceImpl.java 
 * @Package com.zgxcw.service.infrastructure.store.service 
 * @Description: TODO 
 * @author weiming
 * @date 2015年11月1日 下午4:29:47   
 */ 
package com.zgxcw.service.infrastructure.goods.service.impl;

import java.util.List;
import java.util.Map;

import com.zgxcw.service.infrastructure.goods.bean.Cover;
import com.zgxcw.service.infrastructure.goods.dao.CoverMapper;
import com.zgxcw.service.infrastructure.goods.service.CoverService;

/** 
 * @ClassName: ImageServiceImpl 
 * @Description: TODO
 * @author weiming
 * @date 2015年11月1日 下午4:29:47   
 */

public class CoverServiceImpl implements CoverService{
  
  
  CoverMapper coverMapper;
  
  public CoverMapper getCoverMapper() {
    return coverMapper;
  }

  public void setCoverMapper(CoverMapper coverMapper) {
    this.coverMapper = coverMapper;
  }

 
  public List<Cover> selectForList(Map map) {
    return coverMapper.selectForList(map);
  }
}
