package com.zgxcw.framework.interceptor;

import java.util.List;
import java.util.Random;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.zgxcw.framework.interceptor.dynamicdatasource.DBContextHolder;

/**
 * 
 * @Title: DynamicTransactionInterceptor
 * @Description: 动态事务拦截器，拦截方法后，加入数据源切换的功能
 * @Author: liyashuang
 * @DateTime: 2015年10月24日 下午9:28:28
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
public class DynamicTransactionInterceptor extends TransactionInterceptor {

  private List<String> writeMthods;
  
  /**只读数据源列表,需要注入，当为多个数据源时，应使用算法计算数据源，放入DBContextHolder.setJdbcType方法中*/
//  private List<String> readOnlyDS;
  /**只写数据源列表，需要注入，当为多个数据源时，应使用算法计算数据源，放入DBContextHolder.setJdbcType方法中*/
//  private List<String> writeOnlyDS;
  /**多个读数据源模式开关*/
//  private boolean mutiReadMode;
  /**多个写数据源模式开关*/
//  private boolean mutiWriteMode;
  
  public DynamicTransactionInterceptor(){
    
  }
  
  public DynamicTransactionInterceptor(List<String> writeMthods){
    this.writeMthods = writeMthods;
  }
  
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    /**后期需要扩展DBContextHolder.setJdbcType()中传递的数据源的值为列*/
    //设置数据源
    if(isWriteMethod(invocation.getMethod().getName())){
      DBContextHolder.setJdbcType("writeDataSource");
    }else{
      //设置只读数据源
      DBContextHolder.setJdbcType("readDataSource");
    }
    return super.invoke(invocation);
  }
  
  /**
   * 
   * @Description:根据方法名判断是否为写数据库操作
   * @param methodName
   * @return 是否为写数据库方法
   * @author: liyashuang
   * @time:2015年10月24日 上午11:05:38
   */
  private boolean isWriteMethod(String methodName){
    if("".equals(methodName)){
    return false;
    }
    for(String method:writeMthods){
      if(methodName.startsWith(method)){
        return true;
      }
    }
  return false;
  }
  
  /**
   * 
   * @Description:取只读数据源
   * @param dataSource
   * @return
   * @author: liyashuang
   * @time:2015年10月25日 上午3:38:49
   */
//  private String getReadOnlyDataSourceName(List<String> dataSource){
//    return (mutiReadMode==true)?getRandomName(dataSource):dataSource.get(0);
//  }
  
  /**
   * 
   * @Description:多数据源模式下取得一个只读数据源
   * @param dataSource
   * @return
   * @author: liyashuang
   * @time:2015年10月25日 上午3:43:44
   */
//  private String getRandomName(List<String> dataSource){
//    return dataSource.get(new Random().nextInt(dataSource.size()));
//  }
  
  /** 
   * @Description: 获取writeMthods
   * @return writeMthods
   */
  public List<String> getwriteMthods() {
    return writeMthods;
  }

  /** 
   * 设置writeMthods
   * @param writeMthods 
   */
  public void setwriteMthods(List<String> writeMthods) {
    this.writeMthods = writeMthods;
  }

  /** 
   * @Description: 获取mutiReadMode
   * @return mutiReadMode
   */
//  public boolean isMutiReadMode() {
//    return mutiReadMode;
//  }

  /** 
   * 设置mutiReadMode
   * @param mutiReadMode 
   */
//  public void setMutiReadMode(boolean mutiReadMode) {
//    this.mutiReadMode = mutiReadMode;
//  }
  
  
}
