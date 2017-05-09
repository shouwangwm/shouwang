package com.zgxcw.framework.interceptor.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    // TODO Auto-generated method stub
    return DBContextHolder.getJdbcType();
  }
}
