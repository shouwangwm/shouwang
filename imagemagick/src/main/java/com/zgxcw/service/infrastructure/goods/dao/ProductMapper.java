/**   
 * @Title: CoverMapper.java 
 * @Package com.zgxcw.img.dao 
 * @Description: TODO 
 * @author weiming
 * @date 2015年10月31日 下午7:43:26   
 */ 
package com.zgxcw.service.infrastructure.goods.dao;

import java.util.List;
import java.util.Map;

import com.zgxcw.service.infrastructure.goods.bean.Product;

/** 
 * @ClassName: CoverMapper 
 * @Description: TODO
 * @author weiming
 * @date 2015年10月31日 下午7:43:26   
 */
public interface ProductMapper {
  
  
  List<Product> selectForList(Map map);
}
