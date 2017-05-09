package com.zgxcw.service.infrastructure.goods.bean;

import java.io.Serializable;

/**
 * @Title: GoodsCarStyleLarge.java
 * @Description: 商品支持车型(大车) Bean
 * @Author: wangcs
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public class GoodsCarStyleLarge implements Serializable {

  private static final long serialVersionUID = 2198250973841141439L;
  private String carStyleID;
  private String goodsID;
  private String goodsSkuID;
  private Long snapshotNO;
  private String bigCarTypeID;
  private String bigMasterBrandID;
  private String bigCarModelID;
  private String hoursePowerVal;
  private String driverVal;
  private Integer deletionStatus;
  private Long createTime;
  private String createUser;
  private Long updateTime;
  private String updateUser;
  private String firstSpell;
  private String allSelectType;

  public GoodsCarStyleLarge() {}

  public String getCarStyleID() {
    return carStyleID;
  }

  public void setCarStyleID(String carStyleID) {
    this.carStyleID = carStyleID;
  }

  public String getGoodsID() {
    return goodsID;
  }

  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID;
  }

  public String getGoodsSkuID() {
    return goodsSkuID;
  }

  public void setGoodsSkuID(String goodsSkuID) {
    this.goodsSkuID = goodsSkuID;
  }

  public Long getSnapshotNO() {
    return snapshotNO;
  }

  public void setSnapshotNO(Long snapshotNO) {
    this.snapshotNO = snapshotNO;
  }

  public String getBigCarTypeID() {
    return bigCarTypeID;
  }

  public void setBigCarTypeID(String bigCarTypeID) {
    this.bigCarTypeID = bigCarTypeID;
  }

  public String getBigMasterBrandID() {
    return bigMasterBrandID;
  }

  public void setBigMasterBrandID(String bigMasterBrandID) {
    this.bigMasterBrandID = bigMasterBrandID;
  }

  public String getBigCarModelID() {
    return bigCarModelID;
  }

  public void setBigCarModelID(String bigCarModelID) {
    this.bigCarModelID = bigCarModelID;
  }

  public String getHoursePowerVal() {
    return hoursePowerVal;
  }

  public void setHoursePowerVal(String hoursePowerVal) {
    this.hoursePowerVal = hoursePowerVal;
  }

  public String getDriverVal() {
    return driverVal;
  }

  public void setDriverVal(String driverVal) {
    this.driverVal = driverVal;
  }

  public Integer getDeletionStatus() {
    return deletionStatus;
  }

  public void setDeletionStatus(Integer deletionStatus) {
    this.deletionStatus = deletionStatus;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public String getFirstSpell() {
    return firstSpell;
  }

  public void setFirstSpell(String firstSpell) {
    this.firstSpell = firstSpell;
  }

  public String getAllSelectType() {
    return allSelectType;
  }

  public void setAllSelectType(String allSelectType) {
    this.allSelectType = allSelectType;
  }

  @Override
  public String toString() {
    return "GoodsCarStyleLarge [carStyleID=" + carStyleID + ", goodsID=" + goodsID
        + ", goodsSkuID=" + goodsSkuID + ", snapshotNO=" + snapshotNO + ", bigCarTypeID="
        + bigCarTypeID + ", bigMasterBrandID=" + bigMasterBrandID + ", bigCarModelID="
        + bigCarModelID + ", hoursePowerVal=" + hoursePowerVal + ", driverVal=" + driverVal
        + ", deletionStatus=" + deletionStatus + ", createTime=" + createTime + ", createUser="
        + createUser + ", updateTime=" + updateTime + ", updateUser=" + updateUser
        + ", firstSpell=" + firstSpell + ", allSelectType=" + allSelectType + "]";
  }

}
