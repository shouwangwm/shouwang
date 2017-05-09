package com.zgxcw.service.infrastructure.goods.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 日志处理类
 * @ClassName: LogConsole 
 * @author weiming
 * @date 2015年10月10日 下午2:55:22
 */
public class LogConsole
{
  private static Logger logger = LoggerFactory.getLogger(LogConsole.class);

  public static void debug(String message)
  {
    logger.debug(message);
  }

  public static void debug(String message, Object obj) {
    logger.debug(message, obj);
  }

  public static void debug(Class<?> clz, String message) {
    LoggerFactory.getLogger(clz).debug(message);
  }

  public static void debug(Class<?> clz, String message, Object obj) {
    LoggerFactory.getLogger(clz).debug(message, obj);
  }

  public static void warn(String message) {
    logger.warn(message);
  }

  public static void warn(String message, Object obj) {
    logger.warn(message, obj);
  }

  public static void warn(Class<?> clz, String message) {
    LoggerFactory.getLogger(clz).warn(message);
  }

  public static void warn(Class<?> clz, String message, Object obj) {
    LoggerFactory.getLogger(clz).warn(message, obj);
  }

  public static void info(String message) {
    logger.info(message);
  }

  public static void info(String message, Object obj) {
    logger.info(message, obj);
  }

  public static void info(Class<?> clz, String message) {
    LoggerFactory.getLogger(clz).info(message);
  }

  public static void info(Class<?> clz, String message, Object obj) {
    LoggerFactory.getLogger(clz).info(message, obj);
  }

  public static void error(String message) {
    logger.error(message);
  }

  public static void error(String message, Object obj) {
    logger.error(message, obj);
  }

  public static void error(Class<?> clz, String message) {
    LoggerFactory.getLogger(clz).error(message);
  }

  public static void error(Class<?> clz, String message, Object obj) {
    LoggerFactory.getLogger(clz).error(message, obj);
  }
}
