/**   
 * @Title: ImageAction.java 
 * @Package com.zgxcw.service.infrastructure.goods.action 
 * @Description: TODO 
 * @author weiming
 * @date 2015年11月2日 上午10:17:38   
 */ 
package com.zgxcw.service.infrastructure.goods.action;

import java.util.List;
import java.util.Map;

import com.zgxcw.service.infrastructure.goods.dto.response.GoodsSkuPictureBeanDto;
import com.zgxcw.service.infrastructure.goods.utils.ServiceException;

/** 
 * @ClassName: ImageAction 
 * @Description: TODO
 * @author weiming
 * @date 2015年11月2日 上午10:17:38   
 */
public interface ImageAction {

  /**
   * 获取所有商品图片的主图(用于修改图片水印)
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  public List<GoodsSkuPictureBeanDto> queryAllMainPic(Map<String,Object> map)throws ServiceException;
  /**
   * 通过主图ID获取各种像素的图片(用于修改图片水印)
   * @param mainPicId
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  public List<GoodsSkuPictureBeanDto> queryAllPicByMainId(String mainPicId)throws ServiceException;
  /**
   * 通过图片ID更新tfs上图片
   * @param skupicId
   * @param newtfsFile
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  public int updateSkuPic(String skupicId,String newtfsFile)throws ServiceException;
  /**
   * 执行更新方法入口
   * @throws ServiceException
   */
  public void excuteModify()throws ServiceException;
  
  
}
