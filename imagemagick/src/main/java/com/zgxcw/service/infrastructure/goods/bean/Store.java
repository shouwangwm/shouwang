package com.zgxcw.service.infrastructure.goods.bean;

public class Store {
  private String storeID;

  private String storeName;

  private String storeDesc;

  private String storeAdvertisePic;

  private String storeType;

  private String region;

  private String storeAddr;

  private String storeDomainName;

  private String serviceTele;

  private Long operationTimeBegin;

  private Long operationTimeEnd;

  private String brandID;

  private String coorprationID;

  private Integer storeStatus;

  private Integer approvalStatus;

  private String servicePromise;

  private Integer stationNum;

  private Integer canApproverepireFactory;

  /* 品牌资质图片地址 */
  private String brandQualification;

  /* 检验报告图片地址 */
  private String inspectionReport;

  /* 专利证书图片地址 */
  private String patentCert;

  /* 品牌获奖证书图片地址 */
  private String awardCert;

  private String storeKeywords;

  private Integer signStatus;

  private String serviceStationID;

  private Integer storeScore;

  private Long createTime;

  private String createUser;

  private Long updateTime;

  private String updateUser;

  private String otherQualificationImages;
  //累计浏览数
  private Integer totalBrowseCount;

  private String rejectReason;

  public String getStoreID() {
    return storeID;
  }

  public void setStoreID(String storeID) {
    this.storeID = storeID == null ? null : storeID.trim();
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName == null ? null : storeName.trim();
  }

  public String getStoreDesc() {
    return storeDesc;
  }

  public void setStoreDesc(String storeDesc) {
    this.storeDesc = storeDesc == null ? null : storeDesc.trim();
  }

  public String getStoreAdvertisePic() {
    return storeAdvertisePic;
  }

  public void setStoreAdvertisePic(String storeAdvertisePic) {
    this.storeAdvertisePic = storeAdvertisePic == null ? null : storeAdvertisePic.trim();
  }

  public String getStoreType() {
    return storeType;
  }

  public void setStoreType(String storeType) {
    this.storeType = storeType == null ? null : storeType.trim();
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region == null ? null : region.trim();
  }

  public String getStoreAddr() {
    return storeAddr;
  }

  public void setStoreAddr(String storeAddr) {
    this.storeAddr = storeAddr == null ? null : storeAddr.trim();
  }

  /**
   * @Description: 获取店铺域名
   * @return 店铺域名
   */
  public String getStoreDomainName() {
    return storeDomainName;
  }

  /**
   * @Description: 设置店铺域名
   * @param storeDomainName 店铺域名
   */
  public void setStoreDomainName(String storeDomainName) {
    this.storeDomainName = storeDomainName;
  }

  public String getServiceTele() {
    return serviceTele;
  }

  public void setServiceTele(String serviceTele) {
    this.serviceTele = serviceTele == null ? null : serviceTele.trim();
  }

  public Long getOperationTimeBegin() {
    return operationTimeBegin;
  }

  public void setOperationTimeBegin(Long operationTimeBegin) {
    this.operationTimeBegin = operationTimeBegin;
  }

  public Long getOperationTimeEnd() {
    return operationTimeEnd;
  }

  public void setOperationTimeEnd(Long operationTimeEnd) {
    this.operationTimeEnd = operationTimeEnd;
  }

  public String getBrandID() {
    return brandID;
  }

  public void setBrandID(String brandID) {
    this.brandID = brandID == null ? null : brandID.trim();
  }

  public String getCoorprationID() {
    return coorprationID;
  }

  public void setCoorprationID(String coorprationID) {
    this.coorprationID = coorprationID == null ? null : coorprationID.trim();
  }

  public Integer getStoreStatus() {
    return storeStatus;
  }

  public void setStoreStatus(Integer storeStatus) {
    this.storeStatus = storeStatus;
  }

  public Integer getApprovalStatus() {
    return approvalStatus;
  }

  public void setApprovalStatus(Integer approvalStatus) {
    this.approvalStatus = approvalStatus;
  }

  public String getServicePromise() {
    return servicePromise;
  }

  public void setServicePromise(String servicePromise) {
    this.servicePromise = servicePromise == null ? null : servicePromise.trim();
  }

  public Integer getStationNum() {
    return stationNum;
  }

  public void setStationNum(Integer stationNum) {
    this.stationNum = stationNum;
  }

  public Integer getCanApproverepireFactory() {
    return canApproverepireFactory;
  }

  public void setCanApproverepireFactory(Integer canApproverepireFactory) {
    this.canApproverepireFactory = canApproverepireFactory;
  }

  /**
   * @Description: 获取品牌资质图片地址
   * @return 品牌资质图片地址
   */
  public String getBrandQualification() {
    return brandQualification;
  }

  /**
   * @Description: 设置品牌资质图片地址
   * @param brandQualification 品牌资质图片地址
   */
  public void setBrandQualification(String brandQualification) {
    this.brandQualification = brandQualification;
  }

  /**
   * @Description: 获取检验报告图片地址
   * @return 检验报告图片地址
   */
  public String getInspectionReport() {
    return inspectionReport;
  }

  /**
   * @Description: 设置检验报告图片地址
   * @param inspectionReport 检验报告图片地址
   */
  public void setInspectionReport(String inspectionReport) {
    this.inspectionReport = inspectionReport;
  }

  /**
   * @Description: 获取专利证书图片地址
   * @return 专利证书图片地址
   */
  public String getPatentCert() {
    return patentCert;
  }

  /**
   * @Description: 设置专利证书图片地址
   * @param patentCert 专利证书图片地址
   */
  public void setPatentCert(String patentCert) {
    this.patentCert = patentCert;
  }

  /**
   * @Description: 获取品牌获奖证书图片地址
   * @return 品牌获奖证书图片地址
   */
  public String getAwardCert() {
    return awardCert;
  }

  /**
   * @Description: 设置品牌获奖证书图片地址
   * @param awardCert 品牌获奖证书图片地址
   */
  public void setAwardCert(String awardCert) {
    this.awardCert = awardCert;
  }

  public String getStoreKeywords() {
    return storeKeywords;
  }

  public void setStoreKeywords(String storeKeywords) {
    this.storeKeywords = storeKeywords;
  }


  public Integer getSignStatus() {
    return signStatus;
  }

  public void setSignStatus(Integer signStatus) {
    this.signStatus = signStatus;
  }

  public String getServiceStationID() {
    return serviceStationID;
  }

  public void setServiceStationID(String serviceStationID) {
    this.serviceStationID = serviceStationID;
  }

  /**
   * @Description: 获取店铺评分
   * @return 店铺评分
   */
  public Integer getStoreScore() {
    return storeScore;
  }

  /**
   * @Description: 设置店铺评分
   * @param storeScore 店铺评分
   */
  public void setStoreScore(Integer storeScore) {
    this.storeScore = storeScore;
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
    this.createUser = createUser == null ? null : createUser.trim();
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
    this.updateUser = updateUser == null ? null : updateUser.trim();
  }

  /**
   * @return 累计浏览数
   */
  public Integer getTotalBrowseCount() {
	return totalBrowseCount;
  }

  /**
   * @param 累计浏览数
   */
  public void setTotalBrowseCount(Integer totalBrowseCount) {
	this.totalBrowseCount = totalBrowseCount;
  }

  public String getOtherQualificationImages() {
    return otherQualificationImages;
  }

  public void setOtherQualificationImages(String otherQualificationImages) {
    this.otherQualificationImages = otherQualificationImages;
  }

  public String getRejectReason() {
    return rejectReason;
  }

  public void setRejectReason(String rejectReason) {
    this.rejectReason = rejectReason;
  }
}
