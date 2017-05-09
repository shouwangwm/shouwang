package com.zgxcw.service.infrastructure.store.dao.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zgxcw.service.infrastructure.goods.bean.Store;
import com.zgxcw.service.infrastructure.goods.dao.StoreMapper;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/notenv/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreMapperTest {

  @Autowired
  private StoreMapper storeMapper;
  private static Store bean;

  @BeforeClass
  public static void init() {
    bean = new Store();
    bean.setStoreID(new RandomGUID().toString());
    bean.setApprovalStatus(1);
    bean.setBrandID("1");
    bean.setCoorprationID("1");
    bean.setCreateTime(System.currentTimeMillis());
    bean.setCreateUser("李钦亮");
    bean.setOperationTimeBegin(System.currentTimeMillis());
    bean.setOperationTimeEnd(System.currentTimeMillis());
    bean.setRegion("1");
    bean.setServicePromise("eee");
    bean.setServiceTele("12345678911");
    // bean.setSignID("11");//此项外键 数据库必须有数据 或则此项不填可为空
    bean.setStationNum(100);
    bean.setStoreAddr("beijing");
    bean.setStoreDomainName("ronghua.zgxcw.com");
    bean.setStoreAdvertisePic("http:123.com");
    bean.setStoreDesc("rrrr");
    bean.setStoreName("天猫");
    bean.setStoreStatus(1);
    bean.setStoreType("1");
    bean.setBrandQualification("http://img.zgxcw.com/quali/1234.png");
    bean.setInspectionReport("1.jpg");
    bean.setPatentCert("2.jpg");
    bean.setAwardCert("3.jpg");
    bean.setStoreKeywords("天猫");
    bean.setSignStatus(0);
    bean.setServiceStationID("123123123");
    bean.setStoreScore(1300);
    bean.setUpdateTime(System.currentTimeMillis());
    bean.setUpdateUser("liqinliang");
  }

  @Test
  public void test001Insert() {
    Assert.assertTrue(storeMapper.insert(bean) > 0);
  }

  @Test
  public void test002SelectByPrimaryKey() {
    String pkid = returnPK();
    Store entity = storeMapper.selectByPrimaryKey(pkid);
    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getStoreID());
  }

  @Test
  public void test003SelectAll() {
    Assert.assertNotNull(storeMapper.selectAll());
  }

  @Test
  public void test004SelectForList() {
    Assert.assertNotNull(storeMapper.selectForList(bean));
  }

  @Test
  public void test005Update() {
    String pkid = returnPK();
    bean.setStoreID(pkid);
    bean.setCreateUser("lql");
    Assert.assertEquals(1, storeMapper.update(bean));
  }

  @Test
  public void test006DeleteByPrimaryKey() {
    String pkid = returnPK();
    //Assert.assertEquals(1, storeMapper.deleteByPrimaryKey(pkid));
  }

  private String returnPK() {
    bean.setStoreID(new RandomGUID().toString());
    storeMapper.insert(bean);
    return bean.getStoreID();
  }
}
