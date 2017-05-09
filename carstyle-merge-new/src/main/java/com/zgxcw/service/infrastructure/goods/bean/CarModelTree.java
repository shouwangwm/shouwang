package com.zgxcw.service.infrastructure.goods.bean;

import java.util.Map;

/**
 * Created by wangcs on 2016/6/30.
 */
public class CarModelTree {

    private String id;

    private int level;

    private Map<String,CarModelTree> children;
    
    private boolean isCommon;
    

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        isCommon = common;
    }

    public Map<String, CarModelTree> getChildren() {
        return children;
    }

    public void setChildren(Map<String, CarModelTree> children) {
        this.children = children;
    }
}
