package com.zgxcw.service.infrastructure.goods.bean;

/**
 * @project_name: category-service-impl
 * @description: 品牌信息类
 * @author: Jin Miao
 * @create_date: 2015年9月6日
 * @modify_date: 2015年9月6日
 */
public class CategoryBrand {

  /* 品牌标识 */
  private String brandId;

  /* 父品牌标识 */
  private String parentBrandID;

  /* 品牌名称 */
  private String brandName;

  /* 商标LOGO图片存放地址 */
  private String logo;

  /* 品牌简介 */
  private String brandDesc;

  /* 启用状态 0：启用 1：停用 */
  private Integer enableStatus;

  /* 删除状态 0：正常 1：删除 */
  private Integer deletionStatus;

  /* 创建时间 */
  private Long createTime;

  /* 创建人 */
  private String createUser;

  /* 更新时间 */
  private Long updateTime;

  /* 更新操作人 */
  private String updateUser;

  public String getBrandId() {
    return brandId;
  }

  public void setBrandId(String brandId) {
    this.brandId = brandId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getBrandDesc() {
    return brandDesc;
  }

  public void setBrandDesc(String brandDesc) {
    this.brandDesc = brandDesc;
  }

  public Integer getEnableStatus() {
    return enableStatus;
  }

  public void setEnableStatus(Integer enableStatus) {
    this.enableStatus = enableStatus;
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

  public String getParentBrandID() {
    return parentBrandID;
  }

  public void setParentBrandID(String parentBrandID) {
    this.parentBrandID = parentBrandID;
  }
}
