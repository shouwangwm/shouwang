package com.zgxcw.service.infrastructure.goods.dao;

import com.zgxcw.service.infrastructure.goods.bean.*;

import java.util.List;

/**
 *
 *
 */
public interface SkuCarModelMappingMapper {


    int insert(SkuCarModelMapping skuCarModelMapping);

    void insertForBatch(List<SkuCarModelMapping> mappingsList);
}
