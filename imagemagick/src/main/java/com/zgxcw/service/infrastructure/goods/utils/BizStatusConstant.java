package com.zgxcw.service.infrastructure.goods.utils;

/**
 * @project_name: category-service-api
 * @description: 本领域业务状态定义－以下是一个样例
 * @author: LinYu
 * @create_date: 2015年9月16日
 * @modify_date: 2015年9月16日
 */

public class BizStatusConstant {
  /**
   * 仓单贷款合同状态
   */
  public static class WHBillContraStatus {
    public static final String CONTRACT_STATUS = "合同状态";
    public static final long DRAFT = 0;// 草稿
    public static final long SUBMITED = 1;// 已提交
    public static final long BANK_APPROVED = 2;// 已批准
    public static final long EFFECT = 3;// 已生效
    public static final long REDEEMED = 4;// 已赎单
    public static final long FELLBACK = 5;// 已违约
    public static final long CLOSED = 6;// 已关闭
    public static final long TERMITED = 7;// 已终止
    public static final long WAIT_BANK_APPROVE = 8;// 待银行审批
    public static final long SUBMITTING = 9;// 提交中
    public static final long APPROVE_PASS = 10;// 审核通过
    public static final long APPROVE_REJECT = 11;// 审核不通过
    public static final long WAIT_CHECK = 12;// 待复核
    public static final long CHECK_PASS = 13;// 复核通过
    public static final long CHECK_NOT_PASS = 14;// 复核不通过
  }

  /**
   * 正品服务状态
   */
  public static class GenuineServiceStatus {
    public static final int OPEN = 0;// 开通
    public static final int CLOSED = 1;// 关闭
  }

  /**
   * 类目类型
   */
  public static class CategoreRelStatus {
    /** 平台类目 */
    public static final int TYPE_PLATF = 1;
    /** 店铺类目 */
    public static final int TYPE_STORE = 2;
  }

  /**
   * 库存状态
   */
  public static class StockStatus {
    public static final String STOCK_STATUS = "库存状态";
    public static final int IN_STOCK = 0; // 正常
    public static final int OUT_OF_STOCK = 1; // 缺货
  }

  /**
   * 销售状态
   */
  public static class SaleStatus {
    public static final String SALE_STATUS = "销售状态";
    public static final Integer IN_SALE = 0; // 在售
    public static final Integer TAKEN_DOWN = 1; // 下架
    public static final Integer TAKEN_DOWN_BY_SUPERVISER = 2; // 管理员下架
    public static final Integer PREPARING = 3; // 准备上架（草稿）
  }

  /**
   * 审核状态
   */
  public static class ApprovalStatus {
    public static final String APPROVAL_STATUS = "审核状态";
    public static final int ACCEPT = 0;// 通过
    public static final int REJECT = 1;// 不通过
    public static final int PENDING = 2; // 待审核
    public static final int PREPARE_TO_SUBMIT = 3; // 待提交
  }

  public static class SubmitStatus {
    public static final String SUBMIT_STATUS = "提交状态";
    /** 未提交 */
    public static final int UNSUBMIT = 0;
    /** 已提交 */
    public static final int SUBMITTED = 1;
  }

  /** 是否是单品 */
  public static class SingleProduct {
    /** 是 */
    public static final int YES = 0;
    /** 不是 */
    public static final int NO = 1;
  }

  /** 库存类型代码 */
  public static class InventoryTypeCode {
    /** 厂商 */
    public static final String TYPE_FFACTORY = "001";
    /** 经销商 */
    public static final String TYPE_DISTRIBUTOR = "002";
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
  /**
   * 图片类型
   * @ClassName: PictureType 
   * @author weiming
   * @date 2015年10月23日 下午3:50:39
   */
  public static class PictureType {
    /** 商品图片 */
    public static final int SHOP_TYPE = 1;
    /** 质检图片*/
    public static final int QUALITY_TYPE = 2;
  }
}
