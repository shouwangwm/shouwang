package com.zgxcw.service.infrastructure.goods.constant;

/**
 * @project_name: category-service-api
 * @description: 本领域业务参数定义－以下是一个样例
 * @author: LinYu
 * @create_date: 2015年9月16日
 * @modify_date: 2015年9月16日
 */

public class ParamConstant {

  /** 快照版本号初始值 */
  public static final Long FIN_DEFAULT_SNAPSHOTNO = Long.valueOf(1);

  /**
   * 商品类型
   */
  public static class GoodsType {
    /** 正品 */
    public static final String QUALITY_GOODS = "001";
    /** 汽配商城商品 */
    public static final String MALL_GOODS = "002";
  }

  /**
   * 业务属性类别
   */
  public static class BusinessAttrType {
    public static final String BUSINESSATTR_TYPE = "业务属性类型";
    /** 明星商品 */
    public static final String STAR = "001";
    /** 推荐商品 */
    public static final String RECOMMEND = "002";
    /** 全品牌通用 */
    public static final String GENERAL = "003";
  }

  /**
   * 商品审批业务属性类别
   */
  public static class ApprovalBusinessAttrType {
    public static final String APPROVAL_BUSINESSATTR_TYPE = "商品审批业务属性类别";
    /** 正品商品 */
    public static final String QUALITY_GOODS = "001";
    /** 商城商品 */
    public static final String MALL_GOODS = "002";
    /** 明星商品 */
    public static final String STAR = "003";
  }

  /*
  定义计量单位常量
   */
  public static class UnitCode{
    public static final String UNIT_CODE = "计量单位";
    public static final String ITEM = "001"; // 个
    public static final String KILO = "002"; // 公斤
    public static final String LITER = "003"; // 升
    public static final String TON = "004"; // 升
  }

  /*
  定义价格类型常量
   */
  public static class PriceType{
    public static final String PRICE_TYPE = "价格类型";
    public static final String RETAILER = "001"; // 经销商售价
    public static final String REPAIR_SHOP = "002"; // 修理厂价格
  }


  /**
   * 图片分辨率常量
   */
  public static class PictureResolution{
    public static final String PICTURE_RESOLUTION = "图片分辨率";
    public static final String _800_800_MAIN = "001"; // 主图
    public static final String _800_800_OR_400_400 = "002"; // 主图带水印，显示时用带水印的主图
    public static final String _56_56 = "003";   // 正品-详情-缩略图
    public static final String _350_350 = "004"; // 正品-详情-主图
    public static final String _130_130 = "005"; // 正品首页-热销商品、猜你喜欢
    public static final String _166_181 = "006"; // 商城首页-热销商品
    public static final String _88_123 = "007";  // 商城首页-明星商品
    public static final String _140_140 = "008"; // 商城-列表
    public static final String _156_156 = "009"; // 同品类、同品牌商品
    public static final String _200_200 = "010"; // 正品-所有正品列表，搜索列表、店铺首页列表
    public static final String _210_144 = "011"; // 品牌馆-搜索结果
    public static final String _400_400 = "012"; // 主图
    public static final String _80_80 = "013"; // 订单与支付


    /** 001(主图)：800*800 */
    public static final int x800 = 800;
    /** 003(正品-详情-缩略图)：56*56 */
    public static final int x56 = 56;
    /** 004(正品-详情-主图)：350*350 */
    public static final int x350 = 350;
    /** 005(正品首页-热销商品)：130*130 */
    public static final int x130 = 130;
    /** 006(商城首页-热销商品)：166*181 */
    public static final int x166 = 166;
    public static final int x166_H = 181;
    /** 007(商城首页-明星商品)：88*123 */
    public static final int x88 = 88;
    public static final int x88_H = 123;
    /** 008(商城-列表)：140*140 */
    public static final int x140 = 140;
    /** 009(同品类、同品牌商品)：156*156 */
    public static final int x156 = 156;
    /** 010(正品-所有正品列表，搜索列表、店铺首页列表) */
    public static final int x200 = 200;
    /** 011(品牌馆-搜索结果) */
    public static final int x210 = 210;
    public static final int x210_H = 144;
    /** 012(主图)：400*400 */
    public static final int x400 = 400;
    /**013(订单与支付): 80*80*/
    public static final int x80 = 80;
  }


  /**
   * 是否为主图常量参数
   */
  public static class MainPicture{
    public static String MAIN_PICTURE = "是否为主图";
    public static Integer IS_MAIN_PICTURE = 0;
    public static Integer NOT_MAIN_PICTURE = 1;
  }

  /**
   * 库存类型代码
   */
  public static class InventoryTypeCode{
    public static final String RETAILER = "002"; // 经销商库存
    public static final String MANUFACTURER = "001"; // 厂家库存
  }
  
  public static class CarType{
	  public static final String SMALL = "ORDINARY";
	  public static final String BIG = "INDUSTRIAL";
  }
  
  /**
   * 删除状态 0 正常 1 删除 2 永久删除
   * 
   * @author zhaoyongping
   * 
   */
  public enum DeletionStatus {
    NORMAL(0), DELETED(1), DELETED_FOREVER(2);
    private DeletionStatus(int code) {
      this.code = code;
    }

    private int code;

    public int getCode() {
      return code;
    }

  }
  
  public static final String createUser = "Merge";
}
