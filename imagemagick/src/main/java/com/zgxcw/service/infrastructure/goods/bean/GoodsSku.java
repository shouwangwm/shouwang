package com.zgxcw.service.infrastructure.goods.bean;

import java.math.BigDecimal;

/**
 * 商品SKU Created by ykr on 15/9/6
 */
public class GoodsSku {

  private String goodsSkuID;

  private Long snapshotNO;

  private String goodsID;

  private String storeID;

  private String brandID;

  private Integer deletionStatus;

  private BigDecimal defaultPrice;

  private Integer soldNum;

  private String logo;

  private String logoMD5;

  private String originalEncoding;

  private String advertisingWords;

  private String description;

  private Integer isSingleProduct;

  private Integer saleStatus;

  private Integer stockStatus;

  private Integer approvalStatus;

  private Long createTime;

  private String createUser;

  private Long updateTime;

  private String updateUser;

  private String unitCode;

  private String inspectionReportNumber;

  private String rejectReason;

  private String skuGoodsName;
  
  private Long submitTime;
  
  private Long deletionTime;
  
  private Long approvalTime;
  
  private Long groundingTime;
  
  private Long underCarriageTime;
  
  private Integer totalBrowseCount;
  
  
  
  public Integer getTotalBrowseCount() {
	return totalBrowseCount;
}

public void setTotalBrowseCount(Integer totalBrowseCount) {
	this.totalBrowseCount = totalBrowseCount;
}

/** 
   * @Description: 获取下架时间
   * @return 下架时间
   */
  public Long getUnderCarriageTime() {
    return underCarriageTime;
  }

  /** 
   * 设置下架时间
   * @param groundingTime ：下架时间
   */
  public void setUnderCarriageTime(Long underCarriageTime) {
    this.underCarriageTime = underCarriageTime;
  }

  /** 
   * @Description: 获取上架时间
   * @return 上架时间
   */
  public Long getGroundingTime() {
    return groundingTime;
  }

  /** 
   * 设置上架时间
   * @param groundingTime ：上架时间
   */
  public void setGroundingTime(Long groundingTime) {
    this.groundingTime = groundingTime;
  }

  /**
   * 获取商品SKU标识
   * 
   * @return 商品SKU标识
   */
  public String getGoodsSkuID() {
    return goodsSkuID;
  }

  /**
   * 设置商品SKU标识
   * 
   * @param goodsSkuID ：SKU标识
   */
  public void setGoodsSkuID(String goodsSkuID) {
    this.goodsSkuID = goodsSkuID == null ? null : goodsSkuID.trim();
  }

  /**
   * 获取商品标识
   * 
   * @return 商品标识
   */
  public String getGoodsID() {
    return goodsID;
  }

  /**
   * 设置商品标识
   * 
   * @param goodsID ：商品标识
   */
  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID == null ? null : goodsID.trim();
  }


  /**
   * 获取状态码
   * 
   * @return 状态码 0：正常　1：删除 2：永久删除
   */
  public Integer getDeletionStatus() {
    return deletionStatus;
  }

  /**
   * 设置状态吗
   * 
   * @param deletionStatus 状态码 0：正常　1：删除 2：永久删除
   */
  public void setDeletionStatus(Integer deletionStatus) {
    this.deletionStatus = deletionStatus;
  }

  /**
   * 获取价格
   * 
   * @return 价格
   */
  public BigDecimal getDefaultPrice() {
    return defaultPrice;
  }

  /**
   * 设置价格
   * 
   * @param defaultPrice ：价格
   */
  public void setDefaultPrice(BigDecimal defaultPrice) {
    this.defaultPrice = defaultPrice;
  }

  /**
   * 获取商标
   * 
   * @return 商标
   */
  public String getLogo() {
    return logo;
  }

  /**
   * 设置商标
   * 
   * @param logo：商标
   */
  public void setLogo(String logo) {
    this.logo = logo == null ? null : logo.trim();
  }

  /**
   * 获取商标哈希值
   * 
   * @return 商标哈希值
   */
  public String getLogoMD5() {
    return logoMD5;
  }

  /**
   * 设置商标哈希值
   * 
   * @param logoMD5：商标哈希值
   */
  public void setLogoMD5(String logoMD5) {
    this.logoMD5 = logoMD5 == null ? null : logoMD5.trim();
  }

  /**
   * 获取原厂编码
   * 
   * @return 原厂编码
   */
  public String getOriginalEncoding() {
    return originalEncoding;
  }

  /**
   * 设置原厂编码
   * 
   * @param originalEncoding：原厂编码
   */
  public void setOriginalEncoding(String originalEncoding) {
    this.originalEncoding = originalEncoding == null ? null : originalEncoding.trim();
  }

  /**
   * 获取广告词
   * 
   * @return 广告词
   */
  public String getAdvertisingWords() {
    return advertisingWords;
  }

  /**
   * 设置广告词
   * 
   * @param advertisingWords：广告词
   */
  public void setAdvertisingWords(String advertisingWords) {
    this.advertisingWords = advertisingWords == null ? null : advertisingWords.trim();
  }

  /**
   * 获取描述
   * 
   * @return 描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置描述
   * 
   * @param description：描述
   */
  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

    /**
     * 获取是否为单品状态
     *
     * @return 是否为单品
     */
    public Integer getIsSingleProduct() {
        return isSingleProduct;
    }

    /**
     * 设置描述
     *
     * @param isSingleProduct：是否为单品
     */
    public void setIsSingleProduct(Integer isSingleProduct) {
        this.isSingleProduct = isSingleProduct;
    }

    /**
   * 获取销售状态
   * 
   * @return 销售状态 0：在售　1：下架　2：总部下架
   */
  public Integer getSaleStatus() {
    return saleStatus;
  }

  /**
   * 设置销售状态
   * 
   * @param saleStatus 销售状态 0：在售　1：下架　2：总部下架 3:待提交
   */
  public void setSaleStatus(Integer saleStatus) {
    this.saleStatus = saleStatus;
  }

  /**
   * 获取库存状态
   * 
   * @return 库存状态
   */
  public Integer getStockStatus() {
    return stockStatus;
  }

  /**
   * 设置库存状态
   * 
   * @param stockStatus：库存状态
   */
  public void setStockStatus(Integer stockStatus) {
    this.stockStatus = stockStatus;
  }

  /**
   * 获取审批状态
   * 
   * @return 审批状态
   */
  public Integer getApprovalStatus() {
    return approvalStatus;
  }

  /**
   * 设置审批状态
   * 
   * @param approvalStatus：审批状态
   */
  public void setApprovalStatus(Integer approvalStatus) {
    this.approvalStatus = approvalStatus;
  }

  /**
   * 获取创建时间
   * 
   * @return 创建时间
   */
  public Long getCreateTime() {
    return createTime;
  }

  /**
   * 设置创建时间
   * 
   * @param createTime ：创建时间
   */
  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取创建操作人
   * 
   * @return 创建操作人
   */
  public String getCreateUser() {
    return createUser;
  }

  /**
   * 设置创建操作人
   * 
   * @param createUser ：创建操作人
   */
  public void setCreateUser(String createUser) {
    this.createUser = createUser == null ? null : createUser.trim();
  }

  /**
   * 获取更新操作时间
   * 
   * @return 更新操作时间
   */
  public Long getUpdateTime() {
    return updateTime;
  }

  /**
   * 设置更新操作时间
   * 
   * @param updateTime :更新操作时间
   */
  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 获取更新操作人
   * 
   * @return 更新操作人
   */
  public String getUpdateUser() {
    return updateUser;
  }

  /**
   * 设置更新操作人
   * 
   * @param updateUser ：更新操作人
   */
  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser == null ? null : updateUser.trim();
  }

  /**
   * 获取单位代码
   * 
   * @return 单位代码
   */
  public String getUnitCode() {
    return unitCode;
  }

  /**
   * 设置单位代码
   * 
   * @param unitCode ：SKU标识
   */
  public void setUnitCode(String unitCode) {
    this.unitCode = unitCode;
  }

  /**
   * 获取品检报告编号
   * 
   * @return 品检报告编号
   */
  public String getInspectionReportNumber() {
    return inspectionReportNumber;
  }

  /**
   * 设置品检报告编号
   * 
   * @param inspectionReportNumber ：SKU标识
   */
  public void setInspectionReportNumber(String inspectionReportNumber) {
    this.inspectionReportNumber = inspectionReportNumber;
  }

  /**
   * 获取驳回原因
   * 
   * @return 驳回原因
   */
  public String getRejectReason() {
    return rejectReason;
  }

  /**
   * 设置驳回原因
   * 
   * @param rejectReason 驳回原因
   */
  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }

  /**
   * 获取商品SKU名
   * 
   * @return 商品SKU名
   */
  public String getSkuGoodsName() {
    return skuGoodsName;
  }

  /**
   * 设置商品SKU名
   * 
   * @param skuGoodsName 商品SKU名
   */
  public void setSkuGoodsName(String skuGoodsName) {
    this.skuGoodsName = skuGoodsName;
  }

  /**
   * 获取提交时间
   * @return
   */
  public Long getSubmitTime() {
    return submitTime;
  }

  /**
   * 设置提交时间
   * @param submitTime
   */
  public void setSubmitTime(Long submitTime) {
    this.submitTime = submitTime;
  }

  /**
   * 获取删除时间
   * @return
   */
  public Long getDeletionTime() {
    return deletionTime;
  }

  /**
   * 设置删除时间
   * @param deletionTime
   */
  public void setDeletionTime(Long deletionTime) {
    this.deletionTime = deletionTime;
  }

  /**
   * 获取批准时间
   * @return
   */
  public Long getApprovalTime () {
    return approvalTime;
  }

  /**
   * 设置批准时间
   * @param approvalTime
   */
  public void setApprovalTime (Long approvalTime) {
    this.approvalTime = approvalTime;
  }


    /**
     * 获取商铺ID
     *
     * @return 商铺ID
     */
    public String getStoreID() {
        return storeID;
    }

    /**
     * 设置商铺ID
     *
     * @param storeID
     */
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    /**
     * 获取品牌ID
     *
     * @return 品牌ID
     */
    public String getBrandID() {
        return brandID;
    }

    /**
     * 设置品牌ID
     *
     * @param brandID
     */
    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public Long getSnapshotNO() {
        return snapshotNO;
    }

    public void setSnapshotNO(Long snapshotNO) {
        this.snapshotNO = snapshotNO;
    }

  public Integer getSoldNum() {
    return soldNum;
  }

  public void setSoldNum(Integer soldNum) {
    this.soldNum = soldNum;
  }
}
