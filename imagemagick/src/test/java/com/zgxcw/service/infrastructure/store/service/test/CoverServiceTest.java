package com.zgxcw.service.infrastructure.store.service.test;

import java.util.HashMap;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zgxcw.service.infrastructure.goods.bean.Cover;
import com.zgxcw.service.infrastructure.goods.service.CoverService;

/**
 * @Title: StoreWorkOrderMapperTest.java
 * @Description: 工单测试
 * @Author: lisd
 * @DateTime: 2015年9月10日 下午4:23:44
 * @Version: 1.0.0
 * @Copyright: Copyright 2007-2015 www.zgxcw.com.cn All Rights Reserved
 * @Company: 诸葛修车网
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/notenv/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CoverServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(CoverServiceTest.class);

  @Autowired
  private CoverService coverService;
  
  @Test
  public void test001selectForList() {
    List<Cover> list = coverService.selectForList(new HashMap());
    for(Cover cover : list){
      System.out.println(" >>> " + cover.getImage());
    }
  }
}
