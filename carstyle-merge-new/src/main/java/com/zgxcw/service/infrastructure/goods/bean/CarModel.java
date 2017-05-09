package com.zgxcw.service.infrastructure.goods.bean;

/**
 * Created by wangcs on 2016/7/1.
 */
public class CarModel {
    private String masterBrandId;

    private String brandId;

//    private String seriesId;

    private String modelId;
    
    private String carstyleId;
    
    private String commonType;
    
    private String attr1;
    
    private String attr2;
    
    
    public String getCarstyleId() {
		return carstyleId;
	}
	

	public void setCarstyleId(String carstyleId) {
		this.carstyleId = carstyleId;
	}
	

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
	
	public String getMasterBrandId() {
        return masterBrandId;
    }

    public void setMasterBrandId(String masterBrandId) {
        this.masterBrandId = masterBrandId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

//    public String getSeriesId() {
//        return seriesId;
//    }
//
//    public void setSeriesId(String seriesId) {
//        this.seriesId = seriesId;
//    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getCommonType() {
        return commonType;
    }

    public void setCommonType(String commonType) {
        this.commonType = commonType;
    }
}
