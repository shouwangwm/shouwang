package com.zgxcw.service.infrastructure.goods.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zgxcw.service.infrastructure.goods.action.CarModelHandler;
import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.CarModelTree;
import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;
import com.zgxcw.service.infrastructure.goods.bean.SkuCarModelMapping;
import com.zgxcw.service.infrastructure.goods.constant.ParamConstant;
import com.zgxcw.service.infrastructure.goods.constant.ParamConstant.CarType;
import com.zgxcw.service.infrastructure.goods.constant.ParamConstant.DeletionStatus;
import com.zgxcw.service.infrastructure.goods.dao.SkuCarModelMappingMapper;
import com.zgxcw.service.infrastructure.goods.enums.CarCommonType;
import com.zgxcw.service.infrastructure.goods.service.GoodsCarStyleLargeService;
import com.zgxcw.service.infrastructure.goods.service.GoodsCarStyleService;
import com.zgxcw.service.infrastructure.goods.service.GoodsSkuService;
import com.zgxcw.service.infrastructure.goods.utils.NumberUtil;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;

/**
 * Created by wangcs on 2016/7/2.
 */
public class MergeCarModelThread implements Runnable{

    private Logger logger = LoggerFactory.getLogger(MergeCarModelThread.class);

    private AtomicLong allNums;
    private int currentPage;
    private AtomicInteger finishNums;
    private long startTime;
    private Map<String,CarModelTree> modelTreeMap;
    private GoodsSkuService goodsSkuService;
    private GoodsCarStyleService goodsCarStyleService;
    private GoodsCarStyleLargeService goodsCarStyleLargeService;
    private SkuCarModelMappingMapper skuCarModelMappingMapper;

    public MergeCarModelThread(int currentPage,AtomicInteger finishNums,AtomicLong allNums,long startTime,Map<String,CarModelTree> modelTreeMap,
                               GoodsSkuService goodsSkuService,GoodsCarStyleService goodsCarStyleService,GoodsCarStyleLargeService goodsCarStyleLargeService,
                               SkuCarModelMappingMapper skuCarModelMappingMapper){
        this.currentPage = currentPage;
        this.finishNums = finishNums;
        this.allNums = allNums;
        this.startTime = startTime;
        this.modelTreeMap = modelTreeMap;
        this.goodsSkuService = goodsSkuService;
        this.goodsCarStyleService = goodsCarStyleService;
        this.goodsCarStyleLargeService = goodsCarStyleLargeService;
        this.skuCarModelMappingMapper = skuCarModelMappingMapper;
    }

    @Override
    public void run() {
        PageInfo<GoodsSku> goodsSkuPage = goodsSkuService.queryForPage(currentPage, 100);
        List<GoodsSku> skus = goodsSkuPage.getList();

        for (GoodsSku sku : skus) {
            if(sku!=null) {
                long currentTime = System.currentTimeMillis();
                handleSmallCarModel(modelTreeMap, sku);
                handleBigCarModel(modelTreeMap, sku);
                finishNums.incrementAndGet();
                if( finishNums.get()%100==0 || finishNums.get()==allNums.get()) {
                    logger.info("-------共[{}]个商品，处理完成[{}]个商品，进度：-----{}----已用时{}秒，预计剩余时间{}秒-------", allNums, finishNums.get(),
                            NumberUtil.accuracy(finishNums.get(), allNums.get(), 2), (currentTime - startTime) / 1000, (allNums.get() - finishNums.get()) * (currentTime - startTime) / finishNums.get() / 1000);
                }
            }
        }
    }

    private void handleSmallCarModel(Map<String, CarModelTree> modelTreeMap, GoodsSku sku) {
        

        List<SkuCarModelMapping> skuCarModelMappings = null;
        //小车支持车型列表为空，在判断是否为小车品牌通用
        boolean isCommon = goodsCarStyleService.isCommon(sku.getGoodsSkuID());
        if(isCommon){
            skuCarModelMappings = new ArrayList<SkuCarModelMapping>();
            SkuCarModelMapping mapping = new SkuCarModelMapping();
            mapping.setId(new RandomGUID().toString());
            mapping.setCreateTime(System.currentTimeMillis());
            mapping.setCreatorId(ParamConstant.createUser);
            mapping.setSkuId(sku.getGoodsSkuID());
            mapping.setSnapshotNo(sku.getSnapshotNO());
            mapping.setCommonType(CarCommonType.ORDINARY.name());
            mapping.setCarType(CarType.SMALL);
            mapping.setDeletionStatus(DeletionStatus.NORMAL.getCode());;
            skuCarModelMappings.add(mapping);
        }else {
        	//查询商品所有支持的小车型
            List<CarModel> goodsCarStyles = goodsCarStyleService.queryForList(sku.getGoodsSkuID(), sku.getSnapshotNO());
            Map<String,CarModelTree> carModels = CarModelHandler.convertToCarModelTree(goodsCarStyles);
                     
            CarModelHandler.compareCarModel(carModels, modelTreeMap);

            skuCarModelMappings = CarModelHandler.getSkuCarModelMappings(carModels, sku,true);
        }
  
        saveCarModelMappings(skuCarModelMappings);
    }

    private void handleBigCarModel(Map<String, CarModelTree> modelTreeMap, GoodsSku sku) {
        List<CarModel> goodsCarStyles = goodsCarStyleLargeService.queryForList(sku.getGoodsSkuID(), sku.getSnapshotNO());
        if(goodsCarStyles==null || goodsCarStyles.size()==0){
            return;
        }

        Map<String,CarModelTree> carModels = CarModelHandler.convertToCarModelTree(goodsCarStyles);
        
//      System.out.println("======================= :" + JSON.toJSONString(carModels));
//      System.out.println("======================= :" + JSON.toJSONString(modelTreeMap));
        
        CarModelHandler.compareCarModel(carModels, modelTreeMap);

        List<SkuCarModelMapping> skuCarModelMappings = CarModelHandler.getSkuCarModelMappings(carModels, sku,false);

        saveCarModelMappings(skuCarModelMappings);
    }

    private void saveCarModelMappings(List<SkuCarModelMapping> skuCarModelMappings) {
        if(skuCarModelMappings==null || skuCarModelMappings.size()<1){
            return;
        }
		
        try{
        	
        	skuCarModelMappingMapper.insertForBatch(skuCarModelMappings);
        	
        }catch(Exception e){
        	logger.error(Thread.currentThread().getName() + " ERROR " + e.getMessage(),e);
        	e.printStackTrace();
        }
    }
}
