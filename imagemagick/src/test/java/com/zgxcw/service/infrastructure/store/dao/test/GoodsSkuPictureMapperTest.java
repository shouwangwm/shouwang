package com.zgxcw.service.infrastructure.store.dao.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zgxcw.service.infrastructure.goods.bean.GoodsSkuPicture;
import com.zgxcw.service.infrastructure.goods.dao.GoodsSkuPictureMapper;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/notenv/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsSkuPictureMapperTest {

  private static final Logger logger = LoggerFactory.getLogger(GoodsSkuPictureMapperTest.class);

  @Autowired
  private GoodsSkuPictureMapper goodsSkuPictureMapper;

  private static GoodsSkuPicture bean;

  @BeforeClass
  public static void init() {
    bean = new GoodsSkuPicture();
    bean.setSkuPicID(new RandomGUID().toString());
    bean.setGoodsSkuID("B91A0AEE5F523B741C8EADEE62176255");
    bean.setResolutionCode("11");
    bean.setPhotoDesc("i am pic");
    bean.setPictureType(1);
    bean.setPictureFile("http://www.asdfasdf.jpg");
    bean.setDeletionStatus(0);
    bean.setCreateTime(System.currentTimeMillis());
    bean.setCreateUser("李善福");
    bean.setUpdateTime(System.currentTimeMillis());
    bean.setUpdateUser("叶可人");
    bean.setSnapshotNO(1L);
    bean.setGoodsID(new RandomGUID().toString());
  }
  
  public static GoodsSkuPicture create() {
    bean = new GoodsSkuPicture();
    bean.setSkuPicID(new RandomGUID().toString());
    bean.setPhotoDesc(new RandomGUID().toString() + "的描述");
    bean.setGoodsSkuID("s1");
    bean.setGoodsID("g1");
    bean.setSnapshotNO(1L);
    bean.setResolutionCode("11");
    bean.setPictureType(1);
    bean.setPictureFile("http://www.asdfasdf.jpg");
    bean.setDeletionStatus(0);
    bean.setCreateTime(System.currentTimeMillis());
    bean.setCreateUser(new RandomGUID().toString() + "的上传者");
    bean.setUpdateTime(System.currentTimeMillis());
    bean.setUpdateUser("叶可人");
    bean.setIsMainPic(1L);
    return bean;
  }
  
  @Test
  public void test001Insert() {
    System.out.println("test001Insert >>> skuPicID : " + bean.getSkuPicID());
    Assert.assertTrue(goodsSkuPictureMapper.insert(bean) > 0);
  }

  @Test
  public void test002SelectByPrimaryKey() {
    GoodsSkuPicture entity = goodsSkuPictureMapper.selectByPrimaryKey("65959AAE59AF25C5F46B7140E3E12387");
    Assert.assertNotNull(entity);
    Assert.assertNotNull(entity.getSkuPicID());
  }

  @Test
  public void test003SelectAll() {
    Assert.assertNotNull(goodsSkuPictureMapper.selectAll());
  }

  @Test
  public void test004SelectForList() {
    Assert.assertNotNull(goodsSkuPictureMapper.selectForList(bean));
  }


  @Test
  public void test005Update() {
    bean.setCreateUser("wangcs");
    Assert.assertEquals(1, goodsSkuPictureMapper.update(bean));
  }

  @Test
  public void test006DeleteByPrimaryKey() {
    Assert.assertEquals(1, goodsSkuPictureMapper.deleteByPrimaryKey(bean.getSkuPicID()));
  }
  
  @Test
  public void test007InsertForBatch() {
    List<GoodsSkuPicture> beanList = new ArrayList<GoodsSkuPicture>(); 
    GoodsSkuPicture bean;
    for(int i=0;i<5;i++){
      bean = new GoodsSkuPicture();
      bean.setSkuPicID(new RandomGUID().toString());
      bean.setPhotoDesc(new RandomGUID().toString() + "的描述");
      bean.setGoodsSkuID("s1");
      bean.setGoodsID("g1");
      bean.setSnapshotNO(1L);
      bean.setResolutionCode("11");
      bean.setPictureType(1);
      bean.setPictureFile("http://www.asdfasdf.jpg");
      bean.setDeletionStatus(0);
      bean.setCreateTime(System.currentTimeMillis());
      bean.setCreateUser(new RandomGUID().toString() + "的上传者");
      bean.setUpdateTime(System.currentTimeMillis());
      bean.setUpdateUser("叶可人");
      bean.setIsMainPic(1L);
      beanList.add(bean);
    }
    goodsSkuPictureMapper.insertForBatch(beanList);
  }
}
