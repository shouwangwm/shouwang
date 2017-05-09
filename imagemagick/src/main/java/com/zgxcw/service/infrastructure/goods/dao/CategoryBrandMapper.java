package com.zgxcw.service.infrastructure.goods.dao;

import java.util.List;

import com.zgxcw.service.infrastructure.goods.bean.CategoryBrand;

/**
 * @project_name: category-service-impl
 * @description: 类目品牌DAO接口定义
 * @author: Jin Miao
 * @create_date: 2015年9月7日
 * @modify_date: 2015年9月7日
 */
public interface CategoryBrandMapper {

  /**
   * 添加品牌
   * 
   * @param record :品牌
   * @return
   */
  int insert(CategoryBrand record);

  /**
   * 删除品牌
   * 
   * @param id :品牌id
   * @return
   */
  int deleteByPrimaryKey(String id);

  /**
   * 修改品牌
   * 
   * @param record : 品牌
   * @return
   */
  int update(CategoryBrand record);

  /**
   * 获取品牌
   * 
   * @param id :品牌id
   * @return 品牌
   */
  CategoryBrand selectByPrimaryKey(String id);

  /**
   * 获取品牌列表
   * 
   * @return 品牌列表
   */

  List<CategoryBrand> selectAll();

  /**
   * 获取品牌列表
   * 
   * @param record :品牌
   * @return 品牌列表
   */

  List<CategoryBrand> selectForList(CategoryBrand record);
}
