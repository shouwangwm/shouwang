package com.zgxcw.service.infrastructure.goods.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
/**
 * 图片打水印工具类
 * @ClassName: ImageMarkUtils 
 * @author weiming
 * @date 2015年10月3日 下午6:15:03
 */
public final class ImageMarkUtils {
  
  private static Logger log = Logger.getLogger(ImageMarkUtils.class);
  public ImageMarkUtils() {}
  /**
   * 把图片印刷到图片上
   * 
   * @param logoString -- 水印文件
   * @param targetString -- 目标文件
   * @param x --x坐标
   * @param y --y坐标
   */
  public final static void imageMark(String logoString, String targetString, int x, int y) {
    try {
      
      // 目标文件
      File targetFile = new File(targetString);
      int width;
      int height;
      BufferedImage image;
      
      /** 判断是RGB色彩模式的图片*/
      if(CMYKToRGB.isRgbOrCmyk(targetString)){
        Image target = ImageIO.read(targetFile);
        width = target.getWidth(null);
        height = target.getHeight(null);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      /** 其它色彩模式的图片，CMYK */ 
      }else{
        image = CMYKToRGB.readImage(targetFile);
        width = image.getWidth(null);
        height = image.getHeight(null);
      }  
      Graphics2D g = image.createGraphics();     
      g.drawImage(image, 0, 0, width, height, null);

      // 水印文件
      File logo = new File(logoString);
      Image logoImage = ImageIO.read(logo);
      int logoWidth = logoImage.getWidth(null);
      int logoHeight = logoImage.getHeight(null);
      float alpha = 0.9f; // 透明度    
      g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));  
      //缩小10倍
      g.drawImage(logoImage, width/2 , height/6*5, logoWidth, logoHeight, null);
      // 水印文件结束
      g.dispose();
      
      FileOutputStream out = new FileOutputStream(targetString);
      out.flush();
      // 生成图片     
      ImageIO.write(image, "JPG", out); 
      log.info("水印生成完成");
    } catch (Exception e) {
      log.error("水印生成出错" + e.getMessage());
      e.printStackTrace();
    }
  }
 
  /** */
  /**
   * 打印文字水印图片
   * 
   * @param pressText --文字
   * @param targetImg -- 目标图片
   * @param fontName -- 字体名
   * @param fontStyle -- 字体样式
   * @param color -- 字体颜色
   * @param fontSize -- 字体大小
   * @param x -- 偏移量
   * @param y
   */
  public static void imageMark(String pressText, String targetImg, String fontName, int fontStyle,
      int color, int fontSize, int x, int y) {
    try {
      File _file = new File(targetImg);
      Image src = ImageIO.read(_file);
      int wideth = src.getWidth(null);
      int height = src.getHeight(null);
      BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
      Graphics g = image.createGraphics();
      g.drawImage(src, 0, 0, wideth, height, null);
      g.setColor(Color.RED);
      g.setFont(new Font(fontName, fontStyle, fontSize));
      g.drawString(pressText, wideth - fontSize - x, height - fontSize / 2 - y);
      g.dispose();
      FileOutputStream out = new FileOutputStream(targetImg);
      out.flush();
      // 生成图片     
      ImageIO.write(image, "JPG", out); 
    } catch (Exception e) {
      log.debug(e);
    }
  }

  public static void main(String[] args) {
    imageMark("O:/logo.png", "O:/4.jpg", 2, 6);
  }
}

