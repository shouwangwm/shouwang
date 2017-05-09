package com.zgxcw.service.infrastructure.goods.dao;

import java.util.List;

import com.zgxcw.service.infrastructure.goods.bean.Store;

public interface StoreMapper {

  int deleteByPrimaryKey(String storeid);

  int insert(Store record);

  Store selectByPrimaryKey(String storeid);

  int update(Store record);

  List<Store> selectAll();

  List<Store> selectForList(Store bean);

  boolean updateByStoreIdAndIsPass(Store store);
  
  boolean updateStoreStatus(Store store);
  
  /**
   * 
   * @Description:批量修改店铺评分
   * @param dtoList
   * @return
   * @author: liangkaiqiang
   * @time:2015年10月26日
   */
  int beachUpdateStoreOperation(List<Store> dtoList);

  List<Store> selectStoreList(String id);
}
