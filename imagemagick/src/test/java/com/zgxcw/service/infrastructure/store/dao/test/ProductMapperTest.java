package com.zgxcw.service.infrastructure.store.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zgxcw.service.infrastructure.goods.bean.Product;
import com.zgxcw.service.infrastructure.goods.dao.ProductMapper;

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
public class ProductMapperTest {

  private static final Logger logger = LoggerFactory.getLogger(ProductMapperTest.class);

  @Autowired
  private ProductMapper productMapper;

  @Test
  public void test001selectForList() {
	Map map = new HashMap();
	map.put("min", 0);
	map.put("max", 100);
	List<Product> list = productMapper.selectForList(map);
	System.out.println(list.size());
  }
}
