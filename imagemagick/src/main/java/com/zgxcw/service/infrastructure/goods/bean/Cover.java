/**   
 * @Title: Cover.java 
 * @Package com.zgxcw.img.bean 
 * @Description: TODO 
 * @author weiming
 * @date 2015年10月31日 下午5:58:29   
 */ 
package com.zgxcw.service.infrastructure.goods.bean;

/** 
 * @ClassName: Cover 
 * @Description: TODO
 * @author weiming
 * @date 2015年10月31日 下午5:58:29   
 */
public class Cover {
  
  private String id;
  
  private String productID;
  
  private String image;
  
  private Integer isDefault;
  
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Integer isDefault) {
    this.isDefault = isDefault;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
}
