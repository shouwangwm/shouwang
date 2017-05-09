/**   
 * @Title: ImageService.java 
 * @Package com.zgxcw.service.infrastructure.store.service 
 * @Description: TODO 
 * @author weiming
 * @date 2015年11月1日 下午4:27:00   
 */ 
package com.zgxcw.service.infrastructure.goods.service;

import java.util.List;
import java.util.Map;

import com.zgxcw.service.infrastructure.goods.bean.Cover;

/** 
 * @ClassName: ImageService 
 * @author weiming
 * @date 2015年11月1日 下午4:27:00   
 */
public interface CoverService {
  
  /**
   * 
   * @Description: 
   * @return    
   * List<Cover>
   */
  public List<Cover> selectForList(Map map);
  
}
