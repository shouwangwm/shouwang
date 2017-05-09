package com.zgxcw.service.infrastructure.goods.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品SKU Created by ykr on 15/9/6
 */
public class GoodsSku implements Serializable {

  private static final long serialVersionUID = 5192465830816680053L;

  private String goodsSkuID;

  private Long snapshotNO;

  private String goodsID;
  
  private Integer deletionStatus;
  
  public Integer getDeletionStatus() {
	return deletionStatus;
}


public void setDeletionStatus(Integer deletionStatus) {
	this.deletionStatus = deletionStatus;
}


public GoodsSku() {}

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

  public String getGoodsID() {
    return goodsID;
  }

  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID;
  }
}
