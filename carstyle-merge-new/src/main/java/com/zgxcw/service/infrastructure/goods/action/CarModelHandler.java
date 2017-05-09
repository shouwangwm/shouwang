package com.zgxcw.service.infrastructure.goods.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.zgxcw.service.infrastructure.goods.bean.CarModel;
import com.zgxcw.service.infrastructure.goods.bean.CarModelTree;
import com.zgxcw.service.infrastructure.goods.bean.GoodsSku;
import com.zgxcw.service.infrastructure.goods.bean.SkuCarModelMapping;
import com.zgxcw.service.infrastructure.goods.constant.ParamConstant;
import com.zgxcw.service.infrastructure.goods.constant.ParamConstant.CarType;
import com.zgxcw.service.infrastructure.goods.enums.CarCommonType;
import com.zgxcw.service.infrastructure.goods.thread.MergeCarModelThread;
import com.zgxcw.service.infrastructure.goods.utils.RandomGUID;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class CarModelHandler {
	
	private static Logger logger = LoggerFactory.getLogger(CarModelHandler.class);
	/**
	 * 循环得到下级车型数据
	 * @author weiming
	 * @date   2016年12月23日
	 * @param sku
	 * @param nodes
	 * @param mappings
	 * @param isSmall
	 * @param tempParam
	 */
	@SuppressWarnings("unused")
	private static void getSkuCar(GoodsSku sku,Map<String, CarModelTree> nodes, List<SkuCarModelMapping> mappings, boolean isSmall, CarModel tempParam){
		//为了让下级节点取到上级节点的id,依次往下传
		CarModel newParam = new CarModel();
		BeanUtils.copyProperties(tempParam, newParam);
		try{
			SkuCarModelMapping mapping;	
			for (CarModelTree node : nodes.values()) {
	            Map<String, CarModelTree> subNodes = node.getChildren();
	            
				switch(node.getLevel()){
				 	case 1: 
				 		newParam.setBrandId(node.getId());
				 		break;
				 	case 2:
				 		newParam.setModelId(node.getId());
				 		break;
				 	case 3:
				 		String carstyleId = node.getId();
				 		if(StringUtils.isNotBlank(carstyleId)){
				 			String attr[] = carstyleId.split("-");
				 			if(attr != null && attr.length > 0){
				 				newParam.setAttr1(attr[0]);
					 			newParam.setAttr2(attr[1]);
				 			}else{
				 				logger.info("========== not carstyleId goodsSkuId : {} , {}", sku.getGoodsSkuID(), JSON.toJSONString(newParam));
				 			}
				 		}
				 		break;
				 	default:
				 		System.out.println("node.getLevel ： " + node.getLevel());
				}
	            if (subNodes != null) {
	            	getSkuCar(sku, subNodes, mappings, isSmall, newParam);
	            } else {
	                mapping = new SkuCarModelMapping();
	                if(isSmall){
	                	mapping.setCarType(CarType.SMALL);
	                }else{
	                	mapping.setCarType(CarType.BIG);
	                }
	                
	                switch(node.getLevel()){
	                	case 1: 
	                		mapping.setCarMasterBrandId(newParam.getMasterBrandId());
	                		mapping.setCarSubBrandId(newParam.getBrandId());
	                		mapping.setCommonType(CarCommonType.SUBBRAND.name());
	                		break;
	                	case 2:
	                		mapping.setCarMasterBrandId(newParam.getMasterBrandId());
	                		mapping.setCarSubBrandId(newParam.getBrandId());
	                		mapping.setCarModelId(newParam.getModelId());
	                		mapping.setCommonType(CarCommonType.SERIES.name());
	                		break;
	                	case 3:
	                		mapping.setCarMasterBrandId(newParam.getMasterBrandId());
	                		mapping.setCarSubBrandId(newParam.getBrandId());
	                		mapping.setCarModelId(newParam.getModelId());
	                		mapping.setAttr1(newParam.getAttr1());
	                		mapping.setAttr2(newParam.getAttr2());
	                		mapping.setCommonType(CarCommonType.NONE.name());	
	                		break;
	                	default:
	                		System.out.println("node.getLevel ： " + node.getLevel());
	                }
	                mapping.setId(new RandomGUID().toString());
	                mapping.setCreateTime(System.currentTimeMillis());
	                mapping.setCreatorId(ParamConstant.createUser);
	                mapping.setSkuId(sku.getGoodsSkuID());
	                mapping.setSnapshotNo(sku.getSnapshotNO());
	                mappings.add(mapping);
	            }
	        }
		}catch(Exception e){
			logger.info(e.getMessage(), e);
		}	
	}
	
    public static List<SkuCarModelMapping> getSkuCarModelMappings(Map<String, CarModelTree> carModels, GoodsSku sku, boolean isSmall) {
        if (carModels == null || carModels.size() < 1) {
            return null;
        }

        List<SkuCarModelMapping> mappings = new ArrayList<SkuCarModelMapping>();
        SkuCarModelMapping mapping;
        CarModel tempParam;
        for (CarModelTree masterBrand : carModels.values()) {
            Map<String, CarModelTree> subBrands = masterBrand.getChildren();
            if (subBrands != null) {
            	tempParam = new CarModel();
            	tempParam.setMasterBrandId(masterBrand.getId());
                getSkuCar(sku, subBrands, mappings, isSmall, tempParam);
            } else {
                //大车全品类通用
                if (masterBrand.getLevel() == -1) {
                    mapping = new SkuCarModelMapping();
                    if(isSmall){
                    	mapping.setCarType(CarType.SMALL);
                    }else{
                    	mapping.setCarType(CarType.BIG);
                    }
                    mapping.setId(new RandomGUID().toString());
                    mapping.setCreateTime(System.currentTimeMillis());
                    mapping.setCreatorId(ParamConstant.createUser);
                    mapping.setSkuId(sku.getGoodsSkuID());
                    mapping.setSnapshotNo(sku.getSnapshotNO());
                    mapping.setCommonType(CarCommonType.INDUSTRIAL.name());
                    mappings.add(mapping);
                } else {
                    mapping = new SkuCarModelMapping();
                    if(isSmall){
                    	mapping.setCarType(CarType.SMALL);
                    }else{
                    	mapping.setCarType(CarType.BIG);
                    }
                    mapping.setCarMasterBrandId(masterBrand.getId());
                    mapping.setId(new RandomGUID().toString());
                    mapping.setCreateTime(System.currentTimeMillis());
                    mapping.setCreatorId(ParamConstant.createUser);
                    mapping.setSkuId(sku.getGoodsSkuID());
                    mapping.setSnapshotNo(sku.getSnapshotNO());
                    mapping.setCommonType(CarCommonType.MASTERBRAND.name());
                    mappings.add(mapping);
                }
            }

        }
        return mappings;

    }

    public static void compareCarModel(Map<String, CarModelTree> goodsCarModel, Map<String, CarModelTree> templateCarModel) {
        if (goodsCarModel == null) {
            return;
        }

        for (String id : goodsCarModel.keySet()) {
            CarModelTree goods = goodsCarModel.get(id);
            CarModelTree template = templateCarModel.get(id);

            if (template == null) {
                continue;
            }

            Map<String, CarModelTree> children = goods.getChildren();
            if (children != null && children.size() > 0) {
                compareCarModel(children, template.getChildren());

                boolean childCommonFlag = true;
                for (String s : children.keySet()) {
                    CarModelTree child = children.get(s);
                    if (!child.isCommon()) {
                        goods.setCommon(false);
                        childCommonFlag = false;
                        break;
                    }
                }
                if (childCommonFlag && children.keySet().containsAll(template.getChildren().keySet())) {
                    goods.setCommon(true);
                    goods.setChildren(null);
                }
            } else {
                goods.setCommon(true);
                continue;
            }
        }
    }

    /**
     * 将车型列表转换为树形结构
     * @param carModels
     * @return
     */
    public static Map<String, CarModelTree> convertToCarModelTree(List<CarModel> carModels) {
        if (carModels == null || carModels.size() < 1) {
            return null;
        }

        Map<String, CarModelTree> masterBrandMap = new HashMap<String, CarModelTree>();
        Map<String, CarModelTree> subBrandMap;
        Map<String, CarModelTree> carModelMap;
        Map<String, CarModelTree> carStyleMap;
        CarModelTree masterBrand;
        CarModelTree subBrand;
        CarModelTree carModel;
        CarModelTree carStyle;
        
        for (CarModel uplCarModel : carModels) {

            if (uplCarModel == null) {
                continue;
            }

            //大车全品类通用
            if (uplCarModel.getCommonType() != null && uplCarModel.getCommonType().equals("001")) {
                masterBrand = new CarModelTree();
                masterBrand.setCommon(true);
                masterBrand.setLevel(-1);
                masterBrandMap.put("-1", masterBrand);
                break;
            }

            //主品牌
            String masterBrandId = uplCarModel.getMasterBrandId();
            masterBrand = masterBrandMap.get(masterBrandId);
            if (masterBrand == null) {
                masterBrand = new CarModelTree();
                masterBrand.setId(masterBrandId);
                masterBrand.setLevel(0);
                masterBrandMap.put(masterBrandId, masterBrand);
            }

            //子品牌
            String subBrandId = uplCarModel.getBrandId();
            subBrandMap = masterBrand.getChildren();
            if (subBrandMap == null) {
                subBrandMap = new HashMap<String, CarModelTree>();
            }
            subBrand = subBrandMap.get(subBrandId);
            if (subBrand == null) {
                subBrand = new CarModelTree();
                subBrand.setId(subBrandId);
                subBrand.setLevel(1);
                subBrandMap.put(subBrandId, subBrand);
            }

            //车型
            String carModelId = uplCarModel.getModelId();
            carModelMap = subBrand.getChildren();
            if (carModelMap == null) {
                carModelMap = new HashMap<String, CarModelTree>();
            }
            carModel = carModelMap.get(carModelId);
            if (carModel == null) {
                carModel = new CarModelTree();
                carModel.setId(carModelId);
                carModel.setLevel(2);
                carModelMap.put(carModelId, carModel);
            }
            
            //详细信息
            String carStyleId = uplCarModel.getCarstyleId();
            carStyleMap = carModel.getChildren();
            if (carStyleMap == null) {
            	carStyleMap = new HashMap<String, CarModelTree>();
            }
            carStyle = carStyleMap.get(carStyleId);
            if (carStyle == null) {
            	carStyle = new CarModelTree();
            	carStyle.setId(carStyleId);
            	carStyle.setLevel(3);
            	carStyleMap.put(carStyleId, carStyle);
            }
            
            carModel.setChildren(carStyleMap);
            subBrand.setChildren(carModelMap);
            masterBrand.setChildren(subBrandMap);
            
        }
        
        return masterBrandMap;

    }
}
