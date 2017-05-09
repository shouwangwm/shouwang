/**
 * @Title: ImageActionImpl.java
 * @Package com.zgxcw.service.infrastructure.goods.action.impl
 * @Description: TODO
 * @author weiming
 * @date 2015年11月2日 上午10:19:46
 */
package com.zgxcw.service.infrastructure.goods.action.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.taobao.common.tfs.DefaultTfsManager;
import com.zgxcw.service.infrastructure.goods.action.ImageAction;
import com.zgxcw.service.infrastructure.goods.dao.GoodsAllViewMapper;
import com.zgxcw.service.infrastructure.goods.dto.response.GoodsSkuPictureBeanDto;
import com.zgxcw.service.infrastructure.goods.utils.FileUploadUtils;
import com.zgxcw.service.infrastructure.goods.utils.ImageSizeConverter;
import com.zgxcw.service.infrastructure.goods.utils.ImageTools;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;
import com.zgxcw.service.infrastructure.goods.utils.ServiceException;

/**
 * 更新图片实现 
 * @ClassName: ImageActionImpl
 * @author 赵永平
 * @date 2015年11月16日 上午23:33:46
 */
public class ImageActionImpl implements ImageAction {

  private Logger log = LoggerFactory.getLogger(getClass().getName());
  
  int success = 0 ;
  int fail = 0 ;
  
  /** 生成文件临时目录 */
  @Value("#{configProperties['temp.path']}")
  private String tempFilePath;
  
  /** 水印图片路径 */
  @Value("#{configProperties['logo.path']}")
  private String logoPath;
  
  /** magemagick的安装路径 */
  @Value("#{configProperties['imageMagick.path']}")
  private String imageMagickPath;
  
  private GoodsAllViewMapper goodsAllViewMapper;
  /** tfs服务 */
  @Autowired
  private DefaultTfsManager defaultTfsManager ;
  /**
   * @return the goodsAllViewMapper
   */
  public GoodsAllViewMapper getGoodsAllViewMapper() {
    return goodsAllViewMapper;
  }

  /**
   * @param goodsAllViewMapper the goodsAllViewMapper to set
   */
  public void setGoodsAllViewMapper(GoodsAllViewMapper goodsAllViewMapper) {
    this.goodsAllViewMapper = goodsAllViewMapper;
  }

  /**
   * 获取所有商品图片的主图(用于修改图片水印)
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  @Override
  public List<GoodsSkuPictureBeanDto> queryAllMainPic(Map<String,Object> map) throws ServiceException {
    List<GoodsSkuPictureBeanDto> allMainPic = goodsAllViewMapper.getAllMainPic(map);
    return allMainPic;
  }
  /**
   * 通过主图ID获取各种像素的图片(用于修改图片水印)
   * @param mainPicId
   * @return
   * @throws ServiceException
   * @author: zhaoyongping
   * @time:2015年11月16日 下午15:00:33
   */
  @Override
  public List<GoodsSkuPictureBeanDto> queryAllPicByMainId(String mainPicId) throws ServiceException {
    if(null == mainPicId || "".equals(mainPicId.trim())){
      throw new NullPointerException("主图ID为空");
    }
    Map<String,Object> parasMap = new HashMap<String,Object>();
    parasMap.put("mainPictureID", mainPicId);
    List<GoodsSkuPictureBeanDto> picList = goodsAllViewMapper.getAllPicByMainId(parasMap);
    return picList;
  }
  /**
   * 更新图片
   */
  @Override
  public int updateSkuPic(String skupicId,String newtfsFile) throws ServiceException {
    if(null == skupicId || "".equals(skupicId.trim())){
      throw new NullPointerException("图片ID为空");
    }
    if(null == newtfsFile || "".equals(newtfsFile.trim())){
      throw new NullPointerException("图片url为空");
    }
    Map<String,Object> parasMap = new HashMap<String,Object>();
    parasMap.put("skuPicID", skupicId);
    parasMap.put("pictureFile", newtfsFile);
    return goodsAllViewMapper.updateSkuPic(parasMap);
  }
  /**
   * 调用更新图片方法
   * @param pictureFile
   * @param convertScaleFile
   * @param localFileName
   * @param width
   * @param height
   * @param bean
   * @param picList
   */
  private void invokeUpdatePic(String pictureFile,String convertScaleFile,
      String localFileName,
      GoodsSkuPictureBeanDto bean,
      List<GoodsSkuPictureBeanDto> picList) throws Exception{
   
    if(null != picList && picList.size() > 0){
      convertScaleFile = tempFilePath + new RandomGUID().toString();
      convertScaleFile = FileUploadUtils.pathFormat(convertScaleFile);
      
      //转分辨率后002(主图带水印)：800*800/400*400的图片路径
      bean = picList.get(0);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 800, 800, bean);
      }
      //转分辨率后003(正品-详情-缩略图)：56＊56的图片路径
      bean = picList.get(1);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 56, 56,bean);
      }
      //转分辨率后004(正品-详情-主图)：350＊350 的图片路径
      bean = picList.get(2);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 350,350,bean);
      }
      //转分辨率后005(正品首页-热销商品、猜你喜欢)：130*130的图片路径
      bean = picList.get(3);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 130,130,bean);
      }
      //转分辨率后006(商城首页-热销商品)：166*181的图片路径
      bean = picList.get(4);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 166,181,bean);
      }
      //转分辨率后007(商城首页-明星商品)：88*123的图片路径
      bean = picList.get(5);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 88,123,bean);
      }
      //转分辨率后008(商城-列表)：140*140的图片路径
      bean = picList.get(6);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 140,140,bean);
      }
      //转分辨率后009(同品类、同品牌商品)：156*156的图片路径
      bean = picList.get(7);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 156,156,bean);
      }
      //转分辨率后010(正品-所有正品列表，搜索列表、店铺首页列表)：200*200 的图片路径
      bean = picList.get(8);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 200,200,bean);
      }
      //转分辨率后011(品牌馆-搜索结果)：210*144的图片路径
      bean = picList.get(9);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 210,144,bean);
      }
      //转分辨率后 012(主图) 400*400的图片路径
      bean = picList.get(10);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 400,400,bean);
      }
      //转分辨率后013(订单与支付) 80*80的图片路径
      bean = picList.get(11);
      if(null != bean){
        this.updatePicFile(convertScaleFile, localFileName, 80,80,bean);
      }
    }
    /**
     * 使用完后删除临时图片
     */
    FileUploadUtils.deleteFile(localFileName);
  }
  /**
   * 更新图片文件
   * @param convertScaleFile 转换为指定分辨率后的图片路径
   * @param localFileName 加水印后的图片文件路径
   * @param width 指定分辨率 宽
   * @param height 指定分辨率 高
   * @param bean 图片对象
   */
  private void updatePicFile(String convertScaleFile,
      String localFileName,int width, int height,
      GoodsSkuPictureBeanDto bean) throws Exception{
    //2.1将加水印的主图的分辨率转成800*800
//    ImageSizeConverter.scaleFree(localFileName, convertScaleFile,width, height);
    new ImageTools(imageMagickPath).zoomImage(width, height, localFileName, convertScaleFile);
    //2.2保存加水印的主图到tfs服务器上
    String newtfsFile = defaultTfsManager.saveFile(convertScaleFile,null,null);
    //3.更新数据库中加水印的主图
    if(null != newtfsFile && !"".equals(newtfsFile.trim())){
      String skupicId = bean.getSkuPicID();
      if(null != skupicId && !"".equals(skupicId.trim())){
        //更新
        Map<String,Object> parasMap = new HashMap<String,Object>();
        parasMap.put("skuPicID", skupicId);
        parasMap.put("pictureFile", newtfsFile);
        parasMap.put("updateUser", "sys");
        parasMap.put("updateTime", System.currentTimeMillis());
        int result = goodsAllViewMapper.updateSkuPic(parasMap);
        log.info("当前修改  skupicId ： " + skupicId + "  , pictureFile : " + newtfsFile + "  , resolutioncode: " +  bean.getResolutionCode() + " , "+ (result == 1 ? "成功" : "失败"));
        if(result == 1){
          success ++;
        }else{
          fail ++;
        }
      }
    }
    /**
     * 使用完后删除临时图片
     */
    FileUploadUtils.deleteFile(convertScaleFile);
  }
  /**
   * 获取所有商品图片的主图(用于修改图片水印)
   * @Author: zhaoyongping
   */
  public void excuteModify(){
    List<GoodsSkuPictureBeanDto> mainPicList = null;
      Long count = null;
      int successCount = 0; 
      int otherEmptyCount = 0 ;
      int mainPicExceptionCount = 0 ;
      int mainPicEmptyCount = 0 ;
      int fromTfsCount = 0;
      int markCount = 0;
      try {
         File filePath = new File(tempFilePath); 
         if(!filePath.exists()){
           filePath.mkdirs();
         }
         count = goodsAllViewMapper.getCount();
      } catch (ServiceException e) {
        log.error("查询主图总数异常!");
        throw new RuntimeException("查询主图总数异常!");
      }
      log.info("主图总数：" + count);
      if(null != count){
//         for(int i=0; i<count; i=i+1000){ 
//           log.error("已处理总数 ：" + i + ", 未处理总数 ： " + (count - i));
           try {
              Map<String,Object> map = new HashMap<String,Object>();
              map.put("min", 0);
              map.put("max", 5000);
              mainPicList = this.goodsAllViewMapper.getAllMainPic(map);
            } catch (ServiceException e) {
              log.error("查询主图集合异常!");
              mainPicExceptionCount ++;
              throw new RuntimeException("查询所有的主图异常!");
            }
            int mainCount = mainPicList.size();
            if(null == mainPicList || mainCount == 0){
              log.info("查询主图集合为空!");
              mainPicEmptyCount ++;
              return;
            }
            if(null != mainPicList && mainCount > 0){
              GoodsSkuPictureBeanDto skuPicObj = null;
              for(int i=0;i<mainCount;i++){
                skuPicObj = mainPicList.get(i);
                if(null != skuPicObj){
                  //获取主图ID
                  String mainPicId = skuPicObj.getSkuPicID();
                  log.info("正在处理第" + i + "条数据,还有" + ( mainCount - i )+ "条数据未处理,当前主图ID : "+mainPicId);
                  if(null != mainPicId && !"".equals(mainPicId.trim())){
                    List<GoodsSkuPictureBeanDto> picList = null;
                    try {
                      Map<String,Object> parasMap = new HashMap<String,Object>();
                      parasMap.put("mainPictureID", mainPicId);
                      picList = this.goodsAllViewMapper.getAllPicByMainId(parasMap);
                    } catch (ServiceException e) {
                      log.error("通过800*800主图图片ID查询所有其它分辨率的图片集合异常!");
                    }
                    if(null == picList || picList.size() == 0){
                      otherEmptyCount ++;
                      log.error("通过800*800主图图片ID查询所有其它分辨率的图片集合为空!");
                      continue;
                    }
                    //1.从tfs上获取主图文件写入到本地
                    String pictureFile = skuPicObj.getPictureFile();
                    log.error("数据库中保存的tfs原图ID ： " + pictureFile);
                    //本地文件名
                    String localFileName = tempFilePath + pictureFile;
                    localFileName= FileUploadUtils.pathFormat(localFileName);
                    //水印图片文件
                    String logoPic = logoPath;
                    logoPic= FileUploadUtils.pathFormat(logoPic);
                    boolean flag = false;
                    try {
                      flag = defaultTfsManager.fetchFile(pictureFile, null, localFileName);
                    } catch (Exception e) {
                      log.error("从tfs服务器上查询主图异常!");
                      fromTfsCount ++;
                      continue;
                    }
                    if(!flag){
                      log.error("从tfs服务器上查询主图异常" + pictureFile);
                      fromTfsCount ++;
                      continue;
                    }
                    //转分辨率后的的图片路径
                    String convertScaleFile = null;
                    GoodsSkuPictureBeanDto bean = null;
                    if(flag){
                      //2.写入到本地成功后加水印
                      try {
                        new ImageTools(imageMagickPath).waterMark(logoPic, localFileName, "southeast", 50);
                      } catch (Exception e) {
                        log.error("给从tfs上下载到本地的主图加水印异常!");
                        markCount ++;
                        continue;
                      }
                      try {
                        successCount ++;
                        //3.根据加水印的主图生成不同分辨率的其它图片
                        this.invokeUpdatePic(pictureFile, convertScaleFile, localFileName, bean, picList);
                      } catch (Exception e) {
                        log.error("根据加水印的主图生成不同分辨率的其它图片异常!");
                        continue;
                      }
                    }
                  }
                }else{
                  continue;
                }
              }
            }
          }
//      }
      log.info("主图总数：" + count);
      log.info("实际处理主图总数：" + successCount);
      log.info("查询主图结果异常" + mainPicExceptionCount);
      log.info("查询主图结果为空" + mainPicEmptyCount);
      log.info("查询所有其它分辨率的图片集合结果为空 " + otherEmptyCount);
      log.info("从tfs服务器上查询主图异常 " + fromTfsCount);
      log.info("主图打水印异常数 " + markCount);
      log.info("其它分辨率的图片修复成功 " + success);
      log.info("其它分辨率的图片修复失败 " + fail);
      log.info("图片修复完成");
  }

}
