package com.zgxcw.service.infrastructure.goods.bean;

import java.io.Serializable;

/**
 * @Title: GoodsCarStyle.java
 * @Description: 商品支持车型 Bean
 * @Author: lisd
 * @DateTime: 2015年9月4日 下午5:20:31
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public class GoodsCarStyle implements Serializable {

  private static final long serialVersionUID = 2140242174887004052L;

  private String carStyleID;

  private String goodsID;

  private String goodsSkuID;

  private Long snapshotNO;

  private String carModelID;

  private String carBrandID;

  private String carMasterBrandID;

  private String styleYear;

  private Integer deletionStatus;

  private Long createTime;

  private String createUser;

  private Long updateTime;

  private String updateUser;

  private String displacement;

  // 车型名
  private String carStyleName;

  public GoodsCarStyle() {}


  public String getCarStyleName() {
    return carStyleName;
  }

  public void setCarStyleName(String carStyleName) {
    this.carStyleName = carStyleName;
  }

  /**
   * @Description:获取车型ID
   * @return 车型ID
   */
  public String getCarStyleID() {
    return carStyleID;
  }

  /**
   * @Description: 设置车型ID
   * @param carStyleID 车型ID
   */
  public void setCarStyleID(String carStyleID) {
    this.carStyleID = carStyleID;
  }

  /**
   * @Description: 获取商品标识
   * @return 商品标识
   */
  public String getGoodsID() {
    return goodsID;
  }

  /**
   * @Description: 设置商品标识
   * @param goodsID 商品标识
   */
  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID;
  }

  /**
   * @Description: 获取车系ID
   * @return 车系ID
   */
  public String getCarModelID() {
    return carModelID;
  }

  /**
   * @Description: 设置车系ID
   * @param carModelID 车系ID
   */
  public void setCarModelID(String carModelID) {
    this.carModelID = carModelID;
  }

  /**
   * @Description: 获取品牌ID
   * @return 品牌ID
   */
  public String getCarBrandID() {
    return carBrandID;
  }

  /**
   * @Description: 设置品牌ID
   * @param carBrandID 品牌ID
   */
  public void setCarBrandID(String carBrandID) {
    this.carBrandID = carBrandID;
  }

  /**
   * @Description: 获取厂家ID
   * @return 厂家ID
   */
  public String getCarMasterBrandID() {
    return carMasterBrandID;
  }

  /**
   * @Description: 设置厂家ID
   * @param carMasterBrandID 厂家ID
   */
  public void setCarMasterBrandID(String carMasterBrandID) {
    this.carMasterBrandID = carMasterBrandID;
  }

  /**
   * @Description: 获取年款
   * @return 年款
   */
  public String getStyleYear() {
    return styleYear;
  }

  /**
   * @Description: 设置年款
   * @param styleYear 年款
   */
  public void setStyleYear(String styleYear) {
    this.styleYear = styleYear;
  }

  /**
   * @Description: 获取删除状态
   * @return 删除状态
   */
  public Integer getDeletionStatus() {
    return deletionStatus;
  }

  /**
   * @Description: 设置删除状态
   * @param deletionStatus 删除状态
   */
  public void setDeletionStatus(Integer deletionStatus) {
    this.deletionStatus = deletionStatus;
  }

  /**
   * @Description: 获取创建时间
   * @return 创建时间
   */
  public Long getCreateTime() {
    return createTime;
  }

  /**
   * @Description: 设置创建时间
   * @param createTime 创建时间
   */
  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  /**
   * @Description: 获取创建操作人
   * @return 创建操作人
   */
  public String getCreateUser() {
    return createUser;
  }

  /**
   * @Description: 设置创建操作人
   * @param createUser 创建操作人
   */
  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  /**
   * @Description: 获取更新时间
   * @return 更新时间
   */
  public Long getUpdateTime() {
    return updateTime;
  }

  /**
   * @Description: 设置更新时间
   * @param updateTime 更新时间
   */
  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * @Description: 获取更新操作人
   * @return 更新操作人
   */
  public String getUpdateUser() {
    return updateUser;
  }

  /**
   * @Description: 设置更新操作人
   * @param updateUser 更新操作人
   */
  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  /**
   * @Description: 获取排量
   * @return 排量
   */
  public String getDisplacement() {
    return displacement;
  }

  /**
   * @Description: 设置排量
   * @param displacement 排量
   */
  public void setDisplacement(String displacement) {
    this.displacement = displacement;
  }

  /**
   * @Description: 获取商品SkuID
   * @return 商品SkuID
   */
  public String getGoodsSkuID() {
    return goodsSkuID;
  }

  /**
   * @Description: 设置商品SkuID
   * @param goodsSkuID 商品SkuID
   */
  public void setGoodsSkuID(String goodsSkuID) {
    this.goodsSkuID = goodsSkuID;
  }

  public Long getSnapshotNO() {
    return snapshotNO;
  }

  public void setSnapshotNO(Long snapshotNO) {
    this.snapshotNO = snapshotNO;
  }
}
