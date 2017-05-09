package com.zgxcw.service.infrastructure.goods.utils;

import java.io.File;
import java.io.IOException;

import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.GMOperation;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
/** 
 *  使用ImageMagick进行图片打水印和剪裁大小
 * @ClassName: ImageTools 
 * @Description: TODO
 * @author weiming
 * @date 2015年12月4日 下午4:04:31   
 */
public class ImageTools {

  /**
   * ImageMagick的路径
   */
  public static String imageMagickPath = null;
  static {
      imageMagickPath = "D:/Program Files (x86)/ImageMagick-6.3.9-Q8";
  }
  public ImageTools() {
  }
  
  public ImageTools(String imageMagickPath) {
    if(isWindows()){
      this.imageMagickPath = imageMagickPath;
    }
  }
  /**
   * 
   * 根据坐标裁剪图片
   * 
   * @param srcPath   要裁剪图片的路径
   * @param newPath   裁剪图片后的路径
   * @param x         起始横坐标
   * @param y         起始纵坐标
   * @param x1        结束横坐标
   * @param y1        结束纵坐标
   */

  public static void cutImage(String srcPath, String newPath, int x, int y, int x1, int y1) throws Exception {
    int width = x1 - x;
    int height = y1 - y;
    IMOperation op = new IMOperation();
    op.addImage(srcPath);
    /**
     * width：  裁剪的宽度
     * height： 裁剪的高度
     * x：       裁剪的横坐标
     * y：       裁剪的挫坐标
     */
    op.crop(width, height, x, y);
    op.addImage(newPath);
    ConvertCmd convert = new ConvertCmd();

    // linux下不要设置此值，不然会报错
    convert.setSearchPath(imageMagickPath);
    convert.run(op);
  }

  /**
   * 
   * 根据尺寸等比例缩放图片
   * @param width             缩放后的图片宽度
   * @param height            缩放后的图片高度
   * @param srcPath           源图片路径
   * @param newPath           缩放后图片的路径
   */
  public static void cutImage(int width, int height, String srcPath,  String newPath) throws Exception {
    IMOperation op = new IMOperation();
    op.addImage(srcPath);
    op.resize(width, height);
    op.addImage(newPath);
    ConvertCmd convert = new ConvertCmd(true);
    // linux下不要设置此值，不然会报错
    convert.setSearchPath(imageMagickPath);
    convert.run(op);
  }

  /**
   * 根据宽度等比例缩放图片
   * 
   * @param width            缩放后的图片宽度
   * @param srcPath          源图片路径
   * @param newPath          缩放后图片的路径
   */
  public static void cutImage(int width, String srcPath, String newPath)  throws Exception {
    IMOperation op = new IMOperation();
    op.addImage(srcPath);
    op.resize(width, null);
    op.addImage(newPath);
    ConvertCmd convert = new ConvertCmd();
    // linux下不要设置此值，不然会报错
    convert.setSearchPath(imageMagickPath);
    convert.run(op);
  }

  /**
   * 文字水印
   * @param srcPath            源图片路径
   */
  public static void addImgText(String srcPath) throws Exception {
    IMOperation op = new IMOperation();
    op.font("宋体").gravity("southeast").pointsize(18).fill("#BCBFC8")
        .draw("text 5,5 juziku.com");
    op.addImage();
    op.addImage();
    ConvertCmd convert = new ConvertCmd();
    // linux下不要设置此值，不然会报错
    convert.setSearchPath(imageMagickPath);
    convert.run(op, srcPath, srcPath);
  }
  
  /**
   * 图片水印
   *
   * @param srcImagePath   源图片
   * @param logoPath 水印
   * @param destImagePath  生成图片
   * @param gravity  图片位置
   * @param dissolve 水印透明度
   */
  public static void waterMark(String logoPath, String srcImagePath, String destImagePath, String gravity, int dissolve) {
    IMOperation op = new IMOperation();
    op.gravity(gravity);
    op.dissolve(dissolve);
    op.addImage(logoPath);
    op.addImage(srcImagePath);
    op.addImage(srcImagePath);
    CompositeCmd cmd = new CompositeCmd();
  try {
      cmd.run(op);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (IM4JavaException e) {
      e.printStackTrace();
    }
  }  
  
  /**
   * 打水印减少参数
   * @Description: 
   * @param logoPath   水印图片
   * @param imagePath  需要打水印的图片 
   * @param gravity    位置
   * @param dissolve   透明度 0-100
   * void
   * @throws IM4JavaException 
   * @throws InterruptedException 
   * @throws IOException 
   */
  public static void waterMark(String logoPath, String imagePath, String gravity, int dissolve) throws IOException, InterruptedException, IM4JavaException {
    IMOperation op = new IMOperation();
    op.gravity(gravity);
    op.dissolve(dissolve);
    op.addImage(logoPath);
    //原图片
    op.addImage(imagePath);
    //新图片与原图片一样，就是打完水印放在原位置
    op.addImage(imagePath);
    CompositeCmd cmd = new CompositeCmd();
    cmd.run(op);
  }  
  
  /** 
   * 自由缩放 
   * @param width  缩放后的图片宽度 
   * @param height  缩放后的图片高度 
   * @param srcPath   源图片路径 
   * @param newPath   缩放后图片的路径 
   */  
  public void zoomImage(Integer width, Integer height, String srcPath, String newPath) throws Exception {  
    GMOperation op = new GMOperation();
    //待处理图片的绝对路径
    op.addImage(srcPath);
  
    //图片压缩比，有效值范围是0.0-100.0，数值越大，缩略图越清晰
    op.quality(100.0);
    /**
     * width 和height可以是原图的尺寸，也可以是按比例处理后的尺寸
     * 
     * 加上！是不按比例缩放
     */
    op.addRawArgs("-resize", width.intValue() + "x" + height.intValue() + "!");
  
    op.addRawArgs("-gravity", "center");
    //处理后图片的绝对路径
    op.addImage(newPath);
  
    // 如果使用ImageMagick，设为false,使用GraphicsMagick，就设为true，默认为false
    ConvertCmd convert = new ConvertCmd();
    
    if(isWindows()){
      // linux下不要设置此值，不然会报错
      convert.setSearchPath(imageMagickPath);
    }  
    convert.run(op);
  } 
  
  /**
   * 判断是否是WINDOWS系统
   * @return    
   * boolean
   */
  public static boolean isWindows(){
    if("\\".equals(File.separator)){
      return true;
    }else{
      return false;
    }
  }
  public static void main(String[] args) throws Exception {
    String src = "D:/img/2.jpg";
    String target = "D:/img/imagemagick/2-56.jpg";
    String logo = "O:/logo.png";
    
//    waterMark("O:/logo.png", src, "northwest", 90);  
    new ImageTools().zoomImage(56, 56, src, target);
//    waterMarkNew(logo, target, "north", 50);  
    
    System.out.println("end");
//    System.out.println(isWindows());
  }
  
  
}
