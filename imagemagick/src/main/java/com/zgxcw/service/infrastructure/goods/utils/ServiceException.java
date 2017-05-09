package com.zgxcw.service.infrastructure.goods.utils;

import com.alibaba.dubbo.common.utils.NetUtils;

/**
 *  服务抛出业务异常 Created by suntao on 15/8/17.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    /**
     * 重写fillInStackTrace，不在返回堆栈异常
     * @return Throwable
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    /**
     * 重写message，返回ip和错误信息
     * @return ip和错误信息
     */
    @Override
    public String getMessage() {
        return String.format("{ServiceIp:\"%s\",Message:\"%s\"}", NetUtils.getLocalAddress().getHostAddress(), super.getMessage());
    }

    /**
     * 重写tostring，返回ip和错误信息
     * @return ip和错误信息
     */
    @Override
    public String toString() {
        return getMessage();
    }
}
