package com.test.exception;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.rpc.RpcContext;

public class ServiceException extends RuntimeException {
  public ServiceException(String message) {
    this(message, "");
  }

  public ServiceException(String message,String exceptionCode){
    super(message);
    this.exceptionCode=exceptionCode;
  }
  private String exceptionCode;
  /**
   * 异常代码
   * @return 异常代码
   */
  public String getExceptionCode() {
    return exceptionCode;
  }

  /**
   * 异常代码
   * @param exceptionCode 异常代码
   */
  public void setExceptionCode(String exceptionCode) {
    this.exceptionCode = exceptionCode;
  }



  /**
   * 重写fillInStackTrace，不在返回堆栈异常
   *
   * @return Throwable
   */
  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }

  /**
   * 重写message，返回ip和错误信息
   *
   * @return ip和错误信息
   */
  @Override
  public String getMessage() {
    String ip = "";
    String ipName = "local";
    if (isConsumerSide()) {
      ipName = "Provider";
      ip = getProviderHost();
    } else if (isProviderSide()) {
      ipName = "Consumer";
      ip = getConsumerHost();
    } else {
      ip = NetUtils.getLocalAddress().getHostAddress();
    }
    return String.format("{%s:\"%s\",Message:\"%s\",ExceptionCode:\"%s\"}",
        ipName, ip, super.getMessage(),exceptionCode);
  }

  /**
   * 重写tostring，返回ip和错误信息
   *
   * @return ip和错误信息
   */
  @Override
  public String toString() {
    return getMessage();
  }

  /**
   * 是否为消费端
   */
  private boolean isConsumerSide() {
    RpcContext rpcContext = RpcContext.getContext();
    if (rpcContext != null) {
      boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
      return isConsumerSide;
    }
    return false;
  }

  //获取最后一次调用的提供方IP地址
  private String getProviderHost() {
    boolean isConsumerSide = isConsumerSide();
    if (isConsumerSide) {
      String serverIP = RpcContext.getContext().getRemoteHost();
      return serverIP;
    } else {
      return NetUtils.getLocalAddress().getHostAddress();
    }
  }

  /**
   * 判断是否为提供端
   */
  private boolean isProviderSide() {
    RpcContext rpcContext = RpcContext.getContext();
    if (rpcContext == null) {
      return false;
    }
    boolean isProviderSide = RpcContext.getContext().isProviderSide();
    return isProviderSide;
  }

  /**
   * 获取调用方IP
   */
  private String getConsumerHost() {
    if (isProviderSide()) {
      String clientIP = RpcContext.getContext().getRemoteHost();
      return clientIP;
    }
    return NetUtils.getLocalAddress().getHostAddress();
  }


}
