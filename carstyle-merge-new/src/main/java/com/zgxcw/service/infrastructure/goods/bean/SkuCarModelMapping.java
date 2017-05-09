package com.zgxcw.service.infrastructure.goods.bean;

/**
 * Created by wangcs on 2016/7/1.
 */
public class SkuCarModelMapping {

    private String id;
    private String carMasterBrandId;
    private String carSubBrandId;
    private String carSeriesId;
    private String carModelId;
    private String commonType;
    private long createTime;
    private String creatorId;
//    private long lastUpdateTime;
    private String lastUpdaterId;
    private String skuId;
    private long snapshotNo;
    private int deletionStatus;
    private String carType;
    private String attr1;
    private String attr2;
    
    public String getAttr1() {
		return attr1;
	}
	

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	

	public String getAttr2() {
		return attr2;
	}
	

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarMasterBrandId() {
        return carMasterBrandId;
    }

    public void setCarMasterBrandId(String carMasterBrandId) {
        this.carMasterBrandId = carMasterBrandId;
    }

    public String getCarSubBrandId() {
        return carSubBrandId;
    }

    public void setCarSubBrandId(String carSubBrandId) {
        this.carSubBrandId = carSubBrandId;
    }

    public String getCarSeriesId() {
        return carSeriesId;
    }

    public void setCarSeriesId(String carSeriesId) {
        this.carSeriesId = carSeriesId;
    }

    public String getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(String carModelId) {
        this.carModelId = carModelId;
    }

    public String getCommonType() {
        return commonType;
    }

    public void setCommonType(String commonType) {
        this.commonType = commonType;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

//    public long getLastUpdateTime() {
//        return lastUpdateTime;
//    }
//
//    public void setLastUpdateTime(long lastUpdateTime) {
//        this.lastUpdateTime = lastUpdateTime;
//    }

    public String getLastUpdaterId() {
        return lastUpdaterId;
    }

    public void setLastUpdaterId(String lastUpdaterId) {
        this.lastUpdaterId = lastUpdaterId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public long getSnapshotNo() {
        return snapshotNo;
    }

    public void setSnapshotNo(long snapshotNo) {
        this.snapshotNo = snapshotNo;
    }

    public int getDeletionStatus() {
        return deletionStatus;
    }

    public void setDeletionStatus(int deletionStatus) {
        this.deletionStatus = deletionStatus;
    }


	@Override
	public String toString() {
		return "SkuCarModelMapping [id=" + id + ", carMasterBrandId="
				+ carMasterBrandId + ", carSubBrandId=" + carSubBrandId
				+ ", carSeriesId=" + carSeriesId + ", carModelId=" + carModelId
				+ ", commonType=" + commonType + ", createTime=" + createTime
				+ ", creatorId=" + creatorId + ", lastUpdaterId="
				+ lastUpdaterId + ", skuId=" + skuId + ", snapshotNo="
				+ snapshotNo + ", deletionStatus=" + deletionStatus
				+ ", carType=" + carType + ", attr1=" + attr1 + ", attr2="
				+ attr2 + "]";
	}
    
}
