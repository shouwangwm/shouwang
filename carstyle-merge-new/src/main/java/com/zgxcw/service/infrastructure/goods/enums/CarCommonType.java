package com.zgxcw.service.infrastructure.goods.enums;

/**
 * 车型通用类别
 * @author: machao
 * @version:1.0.0
 */
public enum CarCommonType {

    /**
     * 不通用
     */
    NONE(0, "不通用"),
    /**
     * 乘用车通用
     */
    ORDINARY(1, "乘用车通用"),
    /**
     * 商用车通用
     */
    INDUSTRIAL(2, "商用车通用"),
    /**
     * 全品类通用
     */
    ALL(3, "全品类通用"),
    /**
     * 车型主品牌通用
     */
    MASTERBRAND(4, "车型主品牌通用"),
    /**
     * 车型子品牌通用
     */
    SUBBRAND(5, "车型子品牌通用"),
    /**
     * 车型车系通用
     */
    SERIES(6, "车型车系通用");

    private int code;
    private String description;

    CarCommonType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarCommonType getCarCommonTypeByCode(int code) {
        for (CarCommonType carCommonType : CarCommonType.values()) {
            if (carCommonType.getCode() == code) {
                return carCommonType;
            }
        }
        return null;
    }

}
