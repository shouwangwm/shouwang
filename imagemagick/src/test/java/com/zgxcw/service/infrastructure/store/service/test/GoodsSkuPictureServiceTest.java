package com.zgxcw.service.infrastructure.store.service.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zgxcw.service.infrastructure.goods.constant.ParamConstant;
import com.zgxcw.service.infrastructure.goods.dto.request.create.GoodsSkuPictureCreateDto;
import com.zgxcw.service.infrastructure.goods.dto.request.modify.GoodsSkuPictureModifyDto;
import com.zgxcw.service.infrastructure.goods.dto.request.query.GoodsSkuPictureQueryDto;
import com.zgxcw.service.infrastructure.goods.dto.response.GoodsSkuPictureBeanDto;
import com.zgxcw.service.infrastructure.goods.service.GoodsSkuPictureService;
import com.zgxcw.service.infrastructure.goods.utils.PageInfoBaseDto;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;
import com.zgxcw.service.infrastructure.goods.utils.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/notenv/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsSkuPictureServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(GoodsSkuPictureServiceTest.class);
  @Autowired
  private GoodsSkuPictureService goodsSkuPictureService;

  private String createBean() {
    GoodsSkuPictureCreateDto dto = new GoodsSkuPictureCreateDto();
    dto.setSkuPicID(new RandomGUID().toString());
    dto.setGoodsSkuID("B91A0AEE5F523B741C8EADEE62176255");
    dto.setPhotoDesc("i am pic");
    dto.setPictureType(1);
    dto.setPictureFile("http://www.asdfasdf.jpg");
    dto.setDeletionStatus(0);
    dto.setCreateUser("李善福");
    dto.setSnapshotNO(1L);
    dto.setGoodsID(new RandomGUID().toString());
    return goodsSkuPictureService.create(dto);
  }

  @Test
  public void test001Create() {
    GoodsSkuPictureCreateDto dto = new GoodsSkuPictureCreateDto();
    dto.setSkuPicID(new RandomGUID().toString());
    dto.setGoodsSkuID("B91A0AEE5F523B741C8EADEE62176255");
    dto.setGoodsID(new RandomGUID().toString());
    dto.setPhotoDesc("i am pic");
    dto.setPictureType(1);
    dto.setPictureFile("http://www.asdfasdf.jpg");
    dto.setDeletionStatus(0);
    dto.setCreateUser("lsf");
    dto.setSnapshotNO(2L);
    System.out.println("test001Create");
    String pk = goodsSkuPictureService.create(dto);
    Assert.assertTrue(!"".equals(pk));
    goodsSkuPictureService.remove(pk);
  }


  @Test
  public void test002Get() {
    String pk = createBean();
    Assert.assertNotNull(goodsSkuPictureService.get(pk));
    goodsSkuPictureService.remove(pk);
  }

  @Test
  public void test003Modify() {
    String pk = createBean();
    GoodsSkuPictureBeanDto beanDto = goodsSkuPictureService.get(pk);
    GoodsSkuPictureModifyDto modifyDto = new GoodsSkuPictureModifyDto();
    BeanUtils.copyProperties(beanDto, modifyDto);
    Assert.assertTrue(goodsSkuPictureService.modify(modifyDto) > 0);
    goodsSkuPictureService.remove(pk);
  }

  @Test
  public void test004QueryAll() {
    createBean();
    List<GoodsSkuPictureBeanDto> dtoList = goodsSkuPictureService.queryAll();
    Assert.assertTrue(dtoList != null && dtoList.size() > 0);
  }

  @Test
  public void test005QueryForList() {
    createBean();
    GoodsSkuPictureQueryDto queryDto = new GoodsSkuPictureQueryDto();
//    queryDto.setGoodsID("g1002");
    queryDto.setGoodsSkuID("19E812840421BE5383F4AF92174EB16B");
    queryDto.setSnapshotNO(1L);
    queryDto.setResolutionCode(ParamConstant.PictureResolution._800_800_MAIN);
    List<GoodsSkuPictureBeanDto> dtoList = goodsSkuPictureService.queryForList(queryDto);
    for(GoodsSkuPictureBeanDto dto : dtoList){
      System.out.println(" getPictureFile >>> " + dto.getPictureFile());
    }
    Assert.assertTrue(dtoList != null && dtoList.size() > 0);
  }

  @Test
  public void test007Remove() {
    Assert.assertTrue(goodsSkuPictureService.remove(createBean()) > 0);
  }

  @Test
  public void test006QueryForPage() {
    createBean();
    GoodsSkuPictureQueryDto queryDto = new GoodsSkuPictureQueryDto();
    queryDto.setPictureType(1);
    PageInfoBaseDto<GoodsSkuPictureBeanDto> pageInfoBeanDto = null;
    try {
      pageInfoBeanDto = this.goodsSkuPictureService.queryForPage(1, 3, queryDto);
    } catch (ServiceException ex) {
      assertTrue(ex.getMessage().indexOf("获取商品SKU图片列表失败！") >= 0);
    }
    assertTrue(pageInfoBeanDto.getPageNum() == 1 && pageInfoBeanDto.getPageSize() == 3
        && pageInfoBeanDto.getList() != null && pageInfoBeanDto.getList().size() > 0);
  }
}
