package com.zgxcw.service.infrastructure.goods.dao;

import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.CarSeries;
import com.zgxcw.service.infrastructure.goods.bean.MasterBrand;
import com.zgxcw.service.infrastructure.goods.bean.SubBrand;

import java.util.List;

/**
 *
 *
 */

public interface CarStyleMapper {


    List<CarModel> selectCarStyle();

}
