package com.zgxcw.service.infrastructure.goods.dto.request.query;

import java.io.Serializable;

/**
 * 
 * @Title: GoodsSkuPictureQueryDto
 * @Description: 商品图片
 * @Author: wangcs
 * @DateTime:2015年9月15日上午11:38:49
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public class GoodsSkuPictureQueryDto implements Serializable {

	private static final long serialVersionUID = 3532678981492362267L;
	private String skuPicID;

	private String photoDesc;

	private String goodsSkuID;

	private String goodsID;

	private Long snapshotNO;

	private String resolutionCode;

	private Integer pictureType;

	private String pictureFile;

	private Integer deletionStatus;

	private Long createTime;

	private String createUser;

	private Long updateTime;

	private String updateUser;

	private Long isMainPic;

	/**
	 * 获取图片分辨率代码resolutionCode
	 * 
	 * @return
	 */
	public String getResolutionCode() {
		return resolutionCode;
	}

	/**
	 * 设置图片分辨率代码resolutionCode
	 * 
	 * @param resolutionCode
	 */
	public void setResolutionCode(String resolutionCode) {
		this.resolutionCode = resolutionCode;
	}

	/**
	 * 获取sku图片标识
	 * 
	 * @return sku图片标识
	 */
	public String getSkuPicID() {
		return skuPicID;
	}

	/**
	 * 设置sku图片标识
	 * 
	 * @param skuPicID
	 *            sku图片标识
	 */
	public void setSkuPicID(String skuPicID) {
		this.skuPicID = skuPicID;
	}

	/**
	 * 获取图片描述
	 * 
	 * @return 图片描述
	 */
	public String getPhotoDesc() {
		return photoDesc;
	}

	/**
	 * 设置图片描述
	 * 
	 * @param photoDesc
	 *            图片描述
	 */
	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
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
	 * @param goodsSkuID
	 *            商品SKU标识
	 */
	public void setGoodsSkuID(String goodsSkuID) {
		this.goodsSkuID = goodsSkuID;
	}

	/**
	 * 获取图片类型 1：商品图片　2：质检报告
	 * 
	 * @return 图片类型 1：商品图片　2：质检报告
	 */
	public Integer getPictureType() {
		return pictureType;
	}

	/**
	 * 设置图片类型 1：商品图片　2：质检报告
	 * 
	 * @param pictureType
	 */
	public void setPictureType(Integer pictureType) {
		this.pictureType = pictureType;
	}

	/**
	 * 获取图片文件地址
	 * 
	 * @return 图片文件地址
	 */
	public String getPictureFile() {
		return pictureFile;
	}

	/**
	 * 设置图片文件地址
	 * 
	 * @param pictureFile
	 *            图片文件地址
	 */
	public void setPictureFile(String pictureFile) {
		this.pictureFile = pictureFile;
	}

	/**
	 * 获取删除状态
	 * 
	 * @return 删除状态
	 */
	public Integer getDeletionStatus() {
		return deletionStatus;
	}

	/**
	 * 删除状态
	 * 
	 * @param deletionStatus
	 *            删除状态
	 */
	public void setDeletionStatus(Integer deletionStatus) {
		this.deletionStatus = deletionStatus;
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
	 * @param createTime
	 *            创建时间
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
	 * @param createUser
	 *            创建操作人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取更新时间
	 * 
	 * @return 更新时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 * 
	 * @param updateTime
	 *            更新时间
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
	 * @param updateUser
	 *            更新操作人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Long getSnapshotNO() {
		return snapshotNO;
	}

	public void setSnapshotNO(Long snapshotNO) {
		this.snapshotNO = snapshotNO;
	}

	public Long getIsMainPic() {
		return isMainPic;
	}

	public void setIsMainPic(Long isMainPic) {
		this.isMainPic = isMainPic;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
}
