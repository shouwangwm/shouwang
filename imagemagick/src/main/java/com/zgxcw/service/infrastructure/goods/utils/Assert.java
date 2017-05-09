/**   
* @Title: Assert.java 
* @Package com.zgxcw.service.common.goods.util 
* @Description: TODO 
* @author weiming
* @date 2015年9月29日 下午1:28:23   
*/ 
package com.zgxcw.service.infrastructure.goods.utils;

import java.util.Collection;
import java.util.Map;

/** 
 * 工具类，判断对象、集合为空
 * @ClassName: Assert 
 * @author weiming
 * @date 2015年9月29日 下午1:28:23   
 */
public class Assert {
  
  /**
   * @Description: 断言对象为空，包括空串
   * @param @param obj
   * @param @return    
   * @return boolean
   */
  public static boolean isNull(Object obj){
    if(obj == null){
      return true;
    }
    if(obj instanceof String && "".equals(obj)){
      return true;
    }
    return false;
  }
  
  /**
   * @Description: 断言集合为空
   * @param @param collection
   * @param @return    
   * @return boolean
   */
  public static boolean isEmptyCollection(Collection collection){
    if(collection == null || collection.isEmpty()){
      return true;
    }
    return false;
  }
  
  /**
   * 断言Map为空
   * @param map
   * @return    
   * boolean
   */
  public static boolean isEmptyMap(Map map){
    if(map == null || map.isEmpty()){
      return true;
    }
    return false;
  }
}
