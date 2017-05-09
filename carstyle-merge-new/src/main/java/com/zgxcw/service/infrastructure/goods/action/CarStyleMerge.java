package com.zgxcw.service.infrastructure.goods.action;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.CarModelTree;
import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;
import com.zgxcw.service.infrastructure.goods.dao.SkuCarModelMappingMapper;
import com.zgxcw.service.infrastructure.goods.service.GoodsCarStyleLargeService;
import com.zgxcw.service.infrastructure.goods.service.GoodsCarStyleService;
import com.zgxcw.service.infrastructure.goods.service.GoodsSkuService;
import com.zgxcw.service.infrastructure.goods.thread.MergeCarModelThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wangcs on 2016/7/1.
 */
@Component
public class CarStyleMerge {

    private Logger logger = LoggerFactory.getLogger(CarStyleMerge.class);

    @Resource
    private GoodsSkuService goodsSkuService;
    @Resource
    private GoodsCarStyleService goodsCarStyleService;
    @Resource
    private GoodsCarStyleLargeService goodsCarStyleLargeService;

    @Resource
    private SkuCarModelMappingMapper skuCarModelMappingMapper;


    private AtomicInteger allPage;
    private AtomicLong allNums;
    private AtomicInteger finishNums = new AtomicInteger(0);

    private static int PAGE_SIZE = 100;

    @Value("#{configProperties['thread.count']}")
    private int threadCount;

    public void merge() {

        //查询车型库
        Map<String, CarModelTree> modelTreeMap = getCarModelTree();
        
        PageInfo<GoodsSku> goodsSkuPageInfo = goodsSkuService.queryForPage(1, PAGE_SIZE);
        int pages = goodsSkuPageInfo.getPages();
        logger.info("所有商品共【{}】页，共【{}】条，每页【{}】条", pages, goodsSkuPageInfo.getTotal(), PAGE_SIZE);
        allPage = new AtomicInteger(pages);
        allNums = new AtomicLong(goodsSkuPageInfo.getTotal());

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < pages; i++) {
            executor.execute(new MergeCarModelThread(i + 1, finishNums, allNums, startTime, modelTreeMap, goodsSkuService, goodsCarStyleService, goodsCarStyleLargeService, skuCarModelMappingMapper));
        }

        while (finishNums.get() < allNums.get()) {

        }

        long endTime = System.currentTimeMillis();
        logger.info("------操作完成------共用时{}秒-------------", (endTime - startTime) / 1000);
    }

    private Map<String, CarModelTree> getCarModelTree() {

        List<CarModel> carModels = goodsSkuService.selectCarModels();

        return CarModelHandler.convertToCarModelTree(carModels);
    }
}
