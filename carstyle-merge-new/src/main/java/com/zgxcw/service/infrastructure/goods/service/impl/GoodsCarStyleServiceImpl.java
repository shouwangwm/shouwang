package com.zgxcw.service.infrastructure.goods.service.impl;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.GoodsCarStyle;
import com.zgxcw.service.infrastructure.goods.dao.GoodsCarStyleMapper;
import com.zgxcw.service.infrastructure.goods.service.GoodsCarStyleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: GoodsCarStyleServiceImpl.java
 * @Description: 商品支持的车型服务实现
 */
@Service
public class GoodsCarStyleServiceImpl implements GoodsCarStyleService {
    private Logger logger = LoggerFactory.getLogger(GoodsCarStyleServiceImpl.class);

    @Resource
    private GoodsCarStyleMapper goodsCarStyleMapper;

    /**
     * 指定条件查询商品支持车型列表
     *
     * @return List<GoodsCarStyleBeanDto>:商品支持车型列表
     */
    @Override
    public List<CarModel> queryForList(String skuId, long snapshotNo) {
        GoodsCarStyle goodsCarStyle = new GoodsCarStyle();
        goodsCarStyle.setGoodsSkuID(skuId);
        goodsCarStyle.setSnapshotNO(snapshotNo);
        List<CarModel> beanList = null;
        try {
            beanList = goodsCarStyleMapper.selectForList(goodsCarStyle);
            //this.goodsCarStyleMapper.selectForList(bean);
        } catch (Exception e) {
            logger.error(" error skuid : {} => " + e.getMessage(), skuId);
            logger.error(e.getMessage(), e);
//            throw new RuntimeException("根据条件查询商品支持车型失败!");
        }
        return beanList;
    }

    /**
     * 查询是否为全品牌通用
     *
     * @param skuId
     * @return
     */
    @Override
    public boolean isCommon(String skuId) {
        List<String> beanList = null;
        try {
            beanList = goodsCarStyleMapper.queryBusinessAttr(skuId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("根据条件查询商品业务属性失败!");
        }
        boolean flag = true;
        if(beanList==null || beanList.size()<1){
            flag = false;
        }
        return flag;
    }

}
